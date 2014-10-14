//import java.util.ArrayList;
//import java.util.Collections;
//
//
//
//class Y {
//	static int isSumPossible(int[] a, int N) {
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		for (int i = 0; i < a.length; i++) {
//			arr.add(a[i]);
//		}
//		Collections.sort(arr);
//		for (int i = 0; i < a.length; i++) {
//			a[i] = arr.get(i);
//		}
//		int pos = 0;
//		int m = N / 2;
//		for (int i = 0; i < a.length; i++) {
//			if (m - a[i] < 0) {
//				break;
//			} else {
//				pos = i;
//			}
//		}
//		if (pos == a.length)
//			return -1;
//		int pos1 = -1, pos2 = -1;
//		for (int i = pos - 1, j = pos + 1; i >= 0 && j < a.length;) {
//			int sum = a[i] + a[j];
//			if (sum == N) {
//				pos1 = i;
//				pos2 = j;
//				break;
//			} else if (sum < N) {
//				j++;		
//			} else {
//				i--;
//			}
//		}
//		if (pos == -1 || pos2 == -1)
//			return -1;
//
//		return 0;
//	  }
//	public static void main(String[] args) {
//		int j = isSumPossible(new int[] {18, 11, 21, 28, 31, 38, 40, 55, 60, 62}, 66);
//		System.out.println(j);
//	}
//}