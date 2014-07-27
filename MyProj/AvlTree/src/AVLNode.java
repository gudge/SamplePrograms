import java.util.Random;


public class AVLNode {
	private int data = 0;
	AVLNode[] node = null;
	final static int RIGHT = DIRECTIONS.RIGHT.ordinal();
	final static int LEFT = DIRECTIONS.LEFT.ordinal();
	final static int NO_NODES = DIRECTIONS.values().length;
	int balance;

	public AVLNode(int data) {
		this.data = data;
		this.node = new AVLNode[DIRECTIONS.values().length];
		for (int i = 0, length = DIRECTIONS.values().length; i< length; i++) {
			//this.node[i] = new AVLNode();
			this.node[i] = null;
		}
	}
	
	public void print() {
		System.out.println("Data: " + data + "\n");
		System.out.println("Children : \n");
		for (int i = 0; i < DIRECTIONS.values().length; i++) {
			if (this.node[i] == null)
				continue;
			this.node[i].print();
		}
	}

	public void print2() {
		System.out.println("Data: " + data + "\n");
	}
	
	static AVLNode create_node() {
		Random rand = new Random();
		AVLNode node = new AVLNode(rand.nextInt(1000));
		return node;
	}
	
//	private boolean ifChildExists(final int childID) {
//		return node[childID] != null;
//	}

	public void insert(AVLNode child ) {
		int dir = child.data < data ? LEFT : RIGHT;
		if (node[dir] == null)
			node[dir] = new AVLNode(child.data);
		else
			node[dir].insert(child);	
	}

	public void check_binary_tree() {
		if (node != null) {
			if (node[LEFT] != null) {
				if (node[LEFT].data >= data)
					throw new RuntimeException();
				node[LEFT].check_binary_tree();
			}
			if (node[RIGHT] != null) {
				if (node[RIGHT].data < data)
					throw new RuntimeException();
				node[RIGHT].check_binary_tree();
			}
		}
		
	}

	public void print_inorder_tree() {
		if (node != null) {
			if (node[LEFT] != null) {
				node[LEFT].print_inorder_tree();
			}
		}
		print2();
		if (node != null) {
			if (node[RIGHT] != null) {
				node[RIGHT].print_inorder_tree();
			}
		}
	}

	public int treeHeight() {
		if (node != null) {
			if (node[LEFT] == null) { 
				if (node[RIGHT] == null)
					return 1;
				else 
					return 1 + node[RIGHT].treeHeight();
			} else {
				if (node[RIGHT] == null)
					return 1 + node[LEFT].treeHeight();
				else
					return 1 + Math.max(node[LEFT].treeHeight(), node[RIGHT].treeHeight());
			}
		}
		return 1;
	}
	public void singleRotation() {
		
	}
	
	
//	private AVLNode() {
//		this.node = null;
//	}
}