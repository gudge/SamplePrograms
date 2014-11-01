import java.util.Random;

class X {
	private static int getn(Random rand) {
		int i;
		do {
			i = rand.nextInt(100);
		} while (i == 0 || i == 1);
		return i;
	}
	private static void print(int[] arr) {
		System.out.print(arr.length);
		System.out.print(" : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Random rand = new Random();
		int n = getn(rand);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = getn(rand);
		}
//		n = 6;
//		arr = new int[] {13, 17, 5, 4, 6, 2};
		boolean[] leader = new boolean[n];
		leader[n-1] = true;
		for (int i = n - 2, b = arr[n - 1]; i >= 0; i--) {
			if (arr[i] >= b) {
				b = arr[i];
				if (arr[i] > arr[i + 1]) {
					leader[i] = true;
				}
			}
		}
		print(arr);
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (leader[i]) {
				cnt++;
			}
		}
		int[] ans = new int[cnt];
		for (int i = 0, j = 0; i < n && j < cnt; i++) {
			if (leader[i]) {
				ans[j++] = arr[i]; 
			}
		}
		print(ans);
		outer: for (int i = 0; i < n; i++) {
			if (!leader[i])
				continue;
			for (int k = i; k < n; k++) {
				if (arr[i] < arr[k]) {
					System.out.println(i + " -> " + arr[i] + " - " + k + " -> " +  arr[k]);
					System.out.println("Something Wrong");
					break outer;
				}
			}
		}
	}
}