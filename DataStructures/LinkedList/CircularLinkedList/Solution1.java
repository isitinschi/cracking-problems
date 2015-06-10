import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		Node head = readList();
		findCircularFirstElement(head);
	}
	
	private static void findCircularFirstElement(Node head) {
		if (head != null) {
			Node node = head;
			Node runner = head;
			do {
				node = node.next;
				if (runner.next == null || runner.next.next == null) {
					System.out.print("No circle in list");
					return;
				}
				runner = runner.next.next;
			} while (!node.equals(runner));
			runner = head;
			int index = -1;
			while (!node.equals(runner)) {
				node = node.next;
				runner = runner.next;
				++index;
			}
			System.out.print("Circled element index is " + index);
			
		} else {
			System.out.print("List is empty");
		}
	}
	
	private static void appendNode(Node head, int data) {
		if (head == null) {
			return;
		} else {
			Node node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node(data);
		}
	}

	private static class Node {
		int data;
		Node next;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}
	}
	
	private static Node readList() {
		int[] array = readArrayFromCommandLine();		
		Node head = new Node();
		for (int i = 0; i < array.length; ++i) {
			appendNode(head, array[i]);
		}
		makeCircle(head, array.length);
		return head;
	}
	
	private static void makeCircle(Node head, int length) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Circled start index = ");
		int start = s.nextInt();
		System.out.print("Circled end index = ");
		int end = s.nextInt();

		if (start < 0 || start >= length || end < 0 || end >= length) {
			System.out.println("You didn't provide correct indices");
			System.exit(0);
		}
		
		Node node = head;
		int i = 0;
		Node startNode = null;
		while (node.next != null) {
			if (i == start) {
				startNode = node.next;
			}
			if (i == end) {
				node.next.next = startNode;
				break;
			}
			node = node.next;
			++i;
		}
	}

	private static int[] readArrayFromCommandLine() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("N = ");
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