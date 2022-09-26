import java.util.ArrayList;
import java.util.Arrays;
public class Merger {
	
	public int[] doMerge(int[] a, int[] b) {
		int[] ab = new int[(a.length + b.length)];
		
		for (int i = 0; i < a.length; i++) {
			ab[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			ab[i + a.length] = b[i];
		}
		 ArrayList<Integer> abList =new ArrayList<Integer>( Arrays.asList(ab));
		return ab;
	}
}
