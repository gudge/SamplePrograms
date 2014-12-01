import java.util.ArrayList;
import java.util.Random;

public class SortNegativePositive {
	static Random rand = new Random();
	static final int M = 30;
	private static int getN(final int N) {
		int i;
		i = rand.nextInt(N);
		if (i == 0)
			i += 5;
		return i;
	}
	
	public static void main(String[] args) {
		final int N = getN(M);
		ArrayList<Integer> arr = getArray(N);
		print1(arr, N);
		int low = 0;
		int high = N - 1;
		while (low < high) {
			int i, j;
			for (i = low; i < high; i++) {
				if (arr.get(i) > 0)
					break;
			}
			for (j = high; j > low; j--) {
				if (arr.get(j) < 0)
					break;
			}
			if (i < j) {
				int k = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, k);
				i++;
				j--;
			}
			low = i;
			high  = j;
		}
		print1(arr, N);
	}
	private static ArrayList<Integer> getArray(final int N) {
		ArrayList<Integer> arr = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			arr.add(getN(100));
		}
		for (int i = 0; i < N; i++) {
			if ((i %3) == 0)
				arr.set(i, -arr.get(i));
		}
		return arr;
	}
	private static void print1(ArrayList<Integer> arr, final int N) {
		System.out.print(N);
		System.out.print(" : ");
		for (int i = 0; i < N; i++) {
			System.out.print(arr.get(i));
			System.out.print(" ");
		}
		System.out.println();	
	}
}