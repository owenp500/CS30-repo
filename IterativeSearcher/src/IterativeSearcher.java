
public class IterativeSearcher {

	public int doBinarySearch(IntegerArray arrayToSearch, int i) {
		int low = 0;
		int high = arrayToSearch.length();
		while (low < high) {
			int mid = (low + high)/2;
			int j = arrayToSearch.read(mid);
			if (i == j) {
				for(int x = 0; x < (high - low); x++) {
					int lowerIndex = (mid - x - 1 < 0) ? 0: mid - x - 1; 
					if (arrayToSearch.read(lowerIndex) != i || lowerIndex == 0) {
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