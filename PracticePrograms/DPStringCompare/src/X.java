class X {
	final static int MATCH = 0;
	final static int INSERT = 1;
	final static int DELETE = 2;
	final static int MAXLEN = 256;
	
	static class cell {
		int cost;
		int parent;
		
		cell() {
			
		}
	};
	
	private static void row_init(cell m[][], int i) {
		m[0][i].cost = i;
		if (i > 0)
			m[0][1].parent = INSERT;
		else
			m[0][1].parent = -1;
	}

	private static void col_init(cell m[][], int i) {
		m[0][i].cost = i;
		if (i > 0)
			m[i][0].parent = DELETE;
		else
			m[i][0].parent = -1;
	}
	
	private static int match(char c, char d) {
		return c == d ? 0 : 1;
	}

	private static int indel(int c) {
		return 1;
	}

	private static void print_mat(String p, String t, cell[][] m) {
		System.out.println();
		for (int i = 0; i < p.length(); i++) {
			if (i < 10)
				System.out.print(' ');
			System.out.print(i);
			System.out.print(' ');
			System.out.print(' ');
			System.out.print(' ');
			for (int j = 0; j < t.length(); j++) {
				if (j >= 10 && i != 0 && m[i][j].cost < 10)
					System.out.print(' ');
				System.out.print(m[i][j].cost);
				System.out.print(' ');
			}
			System.out.println();
			if (i == 0)
				System.out.println();
		}
		
	}

	static class goalCell {
		int i;
		int j;
	};
	
	private static goalCell goal_cell(String str, String str2) {
		goalCell c = new goalCell();
		c.i = str.length() - 1;
		c.j = str2.length() - 1;
		return c;
	}

	private static void match_out(String pattern, String text, int i, int j) {
		if (pattern.charAt(i) == pattern.charAt(j)) System.out.print("M");
		else System.out.print("S");
	}
	private static void insert_out(String text, int j) {
		System.out.print("I");
	}
	private static void delete_out(String pattern, int i) {
		System.out.print("D");
	}
	private static void reconstructpath(String pattern, String text, cell[][] m, int i, int j) {
		if (m[i][j].parent == -1) return;
		switch (m[i][j].parent) {
			case MATCH:
				reconstructpath(pattern, text, m, i - 1, j - 1);
				match_out(pattern, text, i , j);
				break;
			case INSERT:
				reconstructpath(pattern, text, m, i, j-1);
				insert_out(text, j);
				break;
			case DELETE:
				reconstructpath(pattern, text, m, i-1, j);
				delete_out(pattern, i);
				break;
		}	
	}
	
	// p-> pattern
	// t-> text
	private static int string_compare(String p, String t) {
		
		int opt[] = new int[3];
		cell m[][] = new cell[MAXLEN + 1][MAXLEN + 1];
		for (int i = 0; i < MAXLEN + 1; i++) {
			m[i] = new cell[MAXLEN + 1];
		}
		for (int i = 0; i <= MAXLEN; i++) {
			row_init(m, i);
			col_init(m, i);
		}
		for (int i = 1; i < p.length(); i++) {
			char ic = p.charAt(i);
			for (int j = 1; j < t.length(); j++) {
				char jc = t.charAt(j);
				int c1 = m[i - 1][j - 1].cost;
				int c2 = m[i][j-1].cost;
				int c3 = m[i -1][j].cost;
				opt[MATCH] = c1 + match(ic, jc);
				opt[INSERT] = c2 + indel(jc);
				opt[DELETE] = c3 + indel(ic);
				m[i][j].cost = opt[MATCH];
				m[i][j].parent = MATCH;
				for (int k = INSERT; k <= DELETE; k++) {
					if (opt[k] < m[i][j].cost) {
						m[i][j].cost = opt[k];
						m[i][j].parent = k;
					}
				}
			}
		}

		//print_mat(p, t, m);
		goalCell c = goal_cell(p, t);
		reconstructpath(p, t, m, c.i, c.j);
		return m[c.i][c.j].cost;
	}

	public static void main(String[] args) {
		String text = " thou shalt not";
		String pattern = " you should not";
		System.out.println(text);
		System.out.println(pattern);
		int cost = string_compare(pattern, text);
		System.out.println(cost);
	}
}