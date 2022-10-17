
public class RecursiveSearcher {
	public RecursiveSearcher() {		
	}

	public int doBinarySearch(IntegerArray arrayOfInts, int target) {
		int high = arrayOfInts.length();
		return doBinarySearch(arrayOfInts, target, 0, high);
	}
	private int doBinarySearch(IntegerArray arrayOfInts, int target, int low,int high) {
		int mid  = (high + low) / 2;
		int midValue = arrayOfInts.read(mid);
		if( midValue == target) {
			int nextValue = (doBinarySearch(arrayOfInts, target, mid -1, mid -1));
			if (nextValue == -1) {
				return mid;
			}
			else { return nextValue; }
		}
		else if(midValue < target) {
			return doBinarySearch(arrayOfInts, target, mid, high);
		}
		else if (midValue >target) {
			return  doBinarySearch(arrayOfInts, target, low, mid); 
		}
		return -1;
	}
	
}
