import java.util.ArrayList;
import java.util.Random;

// http://www.geeksforgeeks.org/forums/topic/array-asked-in-google/

// Max Subsequence of Length


class X2 {
	private static Random rand = new Random();
	final static int M = 100;
	private static int getn(int N) {
		int i;
		i = rand.nextInt(N);
		if (i == 0)
			i += 5;
		return i;
	}
	
	public static void main(String[] args) {
		final int N = getn(M);
		ArrayList<Integer> arr = getArray(N);
		ArrayList<Integer> arr2 = copyarr(N);
		int last = 0;
		for (int i = 0; i < N; i++) {
			if (arr.get(i) > arr2.get(last)) {
				arr2.set(last++, arr2.get(i));
			}
		}
		print1(arr, N);
	}

	private static ArrayList<Integer> copyarr(int N) {
		ArrayList<Integer> arr = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			arr.add(0);
		}
		return arr;
	}

	private static ArrayList<Integer> getArray(final int N) {
		ArrayList<Integer> arr = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			arr.add(getn(M));
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