import java.util.Random;



// http://people.cs.clemson.edu/~bcdean/dp_practice/

// 
//   if (a[1] > a[0]) dp[0] = 1 
//   

class LongestIncreasingSubsequence {

	private static Random rand = new Random();
	private static int MAX = 100;
	private static int[] arr;
	private static int N;

	private static int getN(int N) {
		int i;
		i = rand.nextInt(MAX);
		if (i == 0) {
			i += 5;
		}
		return i;
	}
	static private void getarr() {
		N = getN(100);
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = getN(100);
		}

		// 54 50 25 97 11 71 27 97 32
		arr = null;
		arr = new int[] {54, 50, 25, 97, 11, 71, 27, 97, 32};
		N = arr.length;

		printarr(arr);

	}
	private static void printarr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();

	}
	public static void main(String[] args) {
		getarr();
		int[] dp = new int[arr.length];
		int [] p = new int[arr.length - 1];
		for (int i = 0, len1 = dp.length; i < len1; i++) {
			dp[i] = 1;
		}
		for (int i = 1, len1 = arr.length; i < len1; i++) {
			find_pos(i, dp, p);
		}
		printarr(dp);
		int max = dp[0], pos2 = 0;
		for (int i = 1, len = dp.length; i < len; i++) {
			if (max < dp[i]) {
				max = dp[i];
				pos2 = i;
			}
		}
		
	}
	private static void find_pos(int pos, int[] dp, int[] p) 
	{
		int max = 0, pos2 = -1;
		for (int i = 0; i < pos; i++) {
			if (arr[pos] > arr[i] && max < dp[i]) {
				max = dp[i];
				pos2 = i;
			}
		}
		if (pos2 != -1) {
			dp[pos] = max + 1;
			p[pos-1] = pos2;
		} else {
			p[pos-1] = -1;
		}
	}
}