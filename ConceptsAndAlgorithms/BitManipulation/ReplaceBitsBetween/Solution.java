import java.util.Scanner;
import java.lang.StringBuilder;

class Solution {

	public static void main(String... args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("N = ");
		int N = s.nextInt();
		System.out.print("M = ");
		int M = s.nextInt();
		
		System.out.print("i = ");
		int i = s.nextInt();
		System.out.print("j = ");
		int j = s.nextInt();
		
		if (i < 0 || j < i) {
			throw new IllegalArgumentException();
		}
		
		System.out.println("Before manipulation: ");
		showBits(N, "N: ");
		showBits(M, "M: ");
		
		int max = ~0;
		int left = max << (j + 1);
		int right = (1 << i) - 1;
		int mask = left | right;
		N = N & mask;
		N = N | (M << i);
		
		System.out.println("After manipulation: ");
		showBits(N, "N: ");
		showBits(M, "M: ");
	}

	private static void showBits(int value, String msg) {		
		StringBuilder bits = new StringBuilder();
		int mainPart = value;
		while (mainPart > 0) {
			bits.append(mainPart % 2);
			mainPart /= 2;
		}
		bits.reverse();
		
		System.out.println(msg + bits);
	}

}