import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		String[] l = sc.nextLine().split(" ");
		final int n = Integer.parseInt(l[0]);
		final int m = Integer.parseInt(l[1]);
		final long arr[] = new long[n];
		for (int i = 0; i < m; i++) {
			l = sc.nextLine().split(" ");
			final int b = Integer.parseInt(l[1]) - 1;
			final long k = Long.parseLong(l[2]);
			arr[Integer.parseInt(l[0]) - 1] += k;
			if (b != n - 1)
				arr[b+1] -= k;
		}
		sc.close();
		long value = arr[0], sum = arr[0];
		for (int i = 1; i < n; i++) {
			sum += arr[i];
			if (sum > value)
				value = sum;
		}
		System.out.print(value);
	}
}