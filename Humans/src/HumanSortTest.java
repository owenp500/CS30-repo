//2021/10/02
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import junit.framework.TestCase;

public class HumanSortTest extends TestCase {
		
	private Human[] createHumans() {
		int graduateBirthYear = LocalDateTime.now().getYear() - 18;
		String schoolName = "William Aberhart High School";
		Human[] humans = {				
				new Adult(1934, 11, 7, "Folco", "Gaukrogers", Gender.MALE, schoolName, "Principal"),				
		 		new WilliamAberhartStudent(graduateBirthYear, 6, 4, "Banazir", "Rumble", Gender.MALE, 12, 310, "Wehnes"),
				new Youth(graduateBirthYear, 11, 17, "Munderic", "Wanderfoot", Gender.MALE, 12, schoolName),
				new Adult(1946, 4, 23, "Ceufroy", "Longbottom", Gender.MALE, schoolName, "Teacher"),
				new Youth(1931, 8, 20, "Meginhard", "Chubb", Gender.MALE, 12, schoolName),
				new Youth(graduateBirthYear, 12, 16, "Tolman", "Burns", Gender.MALE, 12, schoolName),
				new Adult(1901, 3, 14, "Fulvus", "Hayward", Gender.MALE, schoolName, "Teacher"),
				new Adult(1946, 1, 3, "Charles ", "Silverstring", Gender.MALE, schoolName, "Teacher"),
				new Adult(1943, 4, 16, "Berenger", "Featherbottom", Gender.MALE, schoolName, "Teacher"),
				new Adult(1926, 7, 14, "Waltgaud", "Headstrong", Gender.MALE, schoolName, "Librarian"),
				new WilliamAberhartStudent(graduateBirthYear, 6, 3, "Neela", "Burrowes", Gender.FEMALE, 12, 304, "Brunelle"),
				new Youth(graduateBirthYear, 12, 16, "Alura", "Rumblebelly", Gender.FEMALE, 0, schoolName),
				new Adult(1948, 12, 24, "Liutgarde", "Sackville", Gender.FEMALE, schoolName, "Teacher"),
				new Youth(graduateBirthYear - 18, 3, 17, "Belinda", "Brockhouse", Gender.FEMALE, 12, schoolName),
				new Adult(1921, 9, 16, "Esmeralda", "Longfoot", Gender.FEMALE, schoolName, "Teacher"),
				new Youth(graduateBirthYear, 7, 21, "Lauren", "Langham", Gender.FEMALE, 12, schoolName),
				new Youth(graduateBirthYear, 5, 31, "Esmeralda", "Fairbairn", Gender.FEMALE, 12, schoolName),
				new Adult(1936, 1, 20, "Nantechildis", "Tunnelly", Gender.FEMALE, schoolName, "Councilor"),
				new WilliamAberhartStudent(graduateBirthYear, 12, 19, "Marcovefa", "Bunce", Gender.FEMALE, 12, 301, "Marshall"),
				new Adult(1968, 5, 27, "Hamesindis", "Fallohide", Gender.FEMALE, schoolName, "Facility Operator")
		};
		return humans;
	}
	
	public void testAgeOrder() {

		Comparator<Human> ageOrder = Human.AGE_ORDER;
		Human human1 = new Human(1965, 1, 1, "Older", "Longtooth", Gender.FEMALE);
		Human human2 = new Human(1965, 6, 1, "Younger", "Babyface", Gender.FEMALE);
		
		assertEquals(true, ageOrder.compare(human1,human2) < 0);		
		assertEquals(true, ageOrder.compare(human2,human1) > 0);		
		assertEquals(true, ageOrder.compare(human1,human1) == 0);				
	}

	public void testAssemblyOrder() {

		Comparator<Human> assemblyOrder = Human.ASSEMBLY_ORDER;
		Human human = new Human(1998, 04, 26, "Sine", "Nomine", Gender.FEMALE);
		Adult adult = new Adult(1998, 04, 26, "Sine", "Nomine", Gender.FEMALE,"Some Company", "Some Job");
		Youth youth = new Youth(1998, 04, 26, "Sine", "Nomine", Gender.FEMALE, 12, "Some School");
		
		WilliamAberhartStudent abeStudent = new WilliamAberhartStudent(1998, 04, 26, "Sine", "Nomine", Gender.FEMALE, 12, 310, "Wehnes");;
		
		assertEquals(true, assemblyOrder.compare(abeStudent,youth) < 0);		
		assertEquals(true, assemblyOrder.compare(youth,adult) < 0);		
		assertEquals(true, assemblyOrder.compare(adult,human) < 0);				

		assertEquals(true, assemblyOrder.compare(youth, abeStudent) > 0);		
		assertEquals(true, assemblyOrder.compare(adult,youth) > 0);		
		assertEquals(true, assemblyOrder.compare(human, adult) > 0);				

		assertEquals(true, assemblyOrder.compare(abeStudent, abeStudent) == 0);		
		assertEquals(true, assemblyOrder.compare(youth,youth) == 0);		
		assertEquals(true, assemblyOrder.compare(adult, adult) == 0);				
		assertEquals(true, assemblyOrder.compare(human, human) == 0);				

	}

	public void testNameOrder() {

		Comparator<Human> nameOrder = Human.NAME_ORDER;
		Human human1 = new Human(1965, 1, 1, "Agamemnon", "Aaron", Gender.MALE);
		Human human2 = new Human(1965, 6, 1, "Zebulon", "Zyzyk", Gender.MALE);
		Human human3 = new Human(1965, 6, 1, "Zephyr", "Zyzyk", Gender.MALE);
		
		assertEquals(true, nameOrder.compare(human1,human2) < 0);		
		assertEquals(true, nameOrder.compare(human2,human1) > 0);		
		assertEquals(true, nameOrder.compare(human1,human1) == 0);
		assertEquals(true, nameOrder.compare(human2,human3) < 0);		
		assertEquals(true, nameOrder.compare(human3,human2) > 0);				
		
		Human human4 = new Human(1965, 6, 1, "Zak", "Smith", Gender.MALE);
		Human human5 = new Human(1965, 6, 1, "John", "Smith-Jones", Gender.MALE);
		assertEquals(true, nameOrder.compare(human4,human5) < 0);				
		
	}

	public void testSortByAge() {

		Comparator<Human> c = Human.AGE_ORDER;
		Human[] humans = createHumans();
		
        Arrays.sort(humans, c);

        System.out.println("\ntestSortByAge");
        printHumans(humans);

		assertEquals("Hayward", humans[0].getLastName());
		assertEquals("Longfoot", humans[1].getLastName());
		assertEquals("Headstrong", humans[2].getLastName());
		assertEquals("Chubb", humans[3].getLastName());
		assertEquals("Gaukrogers", humans[4].getLastName());
		assertEquals("Tunnelly", humans[5].getLastName());
		assertEquals("Featherbottom", humans[6].getLastName());
		assertEquals("Silverstring", humans[7].getLastName());
		assertEquals("Longbottom", humans[8].getLastName());
		assertEquals("Sackville", humans[9].getLastName());
		assertEquals("Fallohide", humans[10].getLastName());
		assertEquals("Brockhouse", humans[11].getLastName());
		assertEquals("Fairbairn", humans[12].getLastName());
		assertEquals("Burrowes", humans[13].getLastName());
		assertEquals("Rumble", humans[14].getLastName());
		assertEquals("Langham", humans[15].getLastName());
		assertEquals("Wanderfoot", humans[16].getLastName());
		assertEquals("Burns", humans[17].getLastName());
		assertEquals("Rumblebelly", humans[18].getLastName());
		assertEquals("Bunce", humans[19].getLastName());

		
	}

	public void testSortByName() {

		Comparator<Human> c = Human.NAME_ORDER;
		Human[] humans = createHumans();
		
        Arrays.sort(humans, c);

        System.out.println("\ntestSortByName");
        printHumans(humans);
		
		assertEquals("Brockhouse", humans[0].getLastName());
		assertEquals("Bunce", humans[1].getLastName());
		assertEquals("Burns", humans[2].getLastName());
		assertEquals("Burrowes", humans[3].getLastName());
		assertEquals("Chubb", humans[4].getLastName());
		assertEquals("Fairbairn", humans[5].getLastName());
		assertEquals("Fallohide", humans[6].getLastName());
		assertEquals("Featherbottom", humans[7].getLastName());
		assertEquals("Gaukrogers", humans[8].getLastName());
		assertEquals("Hayward", humans[9].getLastName());
		assertEquals("Headstrong", humans[10].getLastName());
		assertEquals("Langham", humans[11].getLastName());
		assertEquals("Longbottom", humans[12].getLastName());
		assertEquals("Longfoot", humans[13].getLastName());
		assertEquals("Rumble", humans[14].getLastName());
		assertEquals("Rumblebelly", humans[15].getLastName());
		assertEquals("Sackville", humans[16].getLastName());
		assertEquals("Silverstring", humans[17].getLastName());
		assertEquals("Tunnelly", humans[18].getLastName());
		assertEquals("Wanderfoot", humans[19].getLastName());
		
	}
	
	public void testSortByAsemblyOrder() {

		Comparator<Human> c = Human.ASSEMBLY_ORDER;
		Human[] humans = createHumans();
		System.out.println("\n unsorted humans");
		printHumans(humans);
        Arrays.sort(humans, c);

        System.out.println("\ntestSortByAsemblyOrder");
        printHumans(humans);

		assertEquals("Bunce", humans[0].getLastName());
		assertEquals("Burrowes", humans[1].getLastName());
		assertEquals("Rumble", humans[2].getLastName());
		assertEquals("Brockhouse", humans[3].getLastName());
		assertEquals("Burns", humans[4].getLastName());
		assertEquals("Chubb", humans[5].getLastName());
		assertEquals("Fairbairn", humans[6].getLastName());
		assertEquals("Langham", humans[7].getLastName());
		assertEquals("Rumblebelly", humans[8].getLastName());
		assertEquals("Wanderfoot", humans[9].getLastName());
		assertEquals("Fallohide", humans[10].getLastName());
		assertEquals("Featherbottom", humans[11].getLastName());
		assertEquals("Gaukrogers", humans[12].getLastName());
		assertEquals("Hayward", humans[13].getLastName());
		assertEquals("Headstrong", humans[14].getLastName());
		assertEquals("Longbottom", humans[15].getLastName());
		assertEquals("Longfoot", humans[16].getLastName());
		assertEquals("Sackville", humans[17].getLastName());
		assertEquals("Silverstring", humans[18].getLastName());
		assertEquals("Tunnelly", humans[19].getLastName());
		
	}

	public void testComparable() {
		
		Human[] humans = createHumans();
		ArrayList<Human> humansList = new ArrayList<Human>(Arrays.asList(humans));
		
		humansList.sort(null);
		Human[] sortedHumans = new Human[humansList.size()];
		humansList.toArray(sortedHumans);
		
        System.out.println("\ntestComparable");
        printHumans(sortedHumans);
				
		assertEquals("Hayward", sortedHumans[0].getLastName());
		assertEquals("Longfoot", sortedHumans[1].getLastName());
		assertEquals("Headstrong", sortedHumans[2].getLastName());
		assertEquals("Chubb", sortedHumans[3].getLastName());
		assertEquals("Gaukrogers", sortedHumans[4].getLastName());
		assertEquals("Tunnelly", sortedHumans[5].getLastName());
		assertEquals("Featherbottom", sortedHumans[6].getLastName());
		assertEquals("Silverstring", sortedHumans[7].getLastName());
		assertEquals("Longbottom", sortedHumans[8].getLastName());
		assertEquals("Sackville", sortedHumans[9].getLastName());
		assertEquals("Fallohide", sortedHumans[10].getLastName());
		assertEquals("Brockhouse", sortedHumans[11].getLastName());
		assertEquals("Fairbairn", sortedHumans[12].getLastName());
		assertEquals("Burrowes", sortedHumans[13].getLastName());
		assertEquals("Rumble", sortedHumans[14].getLastName());
		assertEquals("Langham", sortedHumans[15].getLastName());
		assertEquals("Wanderfoot", sortedHumans[16].getLastName());
		assertEquals("Burns", sortedHumans[17].getLastName());
		assertEquals("Rumblebelly", sortedHumans[18].getLastName());
		assertEquals("Bunce", sortedHumans[19].getLastName());
		
	}
	
	private void printHumans(Human[] humans) {
		System.out.println("----------------");
	
		for (int i = 0; i < humans.length; i++) {
			System.out.println(toFullDescriptionString(humans[i]));			
		}
	}
		
	private String toFullDescriptionString(Human h) {
		return String.format("%-20s%-20s%-25s (%04d/%02d/%02d)", h.getLastName(), h.getFirstName(), h.getClass().getName(), h.getBirthYear(), h.getBirthMonth(), h.getBirthDay());				
	}
	
}