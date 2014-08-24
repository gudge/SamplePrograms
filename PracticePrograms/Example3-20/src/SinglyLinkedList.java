import java.util.Random;



class Node {
	int data;
	Node next;
	public final static Random rand = new Random();
	public final static int value = 1000;
	public Node() {
		this.data = rand.nextInt(value);
		this.next = null;
	}
	public Node(Node prev) {
		this();
		prev.next = this;
	}
	void traverse() {
		Node n = this;
		while (n != null) {
			n.print();
			n = n.next;
		}
	}
	int length() {
		Node n = this;
		int count = 1;
		while (n != null) {
			count++;
			n = n.next;
		}
		return count;
	}
	void print() {
		//System.out.println("Data = " + data + " ");
	}
}

public class SinglyLinkedList {
	Node build() {
		final Node root = new Node();
		Node traverse = root;
		for (int i = 0; i < Node.rand.nextInt(Node.value) - 1; i++) {
			Node n = new Node(traverse);
			traverse = n;
		}
		return root;
	}
	
	Node middle(Node tree) {
		Node fast = tree;
		Node slow = tree;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		SinglyLinkedList s = new SinglyLinkedList();
		Node head = s.build();
		System.out.println("Length of the list : " + head.length());
		head.traverse();
		final int pos = head.length() - s.middle(head).length();
		System.out.println("Middle element position = " + pos);
	}
}