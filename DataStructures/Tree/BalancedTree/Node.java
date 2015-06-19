import java.util.List;
import java.util.ArrayList;

public class Node {

	private int data;
	private List<Node> nodes;
	
	public Node(int data) {
		this.data = data;
	}

	public void append(Node node) {
		if (nodes == null) {
			nodes = new ArrayList<Node>();
		}
		nodes.add(node);
	}
	
	public boolean isBalanced() {
		return maxDepth(0) - minDepth(0) <= 1;
	}
	
	private int maxDepth(int curDepth) {
		if (nodes == null) {
			return curDepth;
		} else {
			int maxDepth = Integer.MIN_VALUE;
			for (Node node : nodes) {
				int depth = node.maxDepth(curDepth + 1);
				if (maxDepth < depth) {
					maxDepth = depth;
				}
			}
			return maxDepth;
		}
	}
	
	private int minDepth(int curDepth) {
		if (nodes == null) {
			return curDepth;
		} else {
			int minDepth = Integer.MAX_VALUE;
			for (Node node : nodes) {
				int depth = node.minDepth(curDepth + 1);
				if (minDepth > depth) {
					minDepth = depth;
				}
			}
			return minDepth;
		}
	}

	public static void main(String... args) {
		Node root = new Node(1);
		Node node11 = new Node(2);
		Node node12 = new Node(3);
		Node node13 = new Node(3);
		
		Node node211 = new Node(4);
		Node node212 = new Node(5);
		Node node221 = new Node(6);
		Node node222 = new Node(7);
		Node node231 = new Node(8);
		
		root.append(node11);
		root.append(node12);
		root.append(node13);
		
		node11.append(node211);
		node11.append(node212);
		node12.append(node221);
		node12.append(node222);
		node13.append(node231);
		
		System.out.println("Tree is " + (!root.isBalanced() ? "Not" : "") + " balanced");
	}

}