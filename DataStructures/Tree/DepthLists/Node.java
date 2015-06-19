import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

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
	
	public List<List<Node>> depthLists() {
		List<List<Node>> depthLists = new LinkedList<List<Node>>();
		fillDepthList(depthLists, 0);
		return depthLists;
	}
	
	private void fillDepthList(List<List<Node>> depthLists, int depth) {
		if (depthLists.size() - 1 < depth) {
			depthLists.add(new LinkedList<Node>());
		}
		depthLists.get(depth).add(this);
		if (left != null) {
			left.fillDepthList(depthLists, depth + 1);
		}
		if (right != null) {
			right.fillDepthList(depthLists, depth + 1);
		}
	}

	public static void main(String... args) {
		Node root = readTree();
		List<List<Node>> depthLists = root.depthLists();
		
		System.out.println("Depth lists:");
		for (List<Node> list : depthLists) {
			System.out.println();
			for (Node node : list) {
				System.out.print(node.data + " ");
			}
		}
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