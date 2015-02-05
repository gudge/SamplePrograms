// http://www.geeksforgeeks.org/print-increasing-sequences-length-k-first-n-natural-numbers/

// 1 2
// 1 3
// 2 3
// 


public class Sortarray {
	public static void main(String[] args) {
		final int k = 2;
		final int n = 3;
		//foo2(k, n);
		
		foo_permutations();
	}

	String swap(final String str, final int i, final int j) {
		if (i == j)
			return str;
		StringBuilder str2 = new StringBuilder(str);
		char t1 = str.charAt(i);
		str2.setCharAt(i, str.charAt(j));
		str2.setCharAt(j, t1);
		return str2.toString();
	}
	private static void foo_permutations() {
		// http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
		String str = "abc";
		// Fixed positions; 
		foo4(0, str);
		
	}

	private static void foo4(final int fixed, final String str) {
		System.out.println(str);
		// 0 means no fixed
		for (int i = 0, l = str.length(); i < l; i++) {
			
		}
	}

	private static void foo2(final int k, final int n) {
		// 1. Select a number starting from 
		
		int [] a = new int[k];
		for (int i = 0; i < k; i++) {
			a[i] = i+1;
		}
		print(a);
		for (int i = 0, l = a.length; i < l; i++) {
			
		}
		
	}

	private static void print(final int[] a) {
		for (int i = 0 , l = a.length; i < l; i++) {
			System.out.print(a[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
}