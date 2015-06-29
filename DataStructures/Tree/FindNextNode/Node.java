import java.util.Scanner;

public class Node {

	private int data;
	private Node left;
	private Node right;
	private Node parent;
	
	public Node(int data) {
		this.data = data;
	}

	public void appendLeft(Node node) {
		left = node;
		node.parent = this;
	}
	
	public void appendRight(Node node) {
		right = node;
		node.parent = this;
	}
	
	public void inOrderPrintWithNext() {
		if (left != null) {
			left.inOrderPrintWithNext();
		}
		System.out.print(data + " (next = ");
		printNextNode();
		System.out.print(") ");
		if (right != null) {
			right.inOrderPrintWithNext();
		}
	}
	
	private void printNextNode() {
		if (right != null) {
			System.out.print(right.printNext());
		} else {		
			Node up = this;
			while (up.parent != null && up == up.parent.right) {
				up = up.parent;
			}
			up = up.parent;
			if (up != null) {
				System.out.print(up.data);
			} else {
				System.out.print("null");
			}
		}	
	}
	
	private int printNext() {
		if (left != null) {
			return left.printNext();
		}
		return data;
	}

	public static void main(String... args) {
		Node root = readTree();
		root.inOrderPrintWithNext();
	}
	
	public static Node readTree() {
		int[] array = readArrayFromCommandLine();
		if (!isSorted(array)) {
			throw new IllegalArgumentException();
		}
		
		Node root = append(array, 0, array.length);
		
		return root;
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
	
	private static boolean isSorted(int [] array) {
		for (int i = 0; i < array.length - 1; ++i) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static Node append(int [] array, int start, int end) {
		if (end - start > 0) {
			int mid = (start + end) / 2;
			Node node = new Node(array[mid]);
			Node left = append(array, start, mid);
			if (left != null) {
				node.appendLeft(left);
			}
			Node right = append(array, mid + 1, end);
			if (right != null) {
				node.appendRight(right);
			}
			return node;
		} else {
			return null;
		}
	}

}