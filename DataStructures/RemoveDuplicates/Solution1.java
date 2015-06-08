import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		int[] array = readArrayFromCommandLine();
		LinkedList list = new LinkedList();
		for (int i = 0; i < array.length; ++i) {
			list.add(array[i]);
		}
		
		list.removeDuplicates();
		
		list.print();
	}

	private static class LinkedList {
		
		Node head = null;

		public void removeDuplicates() {
			if (head != null) {
				Node node1 = head;
				while (node1 != null) {
					Node node2 = node1;
					while (node2 != null && node2.next != null) {
						if (node1.data == node2.next.data) {
							node2.next = node2.next.next;
						} else {
							node2 = node2.next;
						}
					}
					node1 = node1.next;
				}
			}
		}

		public void add(int data) {
			if (head == null) {
				head = new Node(data);
			} else {
				Node node = head;
				while (node.next != null) {
					node = node.next;
				}
				node.next = new Node(data);
			}
		}
		
		public void print() {
			if (head != null) {
				Node node = head;
				while (node != null) {
					System.out.print(" " + node.data);
					node = node.next;
				}
			} else {
				System.out.println("List is empty");
			}
		}

		class Node {
			int data;
			Node next;

			public Node(int data) {
				this.data = data;
			}
		}
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