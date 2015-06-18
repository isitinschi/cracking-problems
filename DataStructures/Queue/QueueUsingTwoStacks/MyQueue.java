import java.util.Stack;
import java.util.Scanner;

public class MyQueue<T> {
	
	private Stack<T> inputStack = new Stack<T>();
	private Stack<T> outputStack = new Stack<T>();
	
	public void enqueue(T data) {
		inputStack.push(data);
	}
	
	public T dequeue() {
		if (outputStack.isEmpty()) {
			if (inputStack.isEmpty()) {
				return null;
			}
			while (!inputStack.isEmpty()) {
				outputStack.push(inputStack.pop());
			}
		}
		
		return outputStack.pop();
	}
	
	public static void main(String ...args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("enqueue(e) or dequeue(d)?");
			String method = s.next();
			switch(method) {
				case "e": 
					System.out.print("data = ");
					int data = s.nextInt();
					queue.enqueue(data);
					break;
				case "d":
					System.out.println("data = " + queue.dequeue());
					break;
				default: continue;
			}
		}
	}
}