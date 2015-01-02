
class Y {
	void foo() {
		int[] arr = new int[] {1, 1, 0, 0, 0, 1, 0, 1};
		print(arr);
		int l = 0;
		int h = arr.length - 1;
		while (l < h) {
			if (arr[l] == 0 && arr[h] == 1) {
				break;
			}
			if (arr[l] == 1) l++;
			if (arr[h] == 0) h--;
		}
		if (l < h) {
			int swap = arr[l];
			arr[l] = arr[h];
			arr[h] = swap;
		}
		print(arr);
	}

	private void print(int[] arr) {
		for (int i = 0, len = arr.length; i < len; i++)
			System.out.print(arr[i]);
		System.out.println();
	}
	
	void foo2() {
		int n = 58;
		String bi = Integer.toBinaryString(n);
		int[] arr = new int[bi.length()];
		for (int i = 0, len = bi.length(); i < len; i++) {
			arr[i] = bi.charAt(i) == '1' ? 1 : 0;
		}
		print(arr);
	}
}

class X {
	public static void main(String[] args) {
		Y y = new Y();
		y.foo();
		y.foo2();
	}
}