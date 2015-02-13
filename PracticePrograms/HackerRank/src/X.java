import java.util.HashMap;

public class X {

	static boolean isPrime(int n) {
		if (n <= 3 || n >= 1)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}
	static int getMinSplit(int width, int height, int nTiles) {
		//System.out.println(width + " " + height + " " + nTiles);

		Long w2 = (long) width;
		Long h2 = (long) height;
		if (w2 * h2 < nTiles)
			return -1;
		if (w2 * h2 == nTiles)
			return 0;

		if (nTiles == 1) {
			if (width == 1 || height == 1)
				return 1;
			return 2;
		}

		if (width == 1) {
			if (height >= nTiles)
				return 1;
			else
				return -1;
		}
		if (height == 1) {
			if (width >= nTiles)
				return 1;
			else
				return -1;
		}

		boolean isPrime = isPrime(nTiles);
		if (isPrime && (width >= nTiles || height >= nTiles))
			return 2;

		if (nTiles % h2 == 0) {
			long x = nTiles / h2;
			if (x <= w2)
				return 1;
		}
		if (nTiles % w2 == 0) {
			long x = nTiles / w2;
			if (x <= h2)
				return 1;
		}

		Long m = (long) Math.sqrt(nTiles);
		if (m % nTiles != 0)
			m += 1;
		for (Long i = (long) 2; i <= m; i++) {
			if (nTiles % i != 0)
				continue;
			Long j = nTiles / i;
			Long m2 = h2 < w2 ? h2 : w2;
			Long m4 = h2 > w2 ? h2 : w2;
			Long m3 = i < j ? i : j;
			Long m5 = i > j ? i : j;
			if (m2 >= m3 && m4 >= m5) {
				int cnt = 0;
				if (m2 != m3) cnt++;
				if (m4 != m5) cnt++;
				return cnt;
			}
		}
		return -1;
	}


	static int getDNAAlignment(String dna1, String dna2) {

		final int[][] m = new int[][] {
		//       A   C   G   T   -
		/*A*/	{5, -1, -2, -1, -3},
		/*C*/	{-1, 5, -3, -2, -4},
				{-2, -3, 5, -2, -2},
				{-1, -2, -2, 5, -1},
				{-3, -4, -2, -1, 0}
		};
		final int M = m.length;
		final HashMap<Character, Integer> m2 = new HashMap<Character, Integer>(5);
		m2.put('A', 0);
		m2.put('C', 1);
		m2.put('G', 2);
		m2.put('T', 3);
		m2.put('-', 4);

		int l1 = dna1.length();
		int l2 = dna2.length();
		int[] T = new int[l1+l2];
		init2(T);
		
		// The values in the array are such that
		// match is always favored.
		int i = 0, j = 0;
		while (true) {
			
			if (i == )
		}
		
		return cost;
	}

	private static void init2(int[] T) {
		final int SENITEL = -1;
		for (int i = 0, l = T.length; i < l; i++)
			T[i] = SENITEL;
	}
	public static void main(String[] args) {
		//System.out.println(getMinSplit(5, 4, 12)); // 1
		//System.out.println(getMinSplit(12, 10, 120)); // 0
		//System.out.println(getMinSplit(2, 2, 1)); // 2
		//System.out.println(getMinSplit(17, 19, 111)); // -1
		//System.out.println(getMinSplit(226800000, 10000000, 938071715)); // 2


		System.out.println(getDNAAlignment("AGTGATG", "GTTAG")); // 14
		System.out.println(getDNAAlignment("AGCTATT", "AGCTTTAAA")); // 21
	}
}