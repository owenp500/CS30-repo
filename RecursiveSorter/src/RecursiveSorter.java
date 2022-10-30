public class RecursiveSorter {
	
	public void doQuickSort(IntegerArray clone) {
		int pivot = clone.read(0);
		for(int left = 1; left < clone.length(); left++) {
			int right = clone.length() - 1;
			
			int atLeft = clone.read(left);
			if(atLeft >= pivot) {
				int atRight = clone.read(right);
				while (atRight >= pivot) {
				right --;
				atRight = clone.read(right);
				}
				//swap left and right pointers
				clone.write(atLeft , right);
			    clone.write(atRight, left);
			}
		}
		
	}
	public void doQuicksort(integerArray clone, int ) {
		
	}

	public void doMergeSort(IntegerArray array) {
		
	}

}
