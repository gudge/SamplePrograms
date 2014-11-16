import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


class X {

	private static Random rand = new Random();
	private static int MAX = 100;
	private static int getN() {
		int i ;
		do {
			i = rand.nextInt(MAX);
		} while ( i == 0 || i == 1);
		return i;
	}
	private static void print(ArrayList<Integer> a, int low, int high) {
		for (int i = low/*, len = a.length*/; i < high; i++) {
			if (a.get(i) < 10) {
				System.out.print(' ');
			}
			System.out.print(a.get(i));
			System.out.print(' ');
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int n = getN();
		int k = 5;
		ArrayList<Integer> arr = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arr.add(getN());
		}
		print(arr, 0, arr.size());
		System.out.println(k);
		int cnt = 0, x = arr.get(0), i = 1;
		for (i = 1; i < n && cnt < n - k + 1; i++, cnt++) {
			if (arr.get(i) > x)
				x = arr.get(i);
		}
		System.out.println(i);
		System.out.println(x);
		System.out.println(cnt);
		int cnt2 = 0;
		for (int i1 = 0; i1 < n ; i1 ++) {
			if (arr.get(i1) > x)
				cnt2++;
		}
		System.out.println(arr.indexOf(x));
		System.out.println(cnt2);
//		Collections.sort(arr);
//		System.out.println(arr);
//		System.out.println(arr.get(n - k - 1));
	}
}