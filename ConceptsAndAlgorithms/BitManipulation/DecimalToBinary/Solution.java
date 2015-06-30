import java.util.Scanner;
import java.lang.StringBuilder;

class Solution {
	
	private static int LIMIT = 32;

	public static void main(String... args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("f = ");
		float f = s.nextFloat();
		
		showBits(f, "f: ");
	}

	private static void showBits(float value, String msg) {		
		int intPart = (int) value;
		float floatPart = value - intPart;
		
		StringBuilder binary = new StringBuilder();
		binary.append(getBytes(intPart)).append(".").append(getBytes(floatPart));
		
		System.out.println(msg + binary);
	}
	
	private static String getBytes(int value) {
		StringBuffer bits = new StringBuffer();
		int mainPart = value;
		while (mainPart > 0) {
			bits.append(mainPart % 2);
			mainPart /= 2;
		}
		bits.reverse();
		
		return bits.toString();
	}
	
	private static String getBytes(float value) {
		StringBuffer bits = new StringBuffer();
		float mainPart = value;
		int step = 0;
		int intPart = 0;
		do {
			mainPart = mainPart - intPart;
			mainPart *= 2;
			intPart = (int) mainPart;
			bits.append(intPart);
			++step;
		} while (mainPart != 1 && step < LIMIT);
		
		if (step == LIMIT) {
			System.out.println("ERROR");
			System.exit(0);
		}
		
		return bits.toString();
	}

}