public class Node {
	
	private int data;
	private Node next;
	
	public Node(int value) {
		data = value;
	}
	
	private static void partition(Node head, int x) {
		if (head == null) {
			return;
		}
		
		Node storedNode = head;
		Node next = head.next;
		while (next != null) {
			if (next.data < x) {
				swap(storedNode, next);
				storedNode = storedNode.next;
			} 
			next = next.next;
		}
	}
	
	private static void swap(Node n1, Node n2) {
		int t = n1.data;
		n1.data = n2.data;
		n2.data = t;
	}
	
	public static void main(String [] args) {
		Node head = new Node(6);
		Node node1 = new Node(5);
		head.next = node1; 
		Node node2 = new Node(4);
		node1.next = node2;
		Node node3 = new Node(3);
		node2.next = node3;
		Node node4 = new Node(2);
		node3.next = node4;
		Node node5 = new Node(1);
		node4.next = node5;
		
		partition(head, 3);
		
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}