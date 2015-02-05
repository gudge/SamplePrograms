import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class T {
	int i;
	int v;
	
	int compare(T t1) {
		if (this.v == t1.v) return this.i - t1.i;
		return this.v - t1.v;
	}
	void print() {
		System.out.print(this.v);
		System.out.print(' ');
	}
	T(int v, int i) {
		this.v = v;
		this.i = i;
	}
}

public class Hello {
	private static void print(int[] a) {
		for (int i = 0, l = a.length; i < l; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}	
		System.out.println();
	}
	public static void main2(String[] args) {
		Random rand = new Random();
		final int MAX = 10;
		int[] a = new int[MAX];
		for (int i = 0, l = a.length; i < l; i++)
			a[i] = rand.nextInt(MAX);
		print(a);
		ArrayList<T> array = new ArrayList<T>(a.length);
		for (int i = 0, l = a.length; i < l; i++)
			array.add(new T(a[i], i));
		array.sort((T t1, T t2) -> {return t1.compare(t2);});
		array.forEach((T t) -> { t.print();});
	}
	public static void main(String[] args) {
		int [] j = new int[10];
		System.out.println(Integer.MIN_VALUE);
		Arrays.fill(j, 1 << 30);
		for (int i = 0; i < 10; i++) {
			System.out.print(j[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
}