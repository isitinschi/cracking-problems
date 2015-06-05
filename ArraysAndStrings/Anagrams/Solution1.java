import java.util.Set;
import java.util.HashSet;

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
			input2 = new StringBuilder(input2).reverse().toString();
			if (input1.equals(input2)) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}
	}
	
}