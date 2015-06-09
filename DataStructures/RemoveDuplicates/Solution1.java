import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		Node head = readList();

		removeDuplicates(head);

		print(head);
	}

	public static void removeDuplicates(Node head) {
		if (head != null) {
			Node node1 = head;
			while (node1.next != null) {
				node1 = node1.next;
				Node node2 = node1;
				while (node2 != null && node2.next != null) {
					if (node1.data == node2.next.data) {
						node2.next = node2.next.next;
					} else {
						node2 = node2.next;
					}
				}
			}
		}
	}
	
	public static void appendNode(Node head, int data) {
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

	public static void print(Node head) {
		if (head != null) {
			Node node = head;
			while (node.next != null) {
				System.out.print(" " + node.next.data);
				node = node.next;
			}
		} else {
			System.out.println("List is empty");
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
		return head;
	}

	private static int[] readArrayFromCommandLine() {

		Scanner s = new Scanner(System.in);

		System.out.print("N = ");
		int N = s.nextInt();

		if (N < 1) {
			System.out.println("You didn't provide correct array size");
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