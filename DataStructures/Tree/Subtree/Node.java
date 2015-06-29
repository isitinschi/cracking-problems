import java.util.Scanner;

public class Node {

	private int data;
	private Node left;
	private Node right;

	
	public Node(int data) {
		this.data = data;
	}

	public void appendLeft(Node node) {
		left = node;
	}
	
	public void appendRight(Node node) {
		right = node;
	}
	
	public static void main(String... args) {
		Node t1 = new Node(5);
		
		Node left1 = new Node(3);
		Node right1 = new Node(7);
		t1.appendLeft(left1);
		t1.appendRight(right1);
		
		Node left21 = new Node(2);
		Node right21 = new Node(4);
		left1.appendLeft(left21);
		left1.appendRight(right21);
		
		Node left22 = new Node(6);
		Node right22 = new Node(8);
		right1.appendLeft(left22);
		right1.appendRight(right22);
		
		Node left321 = new Node(1);
		left21.appendLeft(left321);
		
		Node t2 = new Node(7);
		Node left = new Node(6);
		Node right = new Node(8);
		t2.appendLeft(left);
		t2.appendRight(right);
		
		System.out.println(isSubtree(t1, t2));
		
	}
	
	private static boolean isSubtree(Node node1, Node node2) {
		if (subtree(node1, node2)) {
			return true;
		} else {
			if (node1.left != null) {
				if (isSubtree(node1.left, node2)) {
					return true;
				}
			}
			if (node1.right != null) {
				if (isSubtree(node1.right, node2)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean subtree(Node node1, Node node2) {
		if (node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null) {
			if (node1.data == node2.data) {
				return subtree(node1.left, node2.left) && subtree(node1.right, node2.right);
			}
		}
		
		return false;
	}

}