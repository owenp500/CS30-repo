public class Merger {
	
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
