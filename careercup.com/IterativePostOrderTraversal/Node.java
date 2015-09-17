import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class Node {
	
	private int val;
	private List<Node> children;
	
	public Node(int val) {
		this.val = val;
	}
	
	public void printWithIterativePostOrderTraversal() {
		Stack<Integer> print = new Stack<>();
		Stack<Node> traverse = new Stack<>();
		traverse.push(this);
		
		while (!traverse.isEmpty()) {
			Node n = traverse.pop();
			print.push(n.val);
			if (n.children != null) {
				for (Node child : n.children) {
					traverse.push(child);
				}
			}
		}
		
		while(!print.isEmpty()) {
			System.out.print(" " + print.pop());
		}
	}
	
	public void printWithRecursivePostOrderTraversal() {
		if (children != null) {
			for (Node child : children) {
				child.printWithRecursivePostOrderTraversal();
			}
		}
		System.out.print(" " + val);
	}
	
	public void setChildren(Node... children) {
		this.children = Arrays.asList(children);
	}
	
	public static void main(String[] args) {
		Node root = new Node(4);
		Node n1 = new Node(2);
		Node n2 = new Node(6);
		Node n11 = new Node(1);
		Node n12 = new Node(3);		
		Node n21 = new Node(5);
		Node n22 = new Node(7);
		
		root.setChildren(n1, n2);
		n1.setChildren(n11, n12);
		n2.setChildren(n21, n22);
		
		System.out.println("Iterative: ");
		root.printWithIterativePostOrderTraversal();
		
		System.out.println("Recursive: ");
		root.printWithRecursivePostOrderTraversal();
	}
	
}