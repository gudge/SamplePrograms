import java.util.ArrayList;

public class ArrayOrder {
	public static void main(String[] args) {
		int[] a1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
		int[] a2 = {2, 1, 8, 3};

		ArrayList<Integer> al1 = new ArrayList<Integer>(a1.length);
		for (int i = 0, l = a1.length; i < l; i++) {
			al1.add(a1[i]);
		}

		al1.sort((Integer i, Integer j) -> { return compare(new int[]{i, j}, a2);});
		print(al1);

	}

	private static int compare(int[] is, int[] a2) {
		int id1 = index(a2, is[0]);
		int id2 = index(a2, is[1]);
		if (id1 != -1 && id2 != -1) return id1 - id2;
		else if (id1 == -1 && id2 == -1) return is[0] - is[1];
		else if (id1 == -1) return 1;
		else return -1;
	}

	private static void print(ArrayList<Integer> al1) {
		for (int i = 0, l = al1.size(); i < l; i++) {
			System.out.print(al1.get(i));
			System.out.print(' ');
		}
		System.out.println();
	}

	private static int index(int[] a, int k) {
		for (int i = 0, l = a.length; i < l; i++) {
			if (k == a[i])
				return i;
		}
		return -1;
	}
}