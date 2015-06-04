import java.util.Set;
import java.util.HashSet;

class Solution1 {
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Should be one input string parameter");
		}
		
		String input = args[0];
		
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < input.length(); ++i) {
			if (!set.add(input.charAt(i))) {
				System.out.println("NOT all characters are unique");
				return;
			}
		}
		
		System.out.println("All characters are unique");
	}
	
}