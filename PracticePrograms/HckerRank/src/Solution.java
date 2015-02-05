import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String l = in.nextLine();
		final int T = Integer.parseInt(l);
		int[] res = new int[T];
		for (int i = 0; i < T; i++) {
			l = in.nextLine();
			String[] l2 = l.split(" ");
			final int N = Integer.parseInt(l2[0]);
			final int M = Integer.parseInt(l2[1]);
			final int[][] a = new int[(2 * N)][];
			for (int j = 0; j < 2 * N; j++)
				a[j] = new int[M];
			for (int j = 0; j < 2 * N; j++) {
				l = in.nextLine();
				l2 = l.split(" ");
				for (int k = 0; k < M; k++) {
					a[j][k] = Integer.parseInt(l2[k]);
				}	
			}
			res[i] = foo3(N, M, a);
		}
		in.close();
		for (int i = 0; i < T; i++)
			if (res[i] != -1) {
				System.out.println(res[i]);
			}
	}

	private static int foo2(final int N, final int M, int[][] a) {
		if (N == 0 || M == 0)
			return 0;
		int[][] DP = new int[2][M];
		for (int i = 0; i < 2; i++) {
			DP[i] = new int[M];
		}

		for (int i = 0; i < M; i++) {
			DP[0][i] = a[0][i];
		}

		for (int i = 1; i < N; i++) {
			int b = i + N;
			for (int j = 0; j < M; j++) {
				int[] t = new int[M];
				for (int k = 0; k < M; k++)
					t[k] = DP[0][k];
				for (int k = 0; k < M; k++) {
					if (a[i][j] <= a[b-1][k])
						continue;
					t[k] += a[i][j] - a[b-1][k];
				}
				int min = t[0];
				for (int k = 1; k < M; k++) {
					if (min <= t[k])
						continue;
					min = t[k];
				}
				DP[1][j] = min;
			}
			DP[0] = DP[1];
			DP[1] = new int[M];
		}
		int min = DP[0][0];
		for (int i = 1; i < M; i++) {
			if (min <= DP[0][i])
				continue;
			min = DP[0][i];
		}	
		return min;
	}
	
	
	
	private static int foo3(final int N, final int M, int[][] a) {
		if (N == 0 || M == 0)
			return 0;
		// Maximum value of Bullets and Enemy kill
		final int MAX2 = 1001;
		int min = -1;	
		int[] DP = new int[MAX2];
		Arrays.fill(DP,  Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			int b = a[N][i];
			if (DP[b] > a[0][i])
				DP[b] = a[0][i];
		}
		for (int i = 1;  i < N; i++) {
			int[] b1 = a[i+N];
			int[] p = a[i];
			int[] DP2 = new int[MAX2];
			for (int j = 0; j < M; j++) {
				int p1 = p[j];
				for (int k = 0; k <= p1; k++) {
					
				}
				
			}
			DP = DP2;
		}
		min = DP[0];
		for (int i = 0; i < M; i++) {
			if (min > DP[i])
				min = DP[i];
		}
		return min;
	}
}