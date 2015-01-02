import java.util.ArrayList;


class Y {
	
	void foo2() {
		class Y2 {
			int x;
			int y;
			Y2(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		class Y3 {
			Y2 y2;
			Y3 next2 = null;
			Y3(int x, int y) {
				this.y2 = new Y2(x, y);
			}
			public void insert(int x, int y) {
				if (x < 0 || x > 2 || y < 0 || y > 2)
					return;
				Y3 y3 = new Y3(x, y);
				Y3 y4 = this;
				for (;y4.next2 != null;y4 = y4.next2) {
					if (y4.y2.x == x && y4.y2.y == y) {
						return;
					}
				}
				y4 = this;
				for (;y4.next2 != null;y4 = y4.next2);
				y4.next2 = y3;
			}
		}
		class Y4 {
			final static int X = 1;
			final static int O  = 2;
			Y2 y2;
			int group;		
			Y4(Y2 y2, int group) {
				this.y2 = y2;
				this.group = group;
			}
		}
		Y3 head = new Y3(0, 0);
		head.insert(1, 1);
		
		ArrayList<Y4>
	}

	void foo1() {
		class Y2 {
			int x, y;
			Y2 next = null;
			Y2 (int x, int y) {
				this.x = x;
				this.y = y;
			}
			void insert(Y2 y2) {
				if (y2 == null)
					return;
				if (this.x == y2.x && this.y == y2.y)
					return;
				if (this.next == null) {
					this.next = y2;
				} else {
					this.next.insert(y2);
				}
			}
			void insert(int x, int y) {
				Y2 y2 = new Y2(x, y);
				this.insert(y2);
			}
			void print() {
				System.out.print("(" + this.x + ", " + this.y + ")  ");
				if (this.next != null) {
					if (this.next.y != this.y) {
						System.out.println();
					}
					this.next.print();
				}
			}
			void remove() {
				Y2 r = this;
				while (true) {
					if (r == null || r.next == null || r.next.next == null)
						break;
					Y2 n = r.next;
					Y2 n2 = n.next;
					if (n.y == r.y) {
						if (n2.y == r.y) {
							r.next = n2;
						} else if (n2.x == n.x) {
							r = n2;
						} else {
							break;
						}
					}
				}
			}
		};

		Y2 head = new Y2(0, 10);
		head.insert(1, 10); head.insert(5, 10); head.insert(10, 10);
		head.insert(10, 5); head.insert(20, 5); head.insert(40, 5);

		head.remove();
		head.print();
	}
}


class X {
	public static void main(String[] args) {
		Y y = new Y();
//		y.foo1();
		y.foo2();
	}
}