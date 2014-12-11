
// http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
// As of now just the length

class LongestCommonSubSequence {
	public static void main(String[] args) {
		String str = "ABCDGH";
		String pat = "AGGTAB";
		int MIN = -1;
		
		int[][] val = new int[str.length()][pat.length()];
		for (int i = 0, len = str.length(); i < len; i++) {
			for (int j = 0, len2 = str.length(); j < len2; j++) {
				if (i == 0 || j == 0)
					val[i][j] = 0;
				val[i][j] = str.charAt(i) == pat.charAt(j) ? val[i - 1][j - 1] : Math.max(val[i][j-1], val[i-1][j]); 
			}
		}
	}
}