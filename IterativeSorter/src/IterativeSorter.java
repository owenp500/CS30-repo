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
		int minValue = arrayToSort.read(length);
		int maxValue = ArrayToSort.read()
		  for(int i = 0; i < arrayToSort.length(); i++) {
			  
		  }
	}

	public void doInsertionSort(IntegerArray arrayToSort) {
	}
	
	private void swap(int indexA, int indexB, IntegerArray arrayToSwap) {
		
	}
}
