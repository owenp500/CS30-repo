import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicFileOperationsTest {

	static final String INPUT_FOR_READ = "input/input-for-read.txt";

	static final String EXPECTED_FROM_WRITE = "expected/expected-from-write.txt";
	static final String EXPECTED_FROM_APPEND = "expected/expected-from-append.txt";

	
	static final String OUTPUT_FROM_WRITE = "output/output-from-write.txt";
	static final String OUTPUT_FROM_APPEND = "output/output-from-append.txt";
	static final String OUTPUT_FROM_COPY = "output/output-from-copy.txt";

	static final String NON_EXISTENT_FILE = "non-existent-file.txt";
	static final String CRLF = "\r\n";

	static final String CONTENT_FOR_READ = "To be, or not to be, that is the question:Whether 'tis nobler in the mind to sufferThe slings and arrows of outrageous fortune,Or to take Arms against a Sea of troubles";
	static final String CONTENT_FOR_READ_CRLF = "To be, or not to be, that is the question:" + CRLF
			+ "Whether 'tis nobler in the mind to suffer" + CRLF
			+ "The slings and arrows of outrageous fortune," + CRLF
			+ "Or to take Arms against a Sea of troubles" + CRLF;

	static BasicFileOperations bfo;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bfo = new BasicFileOperations();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	//When dealing with text files, you will often need to decide what to do with
	//line breaks in the input file.
	//This test looks for a method that will read an input file and 'consumes'
	//line breaks. i.e. the return String should include no line breaks. This is actually
	//a fairly easy thing to do.
	public void testRead() {
				
		assertEquals(CONTENT_FOR_READ, bfo.readFile(INPUT_FOR_READ));
		
		try {
			assertEquals("", bfo.readFile(NON_EXISTENT_FILE));
		} catch (Exception e) {
			fail("unhandled exception:" + e.getClass().toString());
		}
		
	}

	@Test
	//This test looks for a method that will read an input file without 'consuming'
	//line breaks. i.e. the return String should include the line breaks as they
	//existed in the file.
	public void testReadWithCrLf() {
	
		/*
		Carriage return means to return to the beginning of the current line without
		advancing downward. The name comes from a printer's carriage, as monitors were
		rare when the name was coined. This is commonly escaped as "\r", abbreviated CR,
		and has ASCII value 13 or 0x0D.
		
		Linefeed means to advance downward to the next line; however, it has been
		repurposed and renamed. Used as "newline", it terminates lines (commonly
		confused with separating lines). This is commonly escaped as "\n", abbreviated
		LF or NL, and has ASCII value 10 or 0x0A. CRLF (but not CRNL) is used for the
		pair "\r\n".
				
		As control characters, they may be interpreted in various ways.
		
		The most common difference (and probably the only one worth worrying about) is
		lines end with CRLF on Windows, NL on Unix-likes, and CR on older Macs (the
		situation has changed with OS X to be like Unix). Note the shift in meaning from
		LF to NL, for the exact same character, gives the differences between Windows
		and Unix. (Windows is, of course, newer than Unix, so it didn't adopt this
		semantic shift. I don't know the history of Macs using CR.) Many text editors
		can read files in any of these three formats and convert between them, but not
		all utilities can.
		https://stackoverflow.com/questions/3091524/what-are-carriage-return-linefeed-and-form-feed
		 */
		
		assertEquals(CONTENT_FOR_READ_CRLF, bfo.readFileWithCRLF(INPUT_FOR_READ));
		
		try {
			assertEquals("", bfo.readFile(NON_EXISTENT_FILE));
		} catch (Exception e) {
			fail("unhandled exception:" + e.getClass().toString());
		}
		
	}
	
	@Test
	public void testWrite() {
		String[] macbeth_5_8 = new String[] {
		"I will not yield,", 
		"To kiss the ground before young Malcolm's feet,",
		"And to be baited with the rabble's curse.",
		"Though Birnam wood be come to Dunsinane,",
		"And thou opposed, being of no woman born,",
		"Yet I will try the last. Before my body",
		"I throw my warlike shield. Lay on, Macduff,",
		"And damn'd be him that first cries, 'Hold, enough!'",
		};
				
		deleteFile(OUTPUT_FROM_WRITE);

		//NOTE: output file is expected to have no extra CRLF
		//(i.e. only print a CRLF if there is a next line)
		bfo.writeFile(OUTPUT_FROM_WRITE, macbeth_5_8);
		
		try {
			byte[] expected = Files.readAllBytes(Paths.get(EXPECTED_FROM_WRITE));
			byte[] actual = Files.readAllBytes(Paths.get(OUTPUT_FROM_WRITE));
			assertEquals(new String(expected), new String(actual));
		} catch (IOException e) {
			fail(e.getClass().toString());
		}		
		
	}
	
	@Test
	public void testAppend() {

		deleteFile(OUTPUT_FROM_APPEND);
		
		bfo.appendFile(OUTPUT_FROM_APPEND, "Blow, winds, and crack your cheeks! rage! blow!");
		bfo.appendFile(OUTPUT_FROM_APPEND, "You cataracts and hurricanoes, spout");
		bfo.appendFile(OUTPUT_FROM_APPEND, "Till you have drench'd our steeples, drown'd the cocks!");
		bfo.appendFile(OUTPUT_FROM_APPEND, "You sulphurous and thought-executing fires,");
		bfo.appendFile(OUTPUT_FROM_APPEND, "Vaunt-couriers to oak-cleaving thunderbolts,");
		bfo.appendFile(OUTPUT_FROM_APPEND, "Singe my white head! And thou, all-shaking thunder,");
		bfo.appendFile(OUTPUT_FROM_APPEND, "Smite flat the thick rotundity o' the world!");
		bfo.appendFile(OUTPUT_FROM_APPEND, "Crack nature's moulds, an germens spill at once,");
		bfo.appendFile(OUTPUT_FROM_APPEND, "That make ingrateful man!");

		try {
			byte[] expected = Files.readAllBytes(Paths.get(EXPECTED_FROM_APPEND));
			byte[] actual = Files.readAllBytes(Paths.get(OUTPUT_FROM_APPEND));
			assertEquals(new String(expected), new String(actual));
		} catch (IOException e) {
			fail(e.getClass().toString());
		}		
		
	}
	
	private static void deleteFile(String file) {
		Path path = Paths.get(file);
		//clear destination files
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}		
	}
	

	
}
