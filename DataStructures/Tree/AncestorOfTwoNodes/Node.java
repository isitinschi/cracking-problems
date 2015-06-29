import java.util.Scanner;

public class Node {

	private int data;
	private Node left;
	private Node right;
	private Node parent;
	private Status status;
	
	private enum Status {
		VISITED, UNVISITED;
	}
	
	public Node(int data) {
		this.data = data;
	}

	public void appendLeft(Node node) {
		left = node;
		node.parent = this;
	}
	
	public void appendRight(Node node) {
		right = node;
		node.parent = this;
	}
	
	public boolean search(Node node) {
		if (node == null) {
			return false;
		}
		if (node == this) {
			return true;
		}
		
		boolean found = false;
		if (left != null) {
			found = left.search(node);
		}
		
		if (found) {
			return true;
		} else if (right != null) {
			return right.search(node);
		}
		
		return false;
	}
	
	public static void main(String... args) {
		Node root = new Node(5);
		
		Node left1 = new Node(3);
		Node right1 = new Node(7);
		root.appendLeft(left1);
		root.appendRight(right1);
		
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
		
		boolean checked = true;
		if (root != ancestor(root, left321, right22)) {
			checked = false;
		}
		if (right1 != ancestor(root, right22, left22)) {
			checked = false;
		}
		if (left1 != ancestor(root, left321, right21)) {
			checked = false;
		}
		if (null != ancestor(root, left321, new Node(666))) {
			checked = false;
		}
		if (left1 != ancestor(root, left1, right21)) {
			checked = false;
		}
		
		System.out.println("Work status: " + checked);
	}
	
	// Solution 1 with parent reference
	private static Node ancestor(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return null;
		}
		
		markNotVisited(node1);
		markNotVisited(node2);
		
		Node up = node1;
		do {
			up.status = Status.VISITED;			
		} while ((up = up.parent) != null);
		
		up = node2;
		do {
			if (up.status == Status.VISITED) {
				return up;
			}
		} while ((up = up.parent) != null);
		
		return null;
	}
	
	// Solution 2 without parent reference
	private static Node ancestor(Node root, Node node1, Node node2) {
		if (root == null || node1 == null || node2 == null) {
			return null;
		}
		if (root.search(node1) && root.search(node2) == false) {
			return null;
		}
		
		return ancestorWithoutParentReference(root, node1, node2);
	}
	
	private static Node ancestorWithoutParentReference(Node root, Node node1, Node node2) {			
		if (root.left != null) {
			boolean found1 = root.left.search(node1);
			boolean found2 = root.left.search(node2);
			if (found1 && found2 == true) {
				return ancestorWithoutParentReference(root.left, node1, node2);
			} else if (found1 == true || found2 == true) {
				return root;
			}
		}
		
		if (root.right != null) {
			boolean found1 = root.right.search(node1);
			boolean found2 = root.right.search(node2);
			if (found1 && found2 == true) {
				return ancestorWithoutParentReference(root.right, node1, node2);
			} else if (found1 == true || found2 == true) {
				return root;
			}
		}
			
		return null;
	}
	
	private static void markNotVisited(Node node) {
		node.status = Status.UNVISITED;
		if (node.parent != null) {
			markNotVisited(node.parent);
		}
	}

}