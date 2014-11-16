//import java.util.Random;

// Copied from SOF

class Node {
	Node left;
	Node right;
	int value;

	Node(int i) {
		this.value = i;
		this.left = this.right = null;
	}
	Node (final int i, final Node left, final Node right) {
		this.value = i;
		this.left = left;
		this.right = right;
	}
}

class Solutions {

	//private static Random rand = new Random();

//	private static void print(Node child, Node node) {
//		if (node == null || child == null)
//			return;
//		if (child == node.left) {
//			System.out.println("left child: " + child.value + " node: " + node.value);
//		}
//		else if (child == node.right){
//			System.out.println("right child " + child.value + " node : " + node.value);
//		}
//	}

	public static boolean isValid(Node root) {
	     return isValidBST(root, Integer.MIN_VALUE,
	          Integer.MAX_VALUE);
	}
	private static boolean isValidBST(Node node, int MIN, int MAX) {
	     if(node == null)
	         return true;
	     if(node.value > MIN 
	         && node.value < MAX
	         && isValidBST(node.left, MIN, Math.min(node.value,MAX))
	         && isValidBST(node.right, Math.max(node.value,MIN), MAX))
	         return true;
	     else {
	         return false;
	     } 
	}
	
	public static void main(String[] args) {

		// Set up the tree
		//					 	 100 
		//					   /     \ 
		//					 50      120
		//                  / \      /  \
		//                40  80     95  140 // 95 is illegal
		//                   /  \					
		//					70   110 // 110 is illegal

		Node node1 = new Node(70);
		Node node2 = new Node(90); // 110
		Node node3 = new Node(80, node1, node2);
		Node node4 = new Node(140);
		Node node5 = new Node(95);
		Node node6 = new Node(120, node5, node4);
		Node node7 = new Node(40);
		Node node8 = new Node(50, node7, node3);
		Node node9 = new Node(100, node8, node6);
		Node root = node9;
		
		boolean ret = isValid(root);
		if (!ret)
			System.out.println("Not valid\n");
	}
}