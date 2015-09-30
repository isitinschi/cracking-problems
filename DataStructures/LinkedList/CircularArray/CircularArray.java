import java.lang.Iterable;
import java.util.Iterator;

public class CircularArray<T> implements Iterable<T> {
	
	private class Node {
		private T data;
		private Node next;
		private Node prev;
		
		public Node(T data) {
			this.data = data;
		}
		
		public void setNext(Node node) {
			next = node;
		}
		
		public void setPrev(Node node) {
			prev = node;
		}
		
		public Node getPrev() {
			return prev;
		}
		
		public Node getNext() {
			return next;
		}
		
		public T getValue() {
			return data;
		}
		
	}
	
	private Node head = null;
	private Node tail = null;
	
	public void add(T value) {
		if (head == null) {
			head = new Node(value);
			tail = head;
		} else {
			Node node = new Node(value);
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}
	
	public void rotate(int n) {
		if (n == 0 ||  head == null || head == tail) {
			return;
		}
		
		if (n > 0) {
			int i = 0;
			while (i++ < n) {
				Node node = tail;
				node.setNext(head);
				head.setPrev(node);
				head = node;
				
				tail = tail.getPrev();
				tail.setNext(null);
				
				head.setPrev(null);
			}
		} else {
			n *= -1;
			int i = 0;
			while (i++ < n) {
				Node node = head;
				node.setPrev(tail);
				tail.setNext(node);
				
				head = head.getNext();
				head.setPrev(null);
				
				tail = node;
				tail.setNext(null);
			}
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new CircularIterator(head);
	}
	
	private class CircularIterator implements Iterator<T> {
		
		private Node head;
		
		public CircularIterator(Node head) {
			this.head = head;			
		}
		
		@Override
		public boolean hasNext() {
			return head != null;
		}
		
		@Override
		public T next() {
			if (head == null) {
				throw new ArrayIndexOutOfBoundsException();
			}
			T val = head.data;
			head = head.getNext();
			return val;
		}
		
	}
	
	public static void main(String []args) {
		CircularArray<Integer> array = new CircularArray<>();
		array.add(1);		
		array.add(2);
		array.add(3);		
		array.add(4);
		array.add(5);
		
		for (Integer i : array) {
			System.out.print(" " + i);
		}
		System.out.println();
		
		array.rotate(10);
		for (Integer i : array) {
			System.out.print(" " + i);
		}
		System.out.println();
		
		array.rotate(-10);
		for (Integer i : array) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
	
}