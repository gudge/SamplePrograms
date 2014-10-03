import java.util.ArrayList;
import java.util.Random;



public class X {
	
	// vertices
	int v;
	// directed
	ArrayList<ArrayList<Integer>> adj;
	final static int nos = 10;
	final static Random rand = new Random();
	final static int RED = 0;
	final static int BLUE = 1;
	final static int NO_COLOR = 2;
	private int getN(int seed) {
		int i = rand.nextInt(seed);
		if (i == 0 || i == 1)
			i = seed;
		return i;
	}
	X() {
		v = getN(nos);
		adj = new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(i, new ArrayList<Integer>(v));
		}
		for (int i = 0, j = 0, s, e; i < getN(v - 1) && i < v * (v - 1) /2 && j < nos;j++) {
			s = getN(v - 1);
			e = getN(v - 1);
			if (s != e) {
				if (!adj.get(s).contains(e) && !adj.get(e).contains(s)) {
					if (adj.get(s).size() <= 2) {
						if (s < e)
							adj.get(s).add(e);
						else
							adj.get(e).add(s);
					}	
					i++;
				}
			}
		}
		printGraph();
	}
	void printGraph() {
		System.out.println("Vertices: " + v);
		for (int i = 0; i < v; i++) {
			if (adj.get(i).size() == 0)
				continue;
			System.out.print("Vertex: ");
			System.out.print(i);
			System.out.print(' ');
			for (int j = 0; j < adj.get(i).size(); j++) {
				int d = adj.get(i).get(j);
				System.out.print(" (");
				System.out.print(i);
				System.out.print(",");
				System.out.print(d);
				System.out.print(") ");
			}
			System.out.println();
		}
	}
	int complement(int c) {
		if (c == RED) return BLUE;
		if (c == BLUE) return RED;
		return NO_COLOR;
	}
	void chromaticNo() {
		int [] colorVertex = new int[v];
		colorVertex[0] = RED;
		for (int i = 0; i < v; i++) {
			if (adj.get(i).size() == 0)
				continue;
			ArrayList<Integer> x2 = adj.get(i);
			for (int j = 0; j < 2; i++) {
				colorVertex[x2.get(j)] = complement(colorVertex[i]);
			}
				
		}
	}
	public static void main(String[] args) {
		X x = new X();
	}
}