public class IterativeSorter {
	
	public void doBubbleSort(IntegerArray arrayToSort) {
		int length = arrayToSort.length();
		int i = length;
		while(i > 0) { 
			for(int j = length - 1; j > 0; j--) {
				int read = arrayToSort.read(j);
				int nextRead = arrayToSort.read(j - 1);
				if(read < nextRead) {
					arrayToSort.write(j, nextRead);
					arrayToSort.write(j - 1, read);
				}
			}
			i--;
		}	
	}
	
	public void doSelectionSort(IntegerArray arrayToSort) {
		int length = arrayToSort.length();
		
		  for(int i = 0; i < length; i++) {
			  int minValue = arrayToSort.read(i);
			  int nextRead;
			  int indexMinValue = i;
			 for(int j = 1; j < length; j++) {
				nextRead = arrayToSort.read(j);
				if(minValue > nextRead) {
					minValue = nextRead;
					indexMinValue = j;
				}
			 }
			 arrayToSort.write(i,minValue);
			 arrayToSort.write(indexMinValue, nextRead);
		  }
	}

	public void doInsertionSort(IntegerArray arrayToSort) {
	}
	
	private void swap(int indexA, int indexB, IntegerArray arrayToSwap) {
		
	}
}
