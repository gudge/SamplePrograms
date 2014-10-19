import java.util.Random;



class X {
	static private final int getN(Random rand, int n) {
		int i = 0;
		do {
			i = rand.nextInt(n);
		} while (i == 0 || i == 1);
		return i;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		final int max = 10;
		final int n = getN(rand, max);
		int[] arr = new int[n];
		int[] copy = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = getN(rand, max);
			copy[i] = arr[i];
		}
		for (int i = 1; i < n; i++) {
			int j, key;
			for (j = i, key = arr[i]; j > 0 && arr[j-1] > key; j--)
				arr[j] = arr[j-1];
			arr[j] = key;
		}
		int pos = 0;
		
		System.out.println("Done\n");
	}
}