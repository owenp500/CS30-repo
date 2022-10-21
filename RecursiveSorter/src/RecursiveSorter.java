import java.util.Random;

public class RecursiveSorter {
	
	public void doQuickSort(IntegerArray clone) {
		
		Random rand = new Random();
		int pivotIndex = rand.nextInt(0, clone.length() - 1);
		int pivot = clone.read(pivotIndex);
		IntegerArray lowerArray;
		IntegerArray higherArray;
		for(int i = 0; i < pivotIndex; i++) {
			if(clone.read(i) < pivot) {
				lowerArray.write(, i);
			}
			else { 
				//put into higher half array or sum
			}
		}
		for(int i = pivotIndex + 1; i < clone.length(); i++) {
			if (clone.read(i) < pivot) {
				
			}
			else {
				
			}
		}
		
		
		
	}

	public void doMergeSort(IntegerArray array) {
	}

}
