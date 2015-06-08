import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		int[] array = readArrayFromCommandLine();
		LinkedList list = new LinkedList();
		for (int i = 0; i < array.length; ++i) {
			list.add(array[i]);
		}
		
		Scanner s = new Scanner(System.in);
		System.out.print("N = ");
		int n = s.nextInt();
		if (n < 0) {
			System.out.println("You didn't provide correct N");
			System.exit(0);
		}
		
		list.printNthToLastElement(n);
	}

	private static class LinkedList {
		
		Node head = null;

		public void printNthToLastElement(int n) {
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

		System.out.print("Size = ");
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