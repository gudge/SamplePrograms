import java.util.Scanner;



public class SwapandSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] l2 = in.nextLine().split(" ");
		final int N = Integer.parseInt(l2[0]);
		final int Q = Integer.parseInt(l2[1]);
		l2 = in.nextLine().split(" ");
		final int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(l2[i]);
		}
		l2 = in.nextLine().split(" ");
		int hs = 0, hl = 0;
		for (int i = 0; i < Q; i++) {
			final int TP = Integer.parseInt(l2[0]);
			final int L = Integer.parseInt(l2[1]);
			final int R = Integer.parseInt(l2[2]);
			if (TP == 1) {
				
			} else {
				long sum = 0;
				for (int j = L - 1; j < R; j++)
					sum += a[j];
				System.out.println(sum);
			}
		}
		in.close();
	}
}