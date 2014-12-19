import java.util.Random;

class Node {
	int x;
	int y;
	private static final int NW = 0;
	private static final int NE = 1;
	private static final int SE = 2;
	private static final int SW = 3;

	private static int MAX = 100;
	private static Random rand = new Random(MAX);

	Node NWQuad = null;
	Node NEQuad = null;
	Node SEQuad = null;
	Node SWQuad = null;

	Node() {
		this.x = rand.nextInt(MAX);
		this.y = rand.nextInt(MAX);
	}
	Node (int x, int y) {
		this.x = x;
		this.y = y;
	}

	void insert(Node r) throws Exception {
		// Decide the Quadrant
		
		//   -------------------
	    //    NW        NE 	     
	         	
		//    SW        SE 
		//   -------------------
		
		// NE SE NW SW
		if (r.x == this.x && r.y == this.y)
			return;
		int dir = -1;
		if (r.x < this.x && r.y <= this.y) {
			dir = NW;
		} else if (r.x <= this.x && r.y > this.y) {
			dir = SW;
		} else if (r.x >= this.x && r.y > this.y) {
			dir = SE;
		} else if (r.x > this.x && r.y <= this.y) {
			dir = NE;
		}
		if (dir == -1) {
			throw new Exception("Worng");
		}
		switch(dir) {
		case NW:
			if (this.NWQuad == null)
				this.NWQuad = r;
			else
				this.NWQuad.insert(r);
			break;
		case SW:
			if (this.SWQuad == null)
				this.SWQuad = r;
			else
				this.SWQuad.insert(r);
			break;
		case SE:
			if (this.SEQuad == null)
				this.SEQuad = r;
			else
				this.SEQuad.insert(r);
			break;
		case NE:
			if (this.NEQuad == null)
				this.NEQuad = r;
			else
				this.NEQuad.insert(r);
			break;
		}
	}
}

class X {
	private static void foo() throws Exception {
		Node head = new Node(3, 7);
		head.insert(new Node(8, 1));
		head.insert(new Node(6, 6));
		head.insert(new Node(2, 6));
		head.insert(new Node(1, 7));
		head.insert(new Node(8, 6));
		head.insert(new Node(5, 9));
	}
	public static void main(String[] args) throws Exception {
		foo();
	}
}