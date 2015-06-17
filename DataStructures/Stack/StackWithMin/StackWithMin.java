import java.util.Scanner;

public class StackWithMin {
	
	private Node top = null;
	
	public void push(int data) {
		if (top == null) {
			top = new Node(data);
		} else {
			int min = top.min;
			if (data < min) {
				min = data;
			}
			Node node = new Node(data, min);
			node.next = top;
			top = node;			
		}
	}
	
	public Integer pop() {
		if (top == null) {
			return null;
		} else {
			int data = top.data;
			top = top.next;
			return data;
		}
	}
	
	public Integer min() {
		if (top == null) {
			return null;
		} else {
			return top.min;
		}
	}
	
	private class Node {
		int data;
		int min;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.min = data;
		}
		
		public Node(int data, int min) {
			this.data = data;
			this.min = min;
		}
	}
	
	public static void main(String... args) {
		StackWithMin stack = new StackWithMin();
		
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("push or pop?");
			String method = s.next();
			switch(method) {
				case "push": 
					System.out.print("data = ");
					int data = s.nextInt();
					stack.push(data);
					break;
				case "pop":
					System.out.println("data = " + stack.pop());
					break;
				default: continue;
			}			
			System.out.println("min = " + stack.min());
		}
	}
	
}