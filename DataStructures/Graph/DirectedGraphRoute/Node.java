import java.util.List;
import java.util.ArrayList;

public class Node {

	private int data;
	private List<Node> nodes;
	private State state;
	
	public Node(int data) {
		this.data = data;
	}

	public void append(Node node) {
		if (nodes == null) {
			nodes = new ArrayList<Node>();
		}
		nodes.add(node);
	}
	
	public boolean isRouted() {
		markNotVisited();
		return searchRoute();
	}
	
	private void markNotVisited() {
		if (state == null || state != State.NOT_VISITED) {
			state = State.NOT_VISITED;
		} else {
			for (Node node : nodes) {
				node.markNotVisited();
			}
		}
	}
	
	private boolean searchRoute() {
		if (state == State.VISITED || state == State.VISITING) {
			return true;
		} else if (nodes != null) {
			state = State.VISITING;
			for (Node node : nodes) {
				if (node.searchRoute()) {
					return true;
				}
			}
			state = State.VISITED;
		}
		
		return false;
	}
	
	private enum State {
		VISITED, VISITING, NOT_VISITED;
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
		
		System.out.println("Graph is" + (!root.isRouted() ? " Not" : "") + " routed");
	}

}