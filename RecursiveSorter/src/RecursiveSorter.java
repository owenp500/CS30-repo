public class RecursiveSorter {
	
	public void doQuickSort(IntegerArray clone) {
		doQuickSort(clone, 0, clone.length() - 1);
	}
	private void doQuickSort(IntegerArray clone, int low, int high) {
		int pivot = clone.read(low);
		int right = high;
		if((high - low) >= 1) {
		for(int left = low + 1; left <= high; left++) {	
			int atLeft = clone.read(left);
			if (left == right && atLeft < pivot) {
				//placing pivot into correct index
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
					//placing the pivot into correct index
					clone.write(low ,clone.read(left - 1) );
					clone.write(left - 1,pivot );
					break;
				}				
			}	
		}
			//partitioning recursively to the right of where pivot was placed
			doQuickSort(clone, right,high);
			//partitioning recursively to the left of where the pivot was placed
			doQuickSort(clone, low, right - 1);
		}
	}

	public void doMergeSort(IntegerArray array) {
		
	}

}
