import java.lang.Math;
public class IterativeSearcher {

	public int doBinarySearch(IntegerArray arrayToSort, int i) {
		int length = arrayToSort.length();
		int stake = ((length) / 2);
		
		for (int j = 0; j < length; j++) {
			int y = arrayToSort.read(stake);
			int difference = ((Math.floor(length/Math.pow(2,(j + 2)))) == 0) ? 1: 
				(int) (length/Math.pow(2,(j + 2)));
			
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

}
