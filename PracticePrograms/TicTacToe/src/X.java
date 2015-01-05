import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;


class Y{

	interface I1 {
		boolean f(boolean[] v);
	}

	interface I2 {
		int f(boolean[] v);
	}

	void game() {
		final int EMPTY = 0;
		final int CROSS = 1;
		final int CIRCLE = 2;
		final int NOSQ = 9;
		int[] board = new int[NOSQ];
		for (int i = 0; i < NOSQ; i++) {
			board[i] = EMPTY;
		}
		final int[] moves = {0, 1, 4, 2, 8, 6};
		for (int i = 0, len = moves.length; i < len; i++) {
			int sq = moves[i];
			if (board[sq] != 0)
				continue;
			board[sq] = i %2 == 0 ? CROSS : CIRCLE;
			boolean win = false;
			// Horizontal Checks
			for (int j = 0; j < 3; j++) {
				int sq2 = sq / 3 + (sq + j) %3;
				if (board[sq2] != board[sq])
					break;
				if (j == 2)
					win = true;

			}
			if (win) {
				System.out.println("Win1");
				return;
			}
			// Vertical Checks
			for (int j = 0; j < 3; j++) {
				int sq2 = (sq + 3 * j) % 9;
				if (board[sq2] != board[sq])
					break;
				if (j == 2)
					win = true;
			}
			if (win) {
				System.out.println("Win2");
				return;
			}
			// 0, 4, 8
			// 2, 4, 6
			for (int j = 4; j <= 8; j += 4) {
				if (board[j] != board[0]) {
					break;
				}
				if (j == 8)
					win = true;
			}
			for (int j = 4; j <= 6; j += 2) {
				if (board[j] != board[2]) {
					break;
				}
				if (j == 6)
					win = true;
			}
			if (win) {
				System.out.println("Win3");
				return;
			}
		}
	}

	void histogram() {
		//		int[] h = new int[] {6, 2, 5, 4, 5, 1, 6};
		//int[] h = new int[] {7, 2, 1, 4, 5, 1, 3, 3};
		int[] h = new int[] {1000, 1000, 1000, 1000};
		int l = h[0];
		int b = h[0];
		for (int i = 1, len = h.length; i < len; i++) {
			if (l > h[i])
				l = h[i];
			if (b < h[i])
				b = h[i];
		}
		int a = l * h.length;
		for (int i = l + 1; i <= b; i++) {
			int j;
			for (j = 0; j < h.length; j++) {
				if (h[j] > i)
					break;
			}
			if (j == h.length)
				continue;
			int a2 = i;
			int a3 = a2;
			for (int k = j + 1;k < h.length; k++) {
				if (h[k] >= i) {
					a3 += i;
				} else {
					if (a3 > a2)
						a2 = a3;
					a3 = 0;
				}
			}
			if (a2 > a)
				a = a2;
		}
		System.out.println(a);
	}

	void stringMatch() {
		//String t = "abacaabacc";
		//String p = "abacab";

		//String t = "ABC ABCDAB ABCDABCDABDE";
		//String p = "ABCDABD";

		String t = "AABAACAADAABAAABAA";
		String p = "AABA";

		int [] table  = new int[p.length()];
		//table[0] = -1;
		for (int i = 1, len = table.length; i < len; i++)
			table[i] = 0;
		for (int i = 2, len = p.length(); i < len; i++) {
			table[i] = p.charAt(i-1) == p.charAt(table[i-1]) ? table[i-1] + 1 : 0;
		}
		for (int i = 0, len = p.length(); i < len; i++) {
			System.out.print(table[i]);
			System.out.print(' ');
		}
		System.out.println();
		for (int i = 0, j = 0, len = t.length(), len2 = p.length(); len2 - j <= len -i && j < len2;) {
			if (t.charAt(i) == p.charAt(j)) {
				System.out.println(" i = " + i + " " + t.charAt(i) + " " + j + " " + p.charAt(j));
				if (j == len2 - 1) {
					System.out.println("Found\n");
				}
				j = j == len2 - 1 ? 0 : j + 1;
				i++;
			} else {
				System.out.println("Skip:  i = " + i + " " + t.charAt(i) + " " + j + " " + p.charAt(j));
				int v = table[j];
				i = j == 0 ? 1 : i + v;	
				j = table[j];
			}
		}
	}



	void pondsandrivers() {
		// dfs
		//		int[][] m = {{1, 1, 0, 0, 0},
		//					{0, 1, 0, 0, 1},
		//					{1, 0, 0, 1, 1},
		//					{0, 0, 0, 0, 0},
		//					{1, 0, 1, 0, 1}};

		int[][] m = new int[13][13];
		for (int i = 0, len = m.length; i < len; i++) {
			for (int j = 0, len2 = m.length; j < len2; j++) {
				m[i][j] = 0;
			}
		}
		m[0][6] = 1;
		m[0][1] = 1;
		m[0][2] = 1;
		m[3][5] = 1;
		m[4][6] = 1;
		m[3][4] = 1;
		m[4][5] = 1;
		m[7][8] = 1;
		m[9][10] = 1;
		m[9][11] = 1;
		m[9][12] = 1;
		m[11][12] = 1;
		for (int i = 0, len = m.length; i < len; i++) {
			for (int j = 0, len2 = m.length; j < len2; j++) {
				if (m[i][j]  != 0 && i < j) {
					m[j][i] = 1;
				}
				if (i == j)
					m[i][j] = 1;
			}
		}

		// One has to represent this as a graph.
		// A group of 1's form a Island.
		// a group of 0's from Water.
		final int L = m.length;
		// visited
		boolean[] v = new boolean[L];
		for (int i = 0 ; i < L; i++)
			v[i] = false;
		// connected component
		int[] cc = new int[L];

		I1 allvisited = (v1) -> {
			for (int i = 0; i < L; i++)
				if (!v1[i])
					return false;
			return true;
		};

		I2 nonvisted = (v1) -> {
			for (int i = 0; i < L; i++) {
				if (!v[i])
					return i;
			}
			return -1;
		};

		int c = 0;
		while(!allvisited.f(v)) {
			int v1 = nonvisted.f(v);
			dfs(v, cc, c, v1, m, L);
			c++;
		}
		//		for (int i  = 0; i < L; i++) {
		//			System.out.print(cc[i]);
		//			System.out.print(' ');
		//	System.out.println();
		//		}
		System.out.println(c);
	}

	private void dfs(boolean[] v, int[] cc, int c, int v1, int[][] m, int L) {
		if (v[v1])
			return;
		v[v1] = true;
		cc[v1] = c;
		for (int i = 0; i < L; i++) {
			if (v[i] || m[v1][i] == 0 || i == v1)
				continue;
			dfs(v, cc, c, i, m, L);	
		}
		//System.out.println(c);
	}

	public void kmostimportantstrings() {

		// maintain a heap
		// maintain a trie
		String str =
				"Welcome to the world of Geeks" + 
						" This portal has been created to provide well written well thought and well explained" + 
						" solutions for selected questions If you like Geeks for Geeks and would like to contribute" + 
						" here is your chance You can write article and mail your article to contribute at" + 
						" geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help" + 
						" thousands of other Geeks";

		class T {
			boolean isend = true;
			boolean isdollar = false;
			final int M = 26;
			T[] child = new T[M];
			int count = 1;
			int heapIndex = -1;
			T(int count) {
				this();
				this.count = count;
			}
			T() {
				for (int i = 0; i < M; i++) {
					this.child[i] = null;
				}
			}

			int getindex(String key, int pos) {
				Character c = key.charAt(pos);
				c = Character.toLowerCase(c);
				return (char)c - 'a';
			}
			void insert(String key) {
				if (key.length() == 0)
					return;
				T t = this;
				for (int i = 0, len = key.length(); i < len; i++) {
					int j = getindex(key, i);
					if (t.child[j] == null) {
						t.child[j] = new T();
						t.isend = false;
					}	
					t = t.child[j];
				}
				t.isdollar = true;
			}
			T search(String key) {
				if (key.length() == 0)
					return null;
				T t = this;
				for (int i = 0, len = key.length(); i < len; i++) {
					int j = getindex(key, i);
					if (t.child[j] == null)
						return null;
					else {
						t = t.child[j];
					}
				}
				if (t != null && (t.isend || t.isdollar))
					return t;
				return null;
			}
			void searchinsert(String key) {
				if (key.length() == 0)
					return;
				T t = search(key);
				if (t == null)
					insert(key);
				else
					t.count += 1;
			}
			void found(String key) {
				T t = this.search(key);
				String f = t == null ? "Not found" : "found";
				int count = t == null ? 0 : t.count;
				System.out.println(key + " -> " + f + " " + count);
			}
		}
		// min heap
		class H {
			T[] h;
			H(int l) {
				this.h = new T[l];
				for (int i = 0; i < l; i++)
					this.h[i] = null;
			}
			int currCapacity() {
				// points to null of current capacity
				int i;
				int l = this.h.length;
				for (i = 0; i < l && this.h[i] != null; i++);
				return i;
			}
			void insert(T t) {
				// If It is already present
				if (t.heapIndex != -1) {
					t.count += 1;
					return;
				}	
				T min = this.h[0];
				int i = currCapacity();
				if (i <= this.h.length - 1)	{this.h[i] = t; t.heapIndex = i;}
				else if (min.count < t.count) {this.h[0] = t; t.heapIndex = 0;}
				buildHeap();
			}
			void buildHeap() {
				int i;
				final int n = currCapacity();
				for (i = (n-1)/2; i >= 0; i++) {
					minheap(i);
				}
				for (i = 0; i < n; i++) {
					this.h[i].heapIndex = i;
				}
			}
			void minheap(int idx) {
				final int N = this.h.length >= currCapacity() ?  this.h.length : currCapacity();  
				if (idx >= N)
					return;
				int s = idx;
				int l = 2 * idx + 1;
				int r = 2 * idx + 2;
				int c_s = this.h[s].count;
				int c_l = l <= N ? this.h[l].count : -1;
				int c_r = l <= N ? this.h[r].count : -1;
				if (c_l != -1 && c_s > c_l) {s = l; c_s = c_l;}
				if (c_r != -1 && c_s > c_r) {s = r;}
				if (s != idx) {
					T t1 = this.h[s];
					this.h[s] = this.h[idx];
					this.h[idx] = t1;
					this.h[s].heapIndex = s;
					this.h[idx].heapIndex = idx;
				}
			}
		}
		T t = new T(0); // root node
		StringTokenizer str2 = new StringTokenizer(str, " ");
		H h = new H(5); /// I want only 5 most frequently used words.
		while(str2.hasMoreTokens()) {
			//t.searchinsert(str2.nextToken(), h);
		}
		t.found("the");






		//		public void heapsort() {
		//		final Random rand = new Random();
		//		final int M = 100;
		//		int N = rand.nextInt(M);
		//		//N = 10;
		//		int[] a = new int[N];
		//		for (int i = 0; i < N; i++) {
		//			a[i] = rand.nextInt(M);
		//		}
		////		a = new int[] {65, 56, 16, 13, 30, 31, 99, 81, 71, 0 };
		//		print(a);
		//		for (int i = (N - 1)/2; i >= 0; i-- ) {
		//			buildheap(a, i);
		//		}
		//		print(a);
		//		
		//		for (int i = 1; i < N; i++) {
		//			if (a[0] > a[i]) {
		//				System.out.println("Wrong");
		//				break;
		//			}
		//		}
	}

	private void print(int[] a) {

		for(int i = 0, len = a.length; i < len; i++) {
			System.out.print(a[i]);
			System.out.print(' ');
		}
		System.out.println();
	}

	private void buildheap(int[] a, int idx) {
		final int N = a.length;
		if (idx >= N)
			return;
		int l = 2 * idx + 1;
		int r = 2 * idx + 2;
		int s = idx;
		if (r < N && a[s] > a[r])
			s = r;
		if (l < N  && a[s] > a[l])
			s = l;
		if (s != idx) {
			int t = a[idx];
			a[idx] = a[s];
			a[s] = t;
			buildheap(a, s);
		}
	}

	void trie() {
		String str = "Welcome to the world of Geeks" + 
				" This portal has been created to provide well written well thought and well explained" + 
				" solutions for selected questions If you like Geeks for Geeks and would like to contribute" + 
				" here is your chance You can write article and mail your article to contribute at" + 
				" geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help" + 
				"thousands of other Geeks";

		class Y2 {

			final static int MAXTRIENODES = 26;
			class Trie {
				boolean isEnd = false;
				int freqency = 0;
				int indexheap = 1;
				Trie[] child = null;
			}

			class Heap {
				int capacity;
				Trie trie;

			}
		}


	}

	public void evennos() {
		Random rand = new Random();
		final int M = 20;
		final int N = rand.nextInt(M);
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = rand.nextInt(M);
		}
		int res = 0;
		for (int i  = 0; i < a.length; i++)
			res = res ^ a[i];
	}

	void simpletrie() {
		final int M = 26;
		class T {
			boolean isend = true;
			boolean isdollar = false; // denoting intermediate end
			T[] child = new T[M];

			T() {
				for (int i = 0; i < M; i++)
					this.child[i] = null;
			}

			int findIndex(String str, int pos) {
				Character c = str.charAt(pos);
				c = Character.toLowerCase(c);
				int val =  (char)c - 'a';
				if (val < 0 || val >= M) {
					System.out.println("Wrong value in index");
				}
				return val;
			}

			void insert(String str) {
				// The key is to make a differentiation between
				// prefix and end element.

				// e.g "the" "there" -> one should detect "the" but not
				// th
				T t = this;
				for (int i = 0, l = str.length(); i < l; i++) {
					int j = findIndex(str, i);
					if (t.child[j] == null) {
						t.isend = false;	
						t.child[j] = new T();
					}
					t = t.child[j];
				}
				t.isdollar = true;
			}
			int search(String key) {
				T t = this;
				for (int i = 0, l = key.length(); i < l; i++) {
					int j = findIndex(key, i);
					if (t.child[j] == null)
						return -1;
					t = t.child[j];
				}
				if (t != null && (t.isend || t.isdollar))
					return 0;
				else
					return -1;
			}
			void found(String key) {
				String f = this.search(key) == 0 ? "found" : "not found";
				System.out.println(key + " -> " + f); 
			}
		}
		T t = new T();
		String[] keys = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		for (int i = 0, len = keys.length; i < len; i++) {
			t.insert(keys[i]);
		}
		t.found("this");
		t.found("t");
		t.found("the");
		t.found("byed");
	}

	public void doublylinkedlist() {

		class N {
			int d;
			N n;
			N p;
			final Random rand = new Random();
			final int MAX = 10;
			N () {
				this.d = rand.nextInt(MAX);
				this.n = this.p = null;
			}
			N(N n, N p) {
				this();
				this.n = n;
				this.p = p;
				if (n != null) n.p = this;
				if (p != null) p.n = this;
			}
			N (N n) {
				this();
				this.n = n;
				if (n != null) n.p = this;
			}
			void print() {
				for (N t = this;t != null;t = t.n) {
					System.out.print(t.d);
					System.out.print(' ');
				}
				System.out.println();
			}
			void delete(int d) {
				N t;
				for (t = this;t != null && t.d != d;t = t.n);
				if (t == null)
					return;
				N p = t.p == null ? null : t.p;
				N n = t.n == null ? null : t.n;
				if (n != null) n.p = p;
				if (p != null) p.n = n;
			}
		}

		N h = new N();
		h.n = new N(null, h);
		//h.n.n = new N(null, h.n);
		h.print();
		h.delete(h.n.d);
		h.print();
	}

	void maxarray() {
		//int[] a = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
		//int[] a = new int[] {3, 2, -3, 4, -2, -1, 5, -3};
		int[] a = new int[] {-2, 0};

		if (a == null || a.length == 0)
			return;

		int min = a[0], max = a[0];
		for (int i  = 1, len = a.length; i < len; i++) {
			if (min > a[i])
				min = a[i];
			if (max < a[i])
				max = a[i];
		}

		if (max <= 0) {
			System.out.println(max);
			return;
		}
		if (min >= 0) {
			int sum = a[0];
			for (int i  = 1, len = a.length; i < len;  sum += a[i++]);
			System.out.println(sum);
			return;
		}

		int max2 = 0;
		int max3 = 0;
		for (int i  = 0, len = a.length; i < len; i++) {
			max3 += a[i];
			if (max3 < 0)
				max3 = 0;
			else if (max3 > max2)
				max2 = max3;
		}
		if (max3 > max2)
			max3 = max2;
		System.out.println(max2);
	}

	void qsort(int[] a, int l, int h) {
		int i = l;
		int j = h;
		int p = l + (h-l)/2;
		while (i < j) {
			while (a[i] < a[p]) i++;
			while (a[j] > a[p]) j--;
			if (i < j) {
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
			if (i <= j) {
				i++;
				j--;
			}
		}
		if (i < h)
			qsort(a, i, h);
		if (j > l)
			qsort(a, l, j);
	}
	void sorting() {
		final Random rand = new Random();
		final int MAX = 10;
		int[] a = new int[MAX];
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = rand.nextInt(MAX);

		print(a);
		qsort(a, 0, a.length - 1);
		print(a);
	}

	public void sortedarray() {
		int[] a = new int[] {3, 4, 5, 1, 2};
		int p = -1;
		int l = 0;
		int h = a.length -1;
		while(l < h) {
			p = l + (h-l)/2;
			if (p + 1 <= h && a[p] > a[p+1] && p-1 >= 0 && a[p] > a[p-1]) break;
		}
		System.out.println(p);

	}
	boolean scanrow(int[][] a, int r) {
		if (a == null || a.length == 0 || a[0].length == 0 || r < 0 || r >= a.length )
			return false;
		for (int i = 0, c = a[0].length; i < c; i++)
			if (a[r][i] == 1)
				return true;
		return false;
	}
	boolean scancol(int[][] a, int c) {
		if (a == null || a.length == 0 ||a[0].length == 0 || c < 0 || c >= a[0].length)
			return false;
		for (int i = 0, r = a.length; i < r; i++)
			if (a[i][c] == 1)
				return true;
		return false;
	}
	// Set all the elements of the row to 1.
	void setallonesR(int[][] a, int r) {
		if (a == null || a.length == 0 || a[0].length == 0 || r < 0 || r >= a.length )
			return;
		for (int i = 0,  c = a[0].length; i < c; i++)
			a[r][i] = 1;
	}
	void setallonesC(int[][] a, int c) {
		if (a == null || a.length == 0 ||a[0].length == 0 || c < 0 || c >= a[0].length)
			return;
		for (int i = 0, r = a.length; i < r; i++)
			a[i][c] = 1;
	}

	public void fillmatrix2() {
		// http://stackoverflow.com/questions/10840044/microsoft-interview-transforming-a-matrix

		int[][] a = new int[][] {
				{1, 1, 0, 1, 0},
				{0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0},
				{1, 0, 1, 1, 0},
		};
		final int r = a.length;
		final int c = a[0].length;

		boolean frow = scanrow(a, 0);
		boolean fcol = scancol(a, 0);

		printm(a);

		// Store the values in first rwo and first col
		for (int i = 1; i < r; i++)
			a[i][0] = scanrow(a, i) ? 1 : 0;
		for (int i = 1; i < c; i++)
			a[0][i] = scancol(a, i) ? 1 : 0;

		if (frow || fcol)
			a[0][0] = 1;

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (a[i][j] == 0)
					a[i][j] = a[i][0] | a[0][j];
			}
		}

		if (frow)
			setallonesR(a, 0);
		if (fcol)
			setallonesC(a, 0);

		printm(a);
	}

	void printm(int[][] a) {
		final int r = a.length;
		final int c = a[0].length;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] < 10)
					System.out.print(' ');
				System.out.print(a[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
	}

	public void rotmatrix() {
		final int N = 5;
		final int M = 5;
		int[][] a = new int[N][M];
		for (int i = 0, c = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[i][j] = c++;
			}
		}
		printm(a);
		for (int i = 0, noiter = N % 2 == 0 ? N/2 : N/2 + 1; i < noiter; i++) { 
			for (int j = i,c = M-i-1; j < c; j++) {
				int temp = a[i][j];
				a[i][j] = a[N-1-j][i];
				a[N-1-j][i] = a[N-1-i][N-1-j]; 
				a[N-1-i][N-1-j] = a[j][N-1-i];
				a[j][N-1- i] = temp;
			}
		}
		printm(a);
	}
}

class X {
	public static void main(String[] args) {
		Y y = new Y();
		//y.game();
		//y.histogram();
		//y.stringMatch();
		//y.pondsandrivers();
		//y.heapsort();
		//y.kmostimportantstrings();
		//y.trie();
		//y.evennos();
		//y.trie2();

		//y.suffixtreeimplementa
		//y.simpletrie();

		//y.doublylinkedlist();

		//y.maxarray();
		//y.sorting();
		//y.sortedarray();
		//y.fillmatrix2();
		y.rotmatrix();
		System.out.println("Done");
	}
}