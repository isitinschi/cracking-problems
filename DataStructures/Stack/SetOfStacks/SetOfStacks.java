import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SetOfStacks {

	private static final int THRESHOLD = 3;

	private List<List<Integer>> stacks;

	public SetOfStacks() {
		stacks = new ArrayList<List<Integer>>();
	}

	public void push(int data) {
		List<Integer> stack = null;
		if (stacks.isEmpty()
				|| stacks.get(stacks.size() - 1).size() >= THRESHOLD) {
			stack = new ArrayList<Integer>();
			stack.add(data);
			stacks.add(stack);
		} else {
			stack = stacks.get(stacks.size() - 1);
			stack.add(data);
		}
	}

	public Integer pop() {
		int data = popAt(stacks.size() - 1);
		return data;
	}

	public Integer popAt(int i) {
		if (stacks.isEmpty() || i < 0 || i >= stacks.size()) {
			throw new IllegalArgumentException();
		}
		List<Integer> stack = stacks.get(i);
		int lastIndex = stack.size() - 1;
		int data = stack.get(lastIndex);
		stack.remove(lastIndex);
		if (stack.isEmpty()) {
			stacks.remove(stack);
		}
		return data;
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
		SetOfStacks stack = new SetOfStacks();
		
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("push, pop or popAt?");
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
				case "popAt":
					System.out.print("i = ");
					int i = s.nextInt();
					System.out.println("data = " + stack.popAt(i));
					break;
				default: continue;
			}
		}
	}
}