import java.util.Scanner;

class Solution {

	public static void main(String... args) {
		Scanner s = new Scanner(System.in);

		System.out.print("number = ");
		int number = s.nextInt();
		
		System.out.println("Number before: " + getBits(number));

		number = ((number & 0xaaaaaaaa) >> 1) | ((number & 0x55555555) << 1);
		
		System.out.println("Number after: " + getBits(number));
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