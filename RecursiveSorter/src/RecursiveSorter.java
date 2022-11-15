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
			
			//coming out of recursion doMerge all the way up 
			doMerge(lowIntArray, highIntArray, array);
		}
	} 
	public void doMerge(IntegerArray a, IntegerArray b, IntegerArray arr) {
		int iA = 0;		
		int iB = 0;
		int j = 0;
		while (iA < a.length() && iB < b.length()) {
		if(a.read(iA) < b.read(iB)) {
			arr.write(j, a.read(iA));
			iA++;
		}
		else {
			arr.write(j, b.read(iB));
			iB++;
		}
		j++;
		}
		while (iA < a.length()) {
			arr.write(j, a.read(iA));
			iA++;
			j++;
		}
		while (iB < b.length()) {		
			arr.write(j, b.read(iB));
			iB++;
			j++;
		}
	}
}
