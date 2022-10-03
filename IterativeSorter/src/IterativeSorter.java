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
			  int firstValue =  arrayToSort.read(i);
			  int minValue = firstValue;
			  int nextRead;
			  int indexMinValue = i;
			 for(int j = i; j < length; j++) {
				nextRead = arrayToSort.read(j);
				if(minValue > nextRead) {
					minValue = nextRead;
					indexMinValue = j;
				}
			 } 
			 arrayToSort.write(i,minValue);
			 arrayToSort.write(indexMinValue, firstValue);
		  }
	}

	public void doInsertionSort(IntegerArray arrayToSort) {
		int length = arrayToSort.length();
		for(int i = 0; i < length; i++) {
			  
			 for(int j = i; j < length; j++) {
				
				
			 } 
			 
		  }
	}
	
	private void swap(int indexA, int indexB, IntegerArray arrayToSwap) {
		
	}
}
