import java.util.Map;
import java.util.HashMap;

public class Node<T> {
	
	private T data;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T data) {
		this.data = data;
	}
	
	public void addLeft(Node<T> n) {
		left = n;
	}
	
	public void addRight(Node<T> n) {
		right = n;
	}
	
	public void printFirstLastOnEachLevel() {
		Map<Integer, Node<T>> firstNodes = new HashMap<>();
		Map<Integer, Node<T>> lastNodes = new HashMap<>();
		int maxLeft = populate(this.left, firstNodes, lastNodes, 1);
		int maxRight = populate(this.right, firstNodes, lastNodes, 1);
		
		System.out.println(data);
		int max = Math.max(maxLeft, maxRight);
		for (int depth = 1; depth <= max; ++depth) {
			Node<T> first = firstNodes.get(depth);
			Node<T> last = lastNodes.get(depth);
			if (first != null) {
				System.out.print(" " + first.data);
			}
			if (last != null) {
				System.out.print(" " + last.data);
			}
		}
	}
	
	private int populate(Node<T> node, Map<Integer, Node<T>> firstNodes, Map<Integer, Node<T>> lastNodes, int depth) {
		if (node == null) {
			return depth - 1;
		} else {
			if (firstNodes.get(depth) == null) {
				firstNodes.put(depth, node);
			} else {
				lastNodes.put(depth, node);
			}
			
			int maxLeft = populate(node.left, firstNodes, lastNodes, depth + 1);
			int maxRight = populate(node.right, firstNodes, lastNodes, depth + 1);
			return Math.max(maxLeft, maxRight);
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<>(1);
		Node<Integer> n1 = new Node<>(2);
		Node<Integer> n2 = new Node<>(3);
		root.addLeft(n1);
		root.addRight(n2);
		
		Node<Integer> n12 = new Node<>(4);
		n1.addRight(n12);
		
		Node<Integer> n21 = new Node<>(5);
		Node<Integer> n22 = new Node<>(6);
		n2.addLeft(n21);
		n2.addRight(n22);
		
		Node<Integer> n211 = new Node<>(7);
		n21.addLeft(n211);
		
		Node<Integer> n2112 = new Node<>(8);
		n211.addRight(n2112);
		
		root.printFirstLastOnEachLevel();
	}
		
}