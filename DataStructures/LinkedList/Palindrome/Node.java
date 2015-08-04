import java.util.Stack;

public class Node {
	
	private int data;
	private Node next;
	
	public Node(int value) {
		data = value;
	}
	
	private static boolean palindrome(Node head) {
		if (head == null) {
			return false;
		}
		
		Node next = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (next != null) {
			stack.push(next.data);
			next = next.next;
		}
		
		next = head;
		int check = stack.pop();
		while (next.data == check) {
			if (stack.isEmpty()) {
				return true;
			} else {
				next = next.next;
				check = stack.pop();
			}
		}
		
		return false;
	}
	
	public static void main(String [] args) {
		Node head = new Node(6);
		Node node1 = new Node(5);
		head.next = node1; 
		Node node2 = new Node(4);
		node1.next = node2;
		Node node3 = new Node(4);
		node2.next = node3;
		Node node4 = new Node(5);
		node3.next = node4;
		Node node5 = new Node(6);
		node4.next = node5;
		
		System.out.println("Is Palindrome? " + palindrome(head));
	}
}