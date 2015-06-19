import java.util.Scanner;

public class Node {

	private int data;
	private Node left;
	private Node right;
	
	public Node(int data) {
		this.data = data;
	}

	public void appendLeft(Node node) {
		left = node;
	}
	
	public void appendRight(Node node) {
		right = node;
	}
	
	public boolean isBalanced() {
		return maxDepth(0) - minDepth(0) <= 1;
	}
	
	private int maxDepth(int curDepth) {
		if (left == null && right == null) {
			return curDepth;
		} else {
			if (left == null) {
				return right.maxDepth(curDepth + 1);
			} else if (right == null) {
				return left.maxDepth(curDepth + 1);
			} else {
				return Math.max(left.maxDepth(curDepth + 1), right.maxDepth(curDepth + 1));
			}
		}
	}
	
	private int minDepth(int curDepth) {
		if (left == null || right == null) {
			return curDepth;
		} else {
			return Math.min(left.minDepth(curDepth + 1), right.minDepth(curDepth + 1));
		}
	}
	
	public void inOrderPrint() {
		if (left != null) {
			left.inOrderPrint();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.inOrderPrint();
		}
	}

	public static void main(String... args) {
		Node root = readTree();
		root.inOrderPrint();
		System.out.println();
		System.out.println("Tree is" + (!root.isBalanced() ? " Not" : "") + " balanced");
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
			node.left = append(array, start, mid);
			node.right = append(array, mid + 1, end);
			return node;
		} else {
			return null;
		}
	}

}