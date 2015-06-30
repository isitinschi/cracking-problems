import java.util.Scanner;

class Solution {

	public static void main(String... args) {
		Scanner s = new Scanner(System.in);

		System.out.print("number1 = ");
		int number1 = s.nextInt();
		System.out.print("number2 = ");
		int number2 = s.nextInt();

		int xor = number1 ^ number2;
		
		int n = 0;
		for (int i = 0; i < 32; ++i) {
			if (getBit(xor, i)) {
				++n;
			}
		}
		
		System.out.println("Number of bits required to convert: " + n);
	}
	
	private static boolean getBit(int value, int bit) {
		return (value & (1 << bit)) != 0; 
	}

}