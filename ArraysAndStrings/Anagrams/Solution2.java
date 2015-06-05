import java.util.Arrays;

class Solution2 {
	
	public static void main(String... args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("Should be two input string parameters");
		}
		
		String input1 = args[0];
		String input2 = args[1];
		
		int counter[] = new int[256];
		if (input1.length() != input2.length()) {
			System.out.println(false);
		} else {
			int n = input1.length();
			for (int i = 0; i < n; ++i) {
				++counter[input1.charAt(i)];
				--counter[input2.charAt(i)];
			}
			
			System.out.println(Arrays.equals(counter, new int[256]));
		}
	}
	
}