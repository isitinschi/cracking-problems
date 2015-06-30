import java.util.Scanner;

class Solution {

	public static void main(String... args) {
		Scanner s = new Scanner(System.in);

		System.out.print("number = ");
		int number = s.nextInt();

		nextSmallest(number);
		nextLargest(number);
	}

	private static void nextSmallest(int value) {
		if (value == 0) {
			System.out.println("No next smallest");
		} else {
			int next = value;
			boolean found = false;
			int threshold = 0;
			for (int i = 0; i < 32; ++i) {
				if (!found && !getBit(value, i)) {
					// i bit is 0
					found = true;
				} else if (found && getBit(value, i)) {
					next = setBit(next, i, false);
					next = setBit(next, i - 1, true);
					threshold = i;
					break;
				}
			}
			// shift 1 bits
			int i = 0;
			int j = 0;
			found = false;
			while (i < threshold) {
				if (!found && getBit(next, i)) {
					j = i;
					found = true;
					++i;
				} else if (found && !getBit(next, i)) {
					next = setBit(next, j, false);
					next = setBit(next, i, true);
					i = 0;
					found = false;
				} else {
					++i;
				}
			}

			System.out.println("Next smallest for " + value + "("
					+ getBits(value) + ") is " + next + "(" + getBits(next)
					+ ")");
		}
	}

	private static void nextLargest(int value) {
		if (value == 0) {
			System.out.println("No next largest");
		} else {
			int next = value;
			boolean found = false;
			int threshold = 0;
			for (int i = 0; i < 32; ++i) {
				if (!found && getBit(value, i)) {
					// i bit is 1
					found = true;
				} else if (found && !getBit(value, i)) {
					next = setBit(next, i, true);
					next = setBit(next, i - 1, false);
					threshold = i;
					break;
				}
			}
			// shift 1 bits
			int i = threshold - 1;
			int j = 0;
			found = false;
			while (i >= 0) {
				if (!found && getBit(next, i)) {
					j = i;
					found = true;
					--i;
				} else if (found && !getBit(next, i)) {
					next = setBit(next, j, false);
					next = setBit(next, i, true);
					i = threshold - 1;
					found = false;
				} else {
					--i;
				}
			}

			System.out.println("Next largest for " + value + "("
					+ getBits(value) + ") is " + next + "(" + getBits(next)
					+ ")");
		}
	}
	
	private static boolean getBit(int value, int bit) {
		return (((1 << bit) & value) != 0);
	}
	
	private static int setBit(int value, int bit, boolean b) {
		if (b) {
			return value | (1 << bit);
		} else {
			int mask = ~(1 << bit);
			return value & mask;
		}
	}

	private static String getBits(int value) {
		StringBuilder bits = new StringBuilder();
		int mainPart = value;
		while (mainPart > 0) {
			bits.append(mainPart % 2);
			mainPart /= 2;
		}
		bits.reverse();

		return bits.toString();
	}

}