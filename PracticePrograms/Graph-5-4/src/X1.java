import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


// From inorder and pre order reconstruct the tree.

//Tree       : 0 3 17 8 1 19 16 2 18 6 
//Inorder    : 8 17 3 19 1 0 18 2 16 6 
//Preorder   : 0 3 17 8 1 19 16 2 18 6 
//Count      : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
//Tree array : 0 3 16 17 1 2 6 8 X 19  X 18  X  X  X  X 

class X1_1 {
	final static int nos = 10;
	final static Random rand = new Random();
	
	public int getN() {
		int i;
//		do {
//			i = rand.nextInt();
//		} while (i == 0 || i == 1);
		i = rand.nextInt(nos);
		return i;
	}
}


class Node {
	int data;
	Node[] child = new Node[2];
	int ht;
	Node() {
		X1_1 x1 = new X1_1();
		data = x1.getN();
		child = new Node[2];
		for (int i = 0; i < 2; i++)
			child[i] = null;
		ht = 1;
	}
	Node (int data) {
		this();
		this.data = data;
	}
}

class Tree {
	private Node head;
	int[]  treeArray;
	int[]  treeArrayReConst;
	final static int noNodes = 10;
	int[] inorder = new int[noNodes];
	int[] preorder = new int[noNodes];
	int inorderPos = 0, preOrderPos = 0;
	ArrayList<Integer> aL = new ArrayList<Integer>(2 * noNodes);
	Node buildTree() {
		for (int i = 0; i < 2 * noNodes; i++) {
			aL.add(i);
		}
		Collections.shuffle(aL);
		head = new Node(aL.get(0));
		for (int i = 0; i < noNodes - 1; i++) {
			Node traverse = head;
			Node node = new Node(aL.get(i + 1));
			while (true) {
				if (traverse.child[0] == null) {
					traverse.child[0] = node;
					updateHt(head);
					break;
				}	
				if (traverse.child[1] == null) {
					traverse.child[1] = node;
					updateHt(head);
					break;
				}
				int l_ht = traverse.child[0].ht;
				int r_ht = traverse.child[1].ht;
				if (l_ht <= r_ht)
					traverse = traverse.child[0];
				else
					traverse = traverse.child[1];
			}
		}
		treeArray = new int[(int) (Math.pow(2, head.ht))];
		treeArrayReConst = new int[(int) (Math.pow(2, head.ht))];
		for (int i = 0; i < treeArray.length; i++) {
			treeArray[i] = -1;
			treeArrayReConst[i] = -1;
		}
		return head;
	}
	private int updateHt(Node node) {
		int l = node.child[0] != null ? updateHt(node.child[0]) : 0;
		int r = node.child[1] != null ? updateHt(node.child[1]) : 0;
		node.ht = Math.max(l, r) + 1;
		return node.ht;
	}
	void printInorder() {
		printInorderH(head);
	}
	void printInorderH(Node node) {
		if (node == null)
			return;
		printInorderH(node.child[0]);
		inorder[inorderPos++] = node.data;
		printInorderH(node.child[1]);
	}
	Node getHead() {
		return head;
	}
	void printTraversal() {
		System.out.print("Inorder    : ");
		for (int i = 0; i < noNodes; i++) {
			System.out.print(inorder[i]);
			System.out.print(' ');
		}
		System.out.println();
		System.out.print("Preorder   : ");
		for (int i = 0; i < noNodes; i++) {
			System.out.print(preorder[i]);
			System.out.print(' ');
		}
		System.out.println();
		System.out.print("Count      : ");
		for (int i = 0; i < treeArray.length; i++) {
			System.out.print(i);
			System.out.print(' ');
		}
		System.out.println();
		System.out.print("Tree array : ");
		for (int i = 0; i < treeArray.length; i++) {
			if (treeArray[i] == -1) {
				if (i < 10)
					System.out.print('X');
				else
					System.out.print(" X");
			}
			else
				System.out.print(treeArray[i]);
			System.out.print(' ');
		}
		System.out.println();
		System.out.print("Re constr : ");
		for (int i = 0; i < treeArrayReConst.length; i++) {
			System.out.print(treeArrayReConst[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	void printTree() {
		System.out.print("Tree       : ");
		System.out.print(head.data);
		System.out.print(' ');
		printTreeH(head.child[0]);
		printTreeH(head.child[1]);
		System.out.println();
	}
	void printTreeH(Node node) {
		if (node == null)
			return;
		//System.out.print("R: ");
		System.out.print(node.data);
		System.out.print(' ');
		//System.out.print("C1: ");
		printTreeH(node.child[0]);
		//System.out.print("C2: ");
		printTreeH(node.child[1]);
	}
	void printPreorder() {
		printPreorderH(head);
	}
	void printPreorderH(Node node) {
		if (node == null)
			return;
		preorder[preOrderPos++] = node.data;
		printPreorderH(node.child[0]);
		printPreorderH(node.child[1]);
	}
	void convertArray() {
		converArrayH(head, 1);	
		for (int i = 0; i < treeArray.length - 1; i++) {
			treeArray[i] = treeArray[i+1];
		}
		int c = 0;
		for (int i = 0; i < treeArray.length; i++) {
			if (treeArray[i] == -1)
				c += 1;
		}
		if (treeArray.length - c != noNodes) {
			System.out.println("Wronng\n");
		}
	}
	void converArrayH(Node node, int pos) {
		if (node == null)
			return;
		//System.out.println(pos);
		treeArray[pos] = node.data;
		converArrayH(node.child[0], 2 * pos);
		converArrayH(node.child[1], 2 * pos + 1);
	}
	// reconstuct tree form inorder and pre order
	void constructTree() {
		// reconstruct from inorder and preorder
		//Tree       : 0 3 17 8 1 19 16 2 18 6 
		//Inorder    : 8 17 3 19 1 0 18 2 16 6 
		//Preorder   : 0 3 17 8 1 19 16 2 18 6 
		//Count      : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
		//Tree array : 0 3 16 17 1 2 6 8 X 19  X 18  X  X  X  X 
		for (int i = 0, j = 0; i < preorder.length; i++) {
			int l = 0, h = preorder.length;
			for (j = l; j < h && inorder[i] != preorder[i]; j++);
			
		}
		constructTreeH(0 , inorder.length, 0);
	}
	int constructTreeH(int l, int h, int r) {
		if (l < 0 || h > inorder.length || l > h)
			return;
		int root = preorder[r], i;
		for (i = l; i < h && inorder[i] != root; i++);
		if (i == inorder.length) {
			return;
		}
		treeArrayReConst[r] = root;
		constructTreeH(l, i - 1, i);
		constructTreeH(i + 1, h, i);
	}
}

class X1 {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.buildTree();
		t.printInorder();
		t.printPreorder();
		t.printTree();
		t.convertArray();
		t.constructTree();
		t.printTraversal();
	}
}