import java.util.Arrays;

class Solution2 {
	
	public static void main(String... args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("Should be two input string parameters");
		}
		
		String input1 = args[0];
		String input2 = args[1];
		
		if (input1.length() != input2.length()) {
			System.out.println(false);
		} else if (input1.equals(input2)) {
			System.out.println(true);
		} else if ((input2 + input2).contains(input1)) {
			System.out.println(true);		
		} else {
			System.out.println(false);
		}
	}
	
}