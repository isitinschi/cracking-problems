import java.util.Stack;
import java.util.Scanner;
import java.lang.Number;

public class SortableStack extends Stack<Integer> {
	
	public void sort() {
		Stack<Integer> buffer = new Stack<Integer>();
		
		while(!isEmpty()) {
			Integer data = pop();
			while (!buffer.isEmpty() && buffer.peek() > data) {
				push(buffer.pop());
			}
			buffer.push(data);
		}
		
		while (!buffer.isEmpty()) {
			push(buffer.pop());
		}
	}
	
	public static void main(String... args) {
		SortableStack stack = new SortableStack();
		
		int[] array = readArrayFromCommandLine();
		for (int i = 0; i < array.length; ++i) {
			stack.push(array[i]);
		}
		
		stack.sort();
		
		System.out.println("Sorted stack:");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	private static int[] readArrayFromCommandLine() {
		Scanner s = new Scanner(System.in);

		System.out.print("Size = ");
		int N = s.nextInt();

		if (N < 1) {
			System.out.println("You didn't provide correct list size");
			System.exit(0);
		}

		s.nextLine(); // throw away the newline.

		int[] numbers = new int[N];
		System.out.print("Array: ");
		Scanner numScanner = new Scanner(s.nextLine());
		for (int i = 0; i < N; i++) {
			if (numScanner.hasNextInt()) {
				numbers[i] = numScanner.nextInt();
			} else {
				System.out.println("You didn't provide enough numbers");
				System.exit(0);
			}
		}

		return numbers;
	}
}