public class RecursiveSorter {
	
	public void doQuickSort(IntegerArray clone) {
		doQuickSort(clone, 0, clone.length() - 1);
	}
	private void doQuickSort(IntegerArray clone, int low, int high) {
		int pivot = clone.read(low);
		int right = high;
		if((high - low) > 1) {
		for(int left = low + 1; left <= high; left++) {	
			int atLeft = clone.read(left);
			if(atLeft >= pivot || left == right) {
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
			doQuickSort(clone,right, high);
			doQuickSort(clone, low, right - 2);
		}
	}

	public void doMergeSort(IntegerArray array) {
		
	}

}
