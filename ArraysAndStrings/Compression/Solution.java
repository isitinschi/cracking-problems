public class Solution {
	
	private static String compress(String s) {
		if (s == null) {
			return null;
		}
		
		char [] c = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < c.length; ++i) {
			int j = i + 1;
			int count = 1;
			while (j < c.length && c[j] == c[i]) {
				++count;
				++j;
			}
			builder.append(c[i]).append(count);
			i += count - 1;
		}
		
		if (s.length() <= builder.length()) {
			return s;
		} else {
			return builder.toString();
		}
	}
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new RuntimeException();
		}
		
		String s = args[0];
		System.out.println("Compressed: " + compress(s));
	}
}