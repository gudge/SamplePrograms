import java.util.Random;

class MaxValueContiguousSubsequence {
	
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
			int j;
			j = getN(100);
			if (j < N) {
				if (j % 4 == 0) {
					arr[i] = -arr[i];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	public static void main(String[] args) {
		getarr();
		int max = 0, max2 = 0;
		for (int i = 0; i < N; i++) {
			max2 += arr[i];
			if (max2 < 0)
				max2 = 0;
			else {
				if (max2 > max)
					max = max2;
			}
		}
	}
}

// Making Change:
//