import java.util.Arrays;

class Solution1 {
	
	public static void main(String... args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("Should be two input string parameters");
		}
		
		String input1 = args[0];
		String input2 = args[1];
		
		if (input1.length() != input2.length()) {
			System.out.println(false);
		} else {
			char [] chars1 = new char[input1.length()];
			char [] chars2 = new char[input2.length()];
			input1.getChars(0, input1.length(), chars1, 0);
			input1.getChars(0, input2.length(), chars2, 0);
			Arrays.sort(chars1);
			Arrays.sort(chars2);
			System.out.println(Arrays.equals(chars1, chars2));
		}
	}
	
}