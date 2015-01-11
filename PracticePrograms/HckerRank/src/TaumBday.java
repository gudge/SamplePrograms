import java.util.Random;

// https://www.hackerrank.com/contests/w13/challenges/taum-and-bday

class Y1 {	
	final static Random rand = new Random();
	final int MAX = 1000;
	long X = rand.nextInt(MAX); // Black Cost
	long Y = rand.nextInt(MAX); // White Cost
	long Z = rand.nextInt(MAX); // Conversion Cost
	long B = rand.nextInt(MAX); // Black Gifts
	long W = rand.nextInt(MAX); // White Gifts
	
	void init() {
		X = (long) Math.pow(10, 9);
		Y = X;
		Z = X;
		B = X;
		W = X;
	}
	
	void foo() {
		init();
		long cW = Y * W;
		long cB = X * B;
		long c = cW + cB;
		long cW1 = cW + (Y+Z) * B;
		long cB1 = cB + (X+Z) * W;
		long m = c < cW1 ? c : cW1;
		m = m < cB1 ? m : cB1;
		System.out.println(m);
	}
}

public class TaumBday {
	public static void main(String[] args) {
		Y1 y = new Y1();
		y.foo();
	}
}