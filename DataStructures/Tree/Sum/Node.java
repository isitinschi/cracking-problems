import java.lang.StringBuilder;

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
		
		Node left321 = new Node(0);
		left21.appendLeft(left321);
		
		findSums(root, 10);
	}
	
	private static void findSums(Node root, int sum) {
		findSums(root, sum, 0, new StringBuilder());
	}
	
	private static void findSums(Node node, int sum, int curSum, StringBuilder builder) {
		if (node == null) {
			return;
		}
		
		curSum += node.data;
		builder.append(node.data).append(" ");
		
		if (curSum == sum) {
			System.out.println(builder);
		}		
		 
		findSums(node.left, sum, curSum, new StringBuilder(builder));
		findSums(node.right, sum, curSum, new StringBuilder(builder));
		
		findSums(node.left, sum, 0, new StringBuilder());
		findSums(node.right, sum, 0, new StringBuilder());
	}

}