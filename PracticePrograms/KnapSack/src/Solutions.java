import java.util.Random;



class Solutions {
	
	static Random rand = new Random();
	final static int MAX = 100;
	private static int getN(final int n) {
		int i;
		do {
			i = rand.nextInt(n);
		} while (i == 0 || i == 1);
		return i;
	}
	static void print(int[] a) {
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 10)
				System.out.print(' ');
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = getN(MAX);
		int[] w = new int[n];
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = getN(MAX);
			v[i] = getN(MAX);
		}
		int W = getN(MAX);
		print(v);
		print(w);
		int[][] k = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int w2 = 0; w2 < W; w2++) {
				if (i == 0 || w2 == 0) {
					k[i][w2] = 0;
					continue;
				}
				k[i][w2] = Math.max(k[i][w2 - w[i]] + v[i], k[i-1][w2]);
			}
		}
	}
}