
public class IterativeSearcher {

	public int doBinarySearch(IntegerArray arrayToSearch, int i) {
		int low = 0;
		int high = arrayToSearch.length();
		while (low < high) {
			int mid = (low + high)/2;
			int j = arrayToSearch.read(mid);
			if (i == j) {
				for(int x = 0; x < (mid - low); x++) {
					if (arrayToSearch.read(mid - x - 1) != i) {
						return mid - x;
					}
				}
			}
			else if(i > j) {
				low = mid + 1;
			}
			else {
			high = mid - 1;
			}
		}
		return - 1;
		
	}
}
	/*
int length = arrayToSort.length();
		int stake = ((length) / 2);
		
		for (int j = 0; j < length; j++) {
			int y = arrayToSort.read(stake);
			
			int difference = ((Math.floor(length/Math.pow(2,(j + 2)))) == 0) ? 1: 
				(int) (length/Math.pow(2,(j + 2)));
			if (Math.floor(length/Math.pow(2, j)) == 0) {
				difference = 1;
			}
			if(i < y) { 
				stake -= difference;
			}
			else if (i > y) {
				stake  += difference;
			}
			else { 
				return stake; 
			}
		}
		return -1;
	}
*/