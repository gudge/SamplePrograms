

// http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/

//       1
//    /     \
//   2       3
//  /  \    / \
// 4    5  6   7
//Top view of the above binary tree is
//4 2 1 3 7
//
//        1
//      /   \
//    2       3
//      \   
//        4  
//          \
//            5
//             \
//               6
// 2 1 3 6


class N {
	N l;
	N r;
	int val;
	int h;  // horizontal distance
	int v;  // vertical distance
	N(int val) {
		this.val = val;
		this.l = this.r = null;
		this.h = this.v = 0;
	}
	N(int val, N l, N r) {
		this.val = val;
		this.l = l;
		this.r = r;
		this.h = this.v = 0;
	}
	void print() {
		if (true)
			return;
		//System.out.println("Node : " + this.val + " h dist = " + this.h  + " this dist = " + this.v);
	}
}

public class Solutions {
	public static void main(String[] args) {
		N n4 = new N(4);
		N n5 = new N(5);
		N n6 = new N(6);
		N n7 = new N(7);
		N n2 = new N(2, n4, n5);
		N n3 = new N(3, n6, n7);
		N n1 = new N(1, n2, n3);
		N root = n1;
		topView(root);

//      1
//    /   \
//  2       3
//    \   
//      4  
//        \
//          5
//           \
//             6
		root = n1 = n2 = n3 = n4 = n5 = n6 = n7 = null;
		n6 = new N(6);
		n5 = new N(5, null, n6);
		n4 = new N(4, null, n5);
		n2 = new N(2, null, n4);
		n3 = new N(3, null, null);
		n1 = new N(1, n2, n3);
		root = n1;
		topView(n1);
	}

	private static void topView(N r) {
		r.h = r.v = 0;
		int h = height(r);
		//System.out.println(h);
		int[] min = new int[h];
		int[] max = new int[h];
		for (int i = 0; i < h; i++) {
			min[i] = max[i] = 0;
		}
		inorder(r, 0, 0, min, max);
		for (int i = 0; i < h - 1; i++) {
			if (min[i] < min[i+1]) {
				min[i+1] = min[i];
			}
			if (max[i] > max[i + 1]) {
				max[i+1] = max[i];
			}
		}
		printa(min);
		printa(max);
		topViewHelper(r, min, max);
		System.out.println();
	}

	private static void topViewHelper(final N n, final int[] min, final int[] max) {
		if (n == null)
			return;
		topViewHelper(n.l, min, max);
		if (n.v == 0 || (n.h < min[n.v - 1] || n.h > max[n.v - 1])) {
			System.out.print(n.val);
			if (n.val == 5) {
				System.out.println("Break here\n");
			}
			System.out.print(' ');
		}
		topViewHelper(n.r, min, max);
	}

	private static void printa(int[] a) {
		if (true)
			return;
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i]);
//			System.out.print(' ');
//		}
//		System.out.println();
	}

	private static int height(N n) {
		if (n == null)
			return 0;
		return Math.max(height(n.l), height(n . r)) + 1;
	}

	private static void inorder(N n, int h, int v, int [] min, int [] max) {
		if (n == null)
			return;
		inorder(n.l, h - 1, v + 1, min, max);
		n.h = h;
		n.v = v;
		if (h < min[v]) {
			min[v] = h;
		}
		if (h > max[v]) {
			max[v] = h;
		}
		n.print();
		inorder(n.r, h + 1, v + 1, min, max);
	}
}