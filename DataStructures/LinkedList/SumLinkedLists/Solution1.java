import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		Node head1 = readList();
		Node head2 = readList();

		Node sumHead = sum(head1, head2);

		print(sumHead);
	}

	private static Node sum(Node head1, Node head2) {
		if (head1 != null && head2 != null) {
			Node node1 = head1;
			Node node2 = head2;
			Node sumHead = new Node();
			Node sumNode = sumHead;
			int rest = 0;
			while (node1.next != null || node2.next != null) {
				int sum = rest;
				if (node1.next != null) {
					node1 = node1.next;
					sum += node1.data;
				}
				if (node2.next != null) {
					node2 = node2.next;
					sum += node2.data;
				}
				if (sum > 9) {
					rest = sum / 10;
					sum = sum  % 10;
				} else {
					rest = 0;
				}
				sumNode.next = new Node(sum);
				sumNode = sumNode.next;
			}
			if (rest > 0) {
				sumNode.next = new Node(rest);
			}
			
			return sumHead;
		}
		
		return null;
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

	private static void print(Node head) {
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