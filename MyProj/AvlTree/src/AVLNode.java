import java.util.Random;
import java.util.EnumMap;

public class AVLNode {
	private int data = 0;
	private AVLNode[] node = null;
//	private final static int NO_NODES = DIRECTIONS.values().length;
	private final static EnumMap<DIRECTIONS, Integer> DIRECTIONMAP = new EnumMap<DIRECTIONS, Integer>(DIRECTIONS.class);
	private int balance;

	// We will store the height as we need not travel everytime.
	private int ht;
	static enum BALANCE {
		PERFECT,
		LEFT_SLI_UNB,
		RIGHT_SLI_UNB,
		LEFT_TOTAL_UNB,
		RIGHT_TOTAL_UNB,
		UNBALANCED
	}
	final static EnumMap<BALANCE, Integer> BALANCEMAP = new EnumMap<BALANCE, Integer>(BALANCE.class);
	
	static {
		DIRECTIONMAP.put(DIRECTIONS.LEFT, 0);
		DIRECTIONMAP.put(DIRECTIONS.RIGHT, 1);

		BALANCEMAP.put(BALANCE.PERFECT, 0);
		BALANCEMAP.put(BALANCE.LEFT_SLI_UNB, -1);
		BALANCEMAP.put(BALANCE.RIGHT_SLI_UNB, 1);
		BALANCEMAP.put(BALANCE.LEFT_TOTAL_UNB, -2);
		BALANCEMAP.put(BALANCE.RIGHT_TOTAL_UNB, 2);
		BALANCEMAP.put(BALANCE.UNBALANCED, 2);
	}

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


	public void check_binary_tree() {
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);
		if (node != null) {
			if (node[left] != null) {
				if (node[left].data >= data)
					throw new RuntimeException("Mismatch with data in left tree.\n");
				else {
					node[left].check_binary_tree();
				}
			}
			if (node[right] != null) {
				if (node[right].data < data)
					throw new RuntimeException("Mismatch with data in right tree.\n");
				else {
					node[right].check_binary_tree();
				}
			}
		}
	}

	public void print_inorder_tree() {
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);
		if (node != null) {
			if (node[left] != null) {
				node[left].print_inorder_tree();
			}
		}
		print2();
		if (node != null) {
			if (node[right] != null) {
				node[right].print_inorder_tree();
			}
		}
	}

	public int treeHeight() {
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);
		if (node != null) {
			if (node[left] == null) { 
				if (node[right] == null)
					ht = 1;
				else 
					ht = 1 + node[right].treeHeight();
			} else {
				if (node[right] == null)
					ht = 1 + node[left].treeHeight();
				else
					ht = 1 + Math.max(node[left].treeHeight(),
							node[right].treeHeight());
			}
		} else {
			ht = 1;
		}
		return ht;
	}

	// The tree has grown in one direction.
	
	//      3
	//     / \
	//    X   4             4   
	//       / \           / \
	//      Y   5         3   5
	//                   / \
	//                  X   Y
	
	// dir: 0 -> LEFT
	// dir: 1 -> RIGHT
	
	// If right tree has more height 
	// then we need left rotation
	// IF left tree has more height
	// then we need right rotation.

	private AVLNode singleRotation(int dir) {
		
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);
		final int rdir = dir == left ? right : left;
		
		
		//      3  ---> node
		//     / \
		//    X   4  ----> s
		//       / \           
		//      Y   5         
		//                  
		
		AVLNode s = node[rdir];
		if (s.node == null)
			throw new RuntimeException("No children");
		node[rdir] = s.node[dir];
		s.node[dir] = this;
		
		s.check_binary_tree();
		return s;
	}


	// Double Rotation
	// Subtree is long in the opposite direction
	//
	//          3                        3    
	//         / \                      / \
	//        X   5                    X   4
	//           / \                      / \ 
	//          4   Y                    W   5
	//         / \                          / \
	//        W   Z                        Z   Y
	//
	//                    4
	//                   / \
	//                  /   \
	//                 3     5
	//                / \   / \
	//               X   W Z   Y
	//
	
	@SuppressWarnings("unused")
	private AVLNode doubleRotation(int dir) {
		
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);
		final int rdir = dir == left ? right : left;

		if (this.node == null || this.node[rdir].node == null)
			throw new RuntimeException();

		AVLNode s = this.node[rdir].singleRotation(rdir);
		this.node[rdir] = s;
		if (s != this.singleRotation(dir))
			throw new RuntimeException("Single Rotation Value mismatch");

		return s;
	}
	
	
	// Calculate Balance
	// 
	int balance() {
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);

		if (node == null)
			return 0;
		final int left_ht = node[left] != null ? Math.abs(node[left].treeHeight()) : 0;
		final int right_ht = node[right] != null ? Math.abs(node[right].treeHeight()) : 0;

		if (left_ht == 0)
			balance = 1 + right_ht;
		else if (right_ht == 0)
			balance = -1 - left_ht;
		else if (left_ht == right_ht)
			balance = 0;
		else
			balance = right_ht - left_ht;

		if (Math.abs(balance) >= BALANCEMAP.get(BALANCE.UNBALANCED))
			throw new RuntimeException("Out of Balance\n");

		return balance;
	}

	// Bounded Insertion
	// Adjusting balance
	// Balance is balance of right subtree - balance of left subtree
	// When one needs to have rotation when balance goes out of hand.
	// i.e. Balance becomes -2 or +2.
	// Both cases are symmetric.
	// When things will be +2
	
	
	// Single Rotation Case:
	//
	//				3+2              4 0
	//			   / \              / \
	//			  x	  4 +1  0      3   z 0 
	//               / \          / \
	//              y   z        x   y
	//
	//  

	// This function is called after insertion after rotation.
	// During insertion we may change the balance factors.
	// 
	private void adjustBalanceSingleRotation() {

		// this -> 3 is where violation takes place.
		int dir, rdir;
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);
		final int unbalanced = BALANCEMAP.get(BALANCE.UNBALANCED);
		final int perfect = BALANCEMAP.get(BALANCE.PERFECT);
		final int rightTotalUnbalanced = BALANCEMAP.get(BALANCE.RIGHT_TOTAL_UNB);
		final int rightSliUnbalanced = BALANCEMAP.get(BALANCE.RIGHT_SLI_UNB);
		final int leftSliUnbalanced = BALANCEMAP.get(BALANCE.LEFT_SLI_UNB);
		
		// Single Rotation Case
		if (Math.abs(this.balance) != unbalanced)
				return;

		dir = this.balance == unbalanced ? right : left;
		rdir = dir == right ? left : right; 
				
		// The balance factor of some of the nodes involve change.
		// We will adjust the height as well.

		if (node == null || node[rdir] == null)
			throw new RuntimeException("No children");

		AVLNode s = node[rdir];
		s.balance = perfect;
		this.balance = this.balance == rightTotalUnbalanced ? rightSliUnbalanced : leftSliUnbalanced ;

		// The height of all the nodes from root have to be changed. 

	}

	// Double Rotation Case
	//   Left tree unbalanced or right tree unbalanced
	//   Let us go with right tree unbalanced.
	//
	//          10 +2             10 +2               15  0
	//         /  \              /  \				 /  \
	//        5    20 -1        5   15 1			5   10 0
	//            /  \             /  \				   /  \          
	//         0 15   z           x   20 0			  12  20 0
	//          /  \                  / \				 /  \	
	//         x    y                y   z              18  30
	//
	//
	//   x -> hl1
	//   y -> hl2
	//   z -> hl3
	//   hl1 = hl2 .... (I)
	//   hl3 = hl1 ... (III)

	// After every insert balance of only few nodes will change.
	// I can call balance again and again for each node. 
	// That will be really expensive.
	
	// I will call balance in a different way.
	// Adjust balance should be called before insertion takes place.
	private void adjustBalanceDobleRotation() {
		int dir;
		int rdir;
		final int right = DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		final int left = DIRECTIONMAP.get(DIRECTIONS.LEFT);
		final int unbalanced = BALANCEMAP.get(BALANCE.UNBALANCED);
		final int perfect = BALANCEMAP.get(BALANCE.PERFECT);
		final int rightTotalUnbalanced = BALANCEMAP.get(BALANCE.RIGHT_TOTAL_UNB);
		final int rightSliUnbalanced = BALANCEMAP.get(BALANCE.RIGHT_SLI_UNB);
		final int leftSliUnbalanced = BALANCEMAP.get(BALANCE.LEFT_SLI_UNB);

		if (Math.abs(this.balance) != unbalanced)
			return;

		dir = this.balance == rightTotalUnbalanced ? right : left;

		rdir = dir == right ? left : right;
			
		AVLNode s = this.node[dir];
		AVLNode n = s.node[rdir];
		if (n.balance == perfect) {
			balance = perfect;	
			s.balance = perfect;
		} else if (n.balance == rightSliUnbalanced) {
//             10 +2				10  +2              15 0
//             /  \ 			   /  \                /   \  
//            w   20 -1 		  w    15 +1       -1 10    20 0
//               /  \                 /  \           /  \   / \
//           +1 15   z               x   20 0       w    x y   z
//			   /  \                      / \ 
//            x    y                    y   z 
//
//   
//		x -> hl1
//      y  -> hl1 + 1			
//      z  -> hl1 + 1
//      w -> hl1 + 1

			balance = leftSliUnbalanced;
			s.balance = perfect;
		} else {
// 			10 +2				10 +2					15 0
//	       /  \                /  \					  /	   \				
//        w   20 -1           w   15 	         +0 10      20 1
//           /  \                /  \			   /  \     / \ 	
//      -1  15   z              x    20           w    x   y   z
//         /  \                     /  \
//        x    y                   y    z
//			
//     x = hl1 + 1
//     y = hl1		
//     z = hl1 + 1
//     w = hl1 + 1			
			balance = perfect;
			s.balance = rightSliUnbalanced;
		}
		n.balance = perfect;
	}

	private void insert_balance() {
		
	}
	
	public void insert(AVLNode child ) {
		int dir = child.data < data ? DIRECTIONMAP.get(DIRECTIONS.LEFT) : DIRECTIONMAP.get(DIRECTIONS.RIGHT);
		if (node[dir] == null)
			node[dir] = new AVLNode(child.data);
		else
			node[dir].insert(child);	
	}
}