public class Node<T> {
	
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public void add(Node<T> newNode) {
		Node<T> n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = newNode;
	}
	
	public void print() {
		Node<T> nextNode = this;
		while (nextNode != null) {
			System.out.println(nextNode.data);
			nextNode = nextNode.next;
		}
	}
	
	public Node<T> reverse() {
		Node<T> cur = this;		
		Node<T> nextNode = cur.next;
		cur.next = null; // now current node is the last one
		while (nextNode != null) {
			Node<T> temp = nextNode.next;
			nextNode.next = cur;
			cur = nextNode;
			nextNode = temp;
		}
		return cur;
	}
	
	public static void main(String[] args) {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);
		Node<Integer> n5 = new Node<>(5);
		
		n1.add(n2);
		n1.add(n3);
		n1.add(n4);
		n1.add(n5);
		
		System.out.println("Before: ");
		n1.print();
		
		n1 = n1.reverse();
		
		System.out.println("After: ");
		n1.print();
	}
	
}