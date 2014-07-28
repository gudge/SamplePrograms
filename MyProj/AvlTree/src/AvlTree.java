

public class AvlTree {
	public static void main(String[] args) {
		System.out.println("Avl Tree Execution\n");
		AVLNode avlRoot = AVLNode.create_node();
		avlRoot.insert(AVLNode.create_node());
		for (int i = 0;  i < 10; i++) {
			avlRoot.insert(AVLNode.create_node());
		}
		
		System.out.println("Check the binary tree \n");
		avlRoot.check_binary_tree();
		avlRoot.print_inorder_tree();
		System.out.println("Height\n");
		System.out.println(avlRoot.treeHeight());
		System.out.println(avlRoot.balance());
	}
}