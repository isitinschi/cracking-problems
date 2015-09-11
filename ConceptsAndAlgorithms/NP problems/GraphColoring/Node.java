import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Node {
	
	private int color = -1;
	private List<Node> nodes;
	
	public Node(Node ...nodes) {
		this.nodes = new ArrayList<Node>(Arrays.asList(nodes));
		color = -1;
		for (Node node : nodes) {
			if (!node.nodes.contains(this)) {
				node.nodes.add(this);
			}
		}
	}
	
	public int colorify() {
		// default color to all
		Queue<Node> q = new LinkedList<>();
		q.add(this);
		Set<Node> visitedNodes = new HashSet<>();
		while (!q.isEmpty()) {
			Node n = q.remove();
			for (Node child : n.nodes) {
				if (!visitedNodes.contains(child)) {
					q.add(child);
				}
			}
			n.color = -1;
			visitedNodes.add(n);
		}
		
		// colorify
		List<Integer> colors = new ArrayList<>();
		q.clear();
		q.add(this);
		visitedNodes.clear();
		while (!q.isEmpty()) {
			Node n = q.remove();
			visitedNodes.add(n);
			Map<Integer, Boolean> map = new HashMap<>();
			for (Node child : n.nodes) {
				if (!visitedNodes.contains(child)) {
					q.add(child);
				}
				map.put(child.color, true);
			}
			boolean colored = false;
			for (Integer color : colors) {
				if (map.get(color) == null) {
					n.color = color;
					colored = true;
					break;
				}
			}
			if (!colored) {
				int newColor = colors.size();
				n.color = newColor;
				colors.add(newColor);
			}
		}
		
		return colors.size();
	}
	
	public static void main(String [] args) {
		Node node1 = new Node();
		Node node2 = new Node(node1);
		Node node3 = new Node(node2, node1);
		Node node4 = new Node(node3, node1);
		Node node5 = new Node(node4);
		Node node6 = new Node(node2, node4);
		Node node7 = new Node(node1, node5);
		Node node8 = new Node(node3, node5, node6);
		Node node9 = new Node(node6, node7);
		Node node10 = new Node(node1, node9);
		Node node11 = new Node(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10);
		
		int colors = node1.colorify();
		System.out.println("Used " + colors + " colors!");
	}
	
}