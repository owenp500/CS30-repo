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
		//check for base case
		
		//create two sub arrays
		
		//doMergeSort recursively until length of one
		
		//coming out of recursion doMerge function all the way up the stacks
		
		
	}
	public int[] doMerge(int[] a, int[] b) {
		if (a == null && b == null) {
			return new int[0];
		}
		else if (a == null) {
			return b;
		}
		else if(b == null) {
			return a;
		}
		int[] ab = new int[a.length + b.length];	
		int iA = 0;
		int iB = 0;
		int j = 0;
		while (iA < a.length && iB < b.length) {
			if(a[iA] < b[iB]) {
				ab[j] = a[iA];
				iA++;
			}
			else {
				ab[j] = b[iB];
				iB++;
			}
			j++;
		}
		while (iA < a.length) {
			ab[j] = a[iA];
			iA++;
			j++;
		}
		while (iB < b.length) {
			ab[j] = b[iB];
			iB++;
			j++;
		}
		return ab;
	}
}
