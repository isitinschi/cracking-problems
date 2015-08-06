public class Node {
	
	private int data;
	private Node left;
	private Node right;
	
	public Node(int value) {
		data = value;
	}
	
	private static boolean isBST(Node head) {
		if (head == null) {
			return false;
		}
		
		return checkBST(head);	
	}
	
	private static boolean checkBST(Node n) {
		boolean valid = true;
		
		if (n.left != null) {
			if (n.left.data <= n.data) {
				valid = checkBST(n.left);
			} else {
				return false;
			}
		}
		if (n.right != null) {
			if (n.right.data > n.data) {
				valid = checkBST(n.right);
			} else {
				return false;
			}
		}
		
		return valid;
	}
	
	public static void main(String [] args) {
		Node head = new Node(4);
		
		Node node1 = new Node(2);
		Node node2 = new Node(6);
		head.left = node1; 
		head.right = node2;
		Node node3 = new Node(1);
		Node node4 = new Node(3);
		node1.left = node3;
		node1.right = node4;
		Node node5 = new Node(5);
		Node node6 = new Node(7);
		node2.left = node5;
		node2.right = node6;
		
		System.out.println("Is BST? " + isBST(head));
	}
}