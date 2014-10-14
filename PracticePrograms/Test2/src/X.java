import java.util.ArrayList;
import java.util.Collections;


class X {
	
	int convert (int N) {
		
		final int MAX =  100;
		
		int j = 0;
		for (;(int)Math.pow(2, j) < MAX;j++);
		int size = j;
		boolean[] arr = new boolean[size + 1];
		for (j = 0; j <= size; j++) {
			arr[j] = false;
		}
		
		int value;
		for (value = N;value != 0 && value != 1;value = value - (int)Math.pow(2, j - 1)) {
			for (j = 0;(int)Math.pow(2, j) < value;j++);
			arr[j - 1] = true;
		}
		if (value == 1)
			arr[0] = true;
		for (j = 0; j <= size; j++) {
			arr[j] = !arr[j];
		}
		for (j = size, value = 0; j >=0; j--) {
			if (arr[j]) value += (int)Math.pow(2, j);
		}
		return value;
	}
	public static void main(String[] args) {
		X x = new X();
		System.out.println(x.convert(7));
	}
}