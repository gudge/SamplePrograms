// http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/

class Solutions {	
	private static void printArray(String pattern, int[] arr) {
		if (true)
			return;
		System.out.println(pattern);
		System.out.print("  ");
		for (int i = 0; i < arr.length; i++) {
			if (i < 10)
				System.out.print(' ');
			System.out.print(i);
			System.out.print(' ');
		}
		System.out.println();
		System.out.print("  ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(' ');
			System.out.print(pattern.charAt(i));
			System.out.print(' ');
		}
		System.out.println();
		System.out.print("  ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(' ');
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
	}

	private static int[] getFailureTable(String pattern) {
		int[] failure_table = new int[pattern.length()];
		final int NOSUFFIX = 0;
		for (int i = 0, len = pattern.length(); i < len; i++) {
			failure_table[i] = NOSUFFIX;
		}

		// Hence failure_table[i] is exactly the length of the longest possible proper
		// initial segment of W which is also a segment of the substring ending at pattern[i - 1].

		// Proper prefix: All the characters in a string, with one or more cut off the end.
		// Proper suffix: All the characters in a string, with one or more cut off the beginning.

		for (int i = 2, len = pattern.length(); i < len; i++) {
			int j = failure_table[i-2];
			if (pattern.charAt(i-1) == pattern.charAt(j)) {
				failure_table[i-1] = failure_table[i-2] + 1;
			}
		}
		int len = pattern.length() - 1;
		if (pattern.charAt(len) == pattern.charAt(failure_table[len])) {
			failure_table[len] = failure_table[len] +1;
		}
		printArray(pattern, failure_table);
		return failure_table;
	}
	public static void main(String[] args) {		
		//String text = "ABC ABCDAB ABCDABCDABDE";
		//String pattern1 = "ABCDABD";
		//String pattern2 = "abababca";
		//String pattern3 = "PARTICIPATE IN PARACHUTE";

		//String text = "abacaabacc";
		//String pattern = "abacab";
		
		//String text = "THIS IS A TEST TEXT";
		//String pattern = "TEST";
		
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		
		int[] failureTable = getFailureTable(pattern);
		//failureTable = getFailureTable(pattern2);
		//failureTable = getFailureTable(pattern3);
		outer: for (int i = 0, j = 0, m = 0, lenp = pattern.length(), lent = text.length();lenp - j + i <= lent;) {
			if (pattern.charAt(j) == text.charAt(i)) {
				if (j == lenp - 1) {
					System.out.println("Pos =  " + m);
					System.out.println("Match\n");
					for (i = m, j = 0; j < lenp; j++, i++) {
						if (pattern.charAt(j) == text.charAt(i))
							continue;
						System.out.println("i = " + i + " j = " + j);
						System.out.println("text[i] = " + text.charAt(i) + "pattern[j] = " + pattern.charAt(j) );
						System.out.println("Wrong Algo\n");
						break outer;
					}
					break;
				}
				j = j + 1;
				i = i + 1;
			} else {
				int k = j == 0 ? 1 : j - failureTable[j-1];
				if (k == 0)
					k = 1;
				i = m + k;
				m = i;
				j = 0;
			}
		}
	}	
}