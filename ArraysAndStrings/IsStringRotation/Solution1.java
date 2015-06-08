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
			return;
		} else if (input1.equals(input2)) {
			System.out.println(true);
			return;
		} else {
			for (int i = 1; i < input1.length(); ++i) {
				StringBuilder builder = new StringBuilder(input1.substring(i));
				builder.append(input1.substring(0, i));
				if (builder.toString().equals(input2)) {
					System.out.println(true);
					return;
				}
			}
		}
		
		System.out.println(false);
	}
	
}