
public class HelpfulLittleGuy {
	static SorterUtilities util = new SorterUtilities();
	public void main(String[] args) {
		int arraySize = 10;
		IntegerArray arr = util.createRandomArray(arraySize);
		for(int i = 0; i < arraySize; i++) {
			System.out.printf("%d ", arr.read(i));
		}
		
//		doMerge(arr);
		System.out.println();
		for(int i = 0; i < arraySize; i++) {
			System.out.printf("%d ", arr.read(i));
		}
	}
	private void doMergeSort(IntegerArray array) {
		if(array.length() > 1) {
			int mid = array.length() /2;
			//create two sub arrays
			int[] lowArray = new int[mid];
			for(int i = 0; i < mid; i++) {
				lowArray[i] = array.read(i);
			}
			int[] highArray = new int[array.length() - mid];
			for(int i = mid; i < array.length(); i ++) {
				highArray[i - mid] = array.read(i);
			}
			IntegerArray lowIntArray = new IntegerArray(lowArray);
			IntegerArray highIntArray = new IntegerArray(highArray);
			//doMergeSort recursively until length of one
			doMergeSort(lowIntArray);
			doMergeSort(highIntArray);
			
			//coming out of recursion doMerge function all the way up 
			doMerge(lowIntArray, highIntArray, array);
		}
	} 
	public int[] doMerge(IntegerArray a, IntegerArray b, IntegerArray arr) {
		int[] ab = new int[a.length() + b.length()];
		int iA = 0;		
		int iB = 0;
		int j = 0;
		while (iA < a.length() && iB < b.length()) {
		if(a.read(iA) < b.read(iB)) {
			ab[j] = a.read(iA);
			iA++;
		}
		else {
			ab[j] = b.read(iB);
			iB++;
		}
		j++;
		}
		while (iA < a.length()) {
			ab[j] = a.read(iA);
			iA++;
			j++;
		}
		while (iB < b.length()) {
			ab[j] = b.read(iB);
			iB++;
			j++;
		}
		return ab;
	}
	
	@SuppressWarnings("unused")
	private static void doPartition(IntegerArray clone, int low, int high) {
		int pivot = clone.read(low);
		int right = high;
		if((high - low) >= 1) {
		for(int left = low + 1; left <= high; left++) {	
			int atLeft = clone.read(left);
			if (left == right && atLeft < pivot) {
				//swap pivot with left/right pointer
				clone.write(low ,clone.read(left ) );
				clone.write(left ,pivot );
				break;
			}
			if(atLeft >= pivot ||left == right) {
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
			doPartition(clone, right,high);
			doPartition(clone, low, right - 1);
		}
	}
}
