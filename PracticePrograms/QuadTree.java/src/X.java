import java.util.ArrayList;
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

	void insert(int x, int y) throws Exception {
		insert(new Node(x, y));
	}
	void insert(Node r) throws Exception {
		insert(r, false);
	}
	int getdir(Node r) throws Exception {
		int dir = -1;
		if (r.x == this.x && r.y == this.y) {
			dir = -1;
		}	
		else if (r.x < this.x && r.y <= this.y) {
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
		return dir;
	}
	void print(int dir, Node r) {
		switch (dir) {
		case NW:
			System.out.print(this.x + ", " + this.y + " " + "NW: -> " + r.x + ", " + r.y + " ");
			break;
		case SW:
			System.out.print(this.x + ", " + this.y + " " + "SW: -> " + r.x + ", " + r.y + " ");
			break;
		case SE:
			System.out.print(this.x + ", " + this.y + " " + "SE: -> " + r.x + ", " + r.y + " ");
			break;
		case NE:
			System.out.print(this.x + ", " + this.y + " " + "NE: -> " + r.x + ", " + r.y + " ");
			break;
		}
		System.out.println();
	}
	void insert(Node r, boolean print) throws Exception {
		// Decide the Quadrant
		
		//   -------------------
	    //    NW        NE 	     
	         	
		//    SW        SE 
		//   -------------------
		
		// NE SE NW SW
		int dir = getdir(r);
		if (print) {
			print(dir, r);
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
	public void search(Node searchPoint, ArrayList<Integer> searchPath) throws Exception {
		int dir = getdir(searchPoint);
		searchPath.add(dir);
		print(dir, searchPoint);
		switch(dir) {
		case NW:
			if (this.NEQuad != null)
				this.NEQuad.search(searchPoint, searchPath);
			break;
		case SW:
			if (this.NEQuad != null)
				this.NEQuad.search(searchPoint, searchPath);
			break;
		case SE:
			if (this.NEQuad != null)
				this.NEQuad.search(searchPoint, searchPath);
			break;	
		case NE:
			if (this.NEQuad != null)
				this.NEQuad.search(searchPoint, searchPath);
			break;
		}
	}
	public void nearesetPoint(Node searchPoint) throws Exception {
		ArrayList<Integer> searchPath = new ArrayList<Integer>();
		this.search(searchPoint, searchPath);
		Node r = this;
		for (int i = 0, len = searchPath.size() - 2; i < len; i++) {
			r = getChild(searchPath.get(i), r);
		}
		if (searchPath.size() > 2) {
			searchPath = (ArrayList<Integer>) searchPath.subList(searchPath.size() - 2, searchPath.size());
		}
	}
	private Node getChild(int dir, Node r) {
		switch(dir) {
		case NE:
			r = r.NEQuad;
			break;
		case SE:
			r = r.SEQuad;
			break;
		case NW:
			r = r.NWQuad;
			break;
		case SW:
			r = r.SWQuad;
			break;
		}
		return r;
	}
}

// The idea to locate the closest point is to determine 
// 1) Calculate the distance between the parent and it' parent
// 2) Calculate the distance between for nearest neighbor squares.

class X {
	private static void foo() throws Exception {
//		Node head = new Node(3, 7);
//		head.insert(new Node(8, 1));
//		head.insert(new Node(6, 6));
//		head.insert(new Node(2, 6));
//		head.insert(new Node(1, 7));
//		head.insert(new Node(8, 6));
//		head.insert(new Node(5, 9));

		int[] points = new int[] {4, 4, 6, 8, 1, 3, 5, 6, 2, 2, 8, 5};

		Node head2 = new Node(4, 4);
		head2.insert(6, 8);
		head2.insert(1, 3);
		head2.insert(5, 6);
		head2.insert(2, 2);
		head2.insert(8, 5);

		Node searchPoint = new Node(3, 3);
		ArrayList<Integer> searchPath = new ArrayList<Integer>();
		head2.search(searchPoint, searchPath);
		double minDist = 0;
		int j = 0;
		for (int i = 0, len = points.length; i < len; i += 2) {
//			double dist = Math.sqrt((searchPoint.x - points[i]) * (searchPoint.x - points[i]) +
//					(searchPoint.y - points[i+1]) * (searchPoint.y - points[i+1]));
			// Sqrt calculation is expensive
			double dist = (searchPoint.x - points[i]) * (searchPoint.x - points[i]) +
					(searchPoint.y - points[i+1]) * (searchPoint.y - points[i+1]);
			if (minDist > dist) {
				j = i;
				minDist = dist;
			}
		}
		head2.nearesetPoint(searchPoint);
		System.out.println("Point : " + points[j] + ", " + points[j+1]);		
	}
	public static void main(String[] args) throws Exception {
		foo();
	}
}