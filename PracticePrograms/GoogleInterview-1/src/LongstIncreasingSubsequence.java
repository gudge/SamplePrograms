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

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	public static void main(String[] args) {
		getarr();
	}
}	