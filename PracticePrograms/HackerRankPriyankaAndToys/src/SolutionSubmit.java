import java.util.*;
public class SolutionSubmit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.nextLine();
		int N = Integer.parseInt(l);
		if (N == 0) {
			System.out.println(0);
			sc.close();
			return;
		}
		if (N == 1) {
			System.out.println(1);
			sc.close();
			return;
		}
		l = sc.nextLine();
		String [] l2 = l.split(" ");
		ArrayList<Integer> arr = new ArrayList<Integer>(N);
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(l2[i]));
		}
		sc.close(); l2 = null;l = null;
		Collections.sort(arr);
		for (int i = 0; i < N - 1; i ++) {
			arr.set(i, arr.get(i+1) - arr.get(i));
		}
		arr.remove(N-1);
		int cnt = 1;
		for (int i = 0, d = 0, W = 4, len = arr.size(); i < len; i++) {
			int k = arr.get(i);
			if (k == 0) {
				continue;
			}
			if (k + d <= W) {
				d += k;
			} else {
				d = 0;
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}