import java.util.Set;
import java.util.HashSet;

class Solution2 {
	
	public static void main(String... args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("Should be two input string parameters");
		}
		
		String input1 = args[0];
		String input2 = args[1];
		
		if (input1.length() != input2.length()) {
			System.out.println(false);
		} else {
			int n = input1.length();
			for (int i = 0, j = n - 1; i < n && j >= 0; ++i, --j) {
				if (input1.charAt(i) != input2.charAt(j)) {
					System.out.println(false);
					return;
				}
			}
			System.out.println(true);
		}
	}
	
}