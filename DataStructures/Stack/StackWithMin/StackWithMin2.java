import java.util.Scanner;

public class StackWithMin2 {
	
	private Node top = null;
	private Node mins;
	
	public void push(int data) {
		if (top == null) {
			top = new Node(data);
			mins = new Node(data);
		} else {
			int min = mins.data;
			if (data <= min) {
				Node node = new Node(data);
				node.next = mins;
				mins = node;	
			}
			Node node = new Node(data);
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
			if (data == mins.data) {
				mins = mins.next;
			}
			return data;
		}
	}
	
	public Integer min() {
		if (mins == null) {
			return null;
		} else {
			return mins.data;
		}
	}
	
	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String... args) {
		StackWithMin2 stack = new StackWithMin2();
		
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