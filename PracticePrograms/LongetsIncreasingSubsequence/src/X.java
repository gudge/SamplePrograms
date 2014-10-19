import java.util.Random;

class X {
	
	private static int getN(Random rand, int n) {
		int i;
		do {
			i = rand.nextInt(n);
		} while (i == 0 || i == 1);
		return i;
	}
	private static void fillarr(int[] arr, int n, int MAX, Random rand) {
		for (int i = 0; i < n; i++) {
			arr[i] = getN(rand, MAX);
		}
	}
	private static void printarr(int[] a, int n) {
		System.out.print(n);
		System.out.print(" : ");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	static class cell {
		int value;
		int parent;
	};
	private static void longestIncreasingSequence(int[] arr, int n) {
		//li = max(lj) + 1
		// A two dimensional array will be needed.
		int[] dp = new int[n];
		int[] p  = new int[n];
		int maxlength = -1, bestEnd = -1;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			p[i]  = -1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					p[i] = j;
				}
			}
			if (dp[i] > maxlength) {
				maxlength = dp[i];
				bestEnd = i;
			}
		}
		int[] seq = new int[maxlength];
		for (int i = bestEnd, j = maxlength - 1; i >= 0 && i != -1 && j >= 0;i = p[i]) {
			seq[j--] = arr[i];
		}
		printarr(seq, maxlength);
	}
	public static void main(String[] args) {
		Random rand = new Random();
		final int MAX = 100;
		int n = getN(rand, MAX);
		int arr[] = new int[n];
		fillarr(arr, n, MAX, rand);
		printarr(arr, n);
		longestIncreasingSequence(arr, n);
	}
}