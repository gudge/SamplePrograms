import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


// http://www.geeksforgeeks.org/forums/topic/google-interview-4/
// Design an algorithm that, given a list of n elements in an array, finds all the elements that appear more than n/3 times in the list.

class X {
	private static Random rand = new Random();
	private static int getN(final int N) {
		int i;
		i = rand.nextInt(N);
		if (i == 0)
			i += 5;
		return i;
	}
	private static void print(ArrayList<Integer> arr) {
		System.out.print(arr.size());
		System.out.print(" : ");
		for (int i = 0, len = arr.size(); i < len; i++) {
//			if (arr.get(i) < 10)
//				System.out.print(" ");
			System.out.print(arr.get(i));
			System.out.print(" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		final int N = getN(100);
		ArrayList<Integer> arr = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			arr.add(getN(N/2));
		}
		try {
			setElement(arr, N);
		} catch (IndexOutOfBoundsException e) {
			print(arr);
			System.out.println(N);
			return;
		}
		//int cnt = N/3;
		final int M = 2;
		int [] testcnt = new int[M];
		int [] testarr = new int[M];
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			int j = arr.get(i);
			int cnt3 = incntarr(j , testarr);
			if (cnt3 == -1) {
				cnt2 = emptypos(testcnt);
				if (cnt2 != -1) {
					addElement(testcnt, testarr, cnt2, 1, j);
				} else {
					for (int k = 0 ; k < M; k++) {
						testcnt[k]--;
					}
					cnt2 = emptypos(testcnt);
					if (cnt2  != -1)
						addElement(testcnt, testarr, cnt2, 1, j);
				}
			} else {
				addElement(testcnt, testarr, cnt3, testcnt[cnt3] + 1, j);
			}
		}
		print(arr);
		for (int i = 0; i < M; i++) {
			System.out.print(testcnt[i]);
			System.out.print(' ');
			System.out.print(testarr[i]);
			System.out.print("  ");
		}
		System.out.println();
	}
	private static int emptypos(int[] testcnt) {
		for (int i = 0, len = testcnt.length; i < len; i++) {
			if (testcnt[i] == 0)
				return i;
		}
		return -1;
	}
	private static void addElement(int[] t1, int[] t2, int i, int v1, int v2) {
		t1[i] = v1;
		t2[i] = v2;
	}
	private static int incntarr(int j, int[] testarr) {
		for (int k = 0, len = testarr.length; k < len; k++)
			if (j == testarr[k])
				return k;
		return -1;
	}
	private static void setElement(final ArrayList<Integer> arr, final int N) {
		int j = arr.get(getN(N/3));
		for (int k = getN(N/3), i = k; i < N/3 + k; i++) {
			arr.set(i, j);
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (arr.get(i) == j)
				cnt++;
		}
		System.out.println(j + " : " + N + " : " + cnt);
	}
}