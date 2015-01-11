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
				for (int k = 0; k < M; k++)
					a[j][k] = Integer.parseInt(l2[k]);
			}
			res[i] = foo(N, M, a);
		}
		in.close();
		for (int i = 0; i < T; i++)
			System.out.println(res[i]);
	}
	
	void init_t(boolean[]  t) {
		
	}
	
	private static int foo(final int N, final int M, final int[][] a) {
		if (N == 0 || M == 0)
			return 0;
		int min = a[N-1][0];
		for (int i = 0; i < M; i++) {
			if (min > a[N-1][i])
				min = a[N-1][i];
		}
		int bullets = min;
		int added_bullets = 0;
		for (int i = N-2; i >= 0; i--) {
			boolean[] t = new boolean[M];
			int b = i + N;
			boolean everyone_smaller = true;
			for (int j = 0; j < M; j++) {
				if (a[b][j] >= bullets) {
					t[j] = true;
					if (everyone_smaller)
						everyone_smaller = false;
				}
			}
			int p = i;
			int pos = -1;
			if (!everyone_smaller) {
				for (int j = 0; j < M; j++) {
					if (!t[j])
						continue;
					min = a[p][j];
					pos = j;
					break;
				}
				for (int j = pos + 1; j < M; j++) {
					if (!t[j])
						continue;
					if (a[p][j] < min) {
						min = a[p][j];
						pos = j;
					}
				}
				bullets = min;
			} else {
				min = a[p][0];
				for (int j = 1; j < M; j++) {
					if (a[p][j] < min) {
						min = a[p][j];
						pos = j;
					}
				}
				if (min > bullets) {
					added_bullets += min - bullets;  
				}	
			}
		}
		return bullets + added_bullets;
	}
}