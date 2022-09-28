import junit.framework.TestCase;
public class SortDebugger extends TestCase{
	private IterativeSorter sorter = new IterativeSorter();
	
	public void testBubbleSorter() { 
		int[] array = {4,3,7,4,4,5};
		IntegerArray intArray = new IntegerArray(array);
		sorter.doBubbleSort(intArray);
		assertEquals(3,intArray.read(0));
		
	}
}
