
public class HelpfulLittleGuy {
	static SorterUtilities util = new SorterUtilities();
	public static void main(String[] args) {
		IntegerArray arr = util.createRandomArray(10);
		
		System.out.println("original array:");
		for(int i = 0; i < arr.length(); i++) {
			System.out.printf("%d  ", arr.read(i));
		}
		System.out.println("\n\npartitioned array");
		doPartition(arr,0,9);
		for(int i = 0; i < arr.length(); i++) {
			System.out.printf("%d  ", arr.read(i));
		}
		
	}
	private static void doPartition(IntegerArray clone, int low, int high) {
		int pivot = clone.read(low);
		int right = high;	 
		for(int left = low + 1; left < high; left++) {
			
			
			int atLeft = clone.read(left);
			if(atLeft >= pivot) {
				int atRight = clone.read(right);
				while (atRight >= pivot && right > left) {
				right --;
				atRight = clone.read(right);
				}
				if( right > left) {
					//swap left and right pointers
					clone.write(right , atLeft);
					clone.write(left, atRight);
				}
				else {
					//swap pivot with element before left
					clone.write(low ,clone.read(left - 1) );
					clone.write(left - 1,pivot );
					break;
				}
				

				
			}
			
		}
			if(high - low >= 1) {
			doPartition(clone, right,high);
			doPartition(clone, low, right - 2);
		}
			
	}
}
