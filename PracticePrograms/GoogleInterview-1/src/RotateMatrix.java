import java.util.ArrayList;
import java.util.Random;

class RotateMatrix {
	private static Random rand = new Random();
	final static int S = 5;
	final static int M = 100;
	private static int getn(int N) {
		int i;
		i = rand.nextInt(N);
		if (i == 0)
			i += 5;
		return i;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> m = getMatrix();
		ArrayList<ArrayList<Integer>> rot = getRotatedMatrix();
		copyval(m, rot);
		print(m);
		for (int i = 0, len = m.size(); i < len; i++) {
			ArrayList<Integer> m2 = m.get(i);
			for (int j = 0, len2 = m2.size(); j < len2; j++) {
				ArrayList<Integer> m4 = new ArrayList<Integer>(4);
				m4.add(m2.get(j));
				int r1 = j, c1 = len2 - i - 1;
				m4.add(m.get(r1).get(c1));
				int r2 = c1, c2 = len2 - r1 - 1;
				m4.add(m.get(r2).get(c2));
				int r3 = c2, c3 = len2 - r2 - 1;
				m4.add(m.get(r3).get(c3));
				rot.get(i).set(j, m4.get(3));
				rot.get(r1).set(c1, m4.get(0));
				rot.get(r2).set(c2, m4.get(1));
				rot.get(r3).set(c3, m4.get(2));
			}
		}
		print(rot);
	}
	private static void copyval(ArrayList<ArrayList<Integer>> m, ArrayList<ArrayList<Integer>> rot) {
		for (int i = 0, len = m.size(); i < len; i++) {
			ArrayList<Integer> m2 = m.get(i);
			ArrayList<Integer> m3 = rot.get(i);
			for (int j = 0, len2 = m2.size(); j < len2; j++) {
				int k = m2.get(j);
				m3.set(j, k);
			}
		}
	}
	private static ArrayList<ArrayList<Integer>> getRotatedMatrix() {
		ArrayList<ArrayList<Integer>> m = new ArrayList<ArrayList<Integer>>(S);
		for (int i = 0; i < S; i++) {
			ArrayList<Integer> m2 = new ArrayList<Integer>(S);
			m.add(m2);
			for (int j = 0; j < S; j++) {
				m2.add(0);
			}
		}
		return m;
	}
	private static void print(ArrayList<ArrayList<Integer>> m) {
		System.out.println();
		for (int i = 0, len = m.size(); i < len; i++) {
			ArrayList<Integer> m2 = m.get(i);
			for (int j = 0, len2 = m2.size(); j < len2; j++) {
				int k = m2.get(j);
				if (k < 10)
					System.out.print(' ');
				System.out.print(k);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	private static ArrayList<ArrayList<Integer>> getMatrix() {
		ArrayList<ArrayList<Integer>> m = new ArrayList<ArrayList<Integer>>(S);
		for (int i = 0; i < S; i++) {
			ArrayList<Integer> m2 = new ArrayList<Integer>(S);
			m.add(m2);
			for (int j = 0; j < S; j++) {
				m2.add(getn(M));
			}
		}
		return m;
	}
}