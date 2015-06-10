import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		Node head = readList();

		Scanner s = new Scanner(System.in);
		System.out.print("N = ");
		int n = s.nextInt();
		if (n < 0) {
			System.out.println("You didn't provide correct N");
			System.exit(0);
		}

		printNthToLastElement(head, n);
	}

	private static void printNthToLastElement(Node head, int n) {
		if (head != null) {
			Node nNode = head;
			Node curNode = head;

			int i = 0;
			while (curNode.next != null && i < n) {
				++i;
				curNode = curNode.next;
			}

			if (i == n) {
				while (curNode.next != null) {
					curNode = curNode.next;
					nNode = nNode.next;
				}
				System.out.println("Nth element to last is " + nNode.data);
				return;
			}
		}

		System.out.println("List has less than " + (n + 1) + " elements");
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

		public Node() {}
		
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