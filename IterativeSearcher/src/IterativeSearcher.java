
public class IterativeSearcher {

	public int doBinarySearch(IntegerArray arrayToSort, int i) {
		int x = arrayToSort.length() / 2;
		for (int j = 0; j < arrayToSort.length(); j++) {
			int y = arrayToSort.read(x);
			if(i < y) { 
				x = x - (x/2);
			}
			else if (i > y) {
				x = x + (x/2);
			}
			else { 
				return x; 
			}
		}
		return 0;
	}

}
