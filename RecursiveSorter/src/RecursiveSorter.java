public class RecursiveSorter {
	
	public void doQuickSort(IntegerArray clone) {
		doQuickSort(clone, 0, clone.length() - 1);
	}
	private void doQuickSort(IntegerArray clone, int low, int high) {
		int pivot = clone.read(low);	 
		for(int left = low + 1; left < high; left++) {
			int right = high;
			
			int atLeft = clone.read(left);
			if(atLeft >= pivot) {
				int atRight = clone.read(right);
				while (atRight >= pivot && right > left) {
				right --;
				atRight = clone.read(right);
				}
				if( right > left) {
					//swap left and right pointers
					clone.write(atLeft , right);
					clone.write(atRight, left);
				}
				else {
					//swap pivot with element before left
					clone.write(clone.read(left - 1) , low);
					clone.write(pivot, left - 1);
				}
				
				
				
			}
		}
	}

	public void doMergeSort(IntegerArray array) {
		
	}

}
