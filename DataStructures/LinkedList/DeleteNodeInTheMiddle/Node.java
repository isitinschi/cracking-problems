public class Node {
	
	private int data;
	private Node next;
	
	public Node(int value) {
		data = value;
	}
	
	private static void remove(Node node) {
		Node next = node;
		while (next != null) {
			next.data = next.next.data;
			if (next.next.next == null) {
				next.next = null;
				break;
			} else {
				next = next.next;
			}
		}
	}
	
	public static void main(String [] args) {
		Node head = new Node(1);
		Node node1 = new Node(2);
		head.next = node1; 
		Node node2 = new Node(3);
		node1.next = node2;
		Node node3 = new Node(4);
		node2.next = node3;
		Node node4 = new Node(5);
		node3.next = node4;
		Node node5 = new Node(6);
		node4.next = node5;
		
		remove(node3);
		
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}