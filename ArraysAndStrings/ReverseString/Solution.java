public class Solution {
	
	private static String reverse(String s) {
		if (s == null) {
			return null;
		}
		
		char [] c = s.toCharArray();
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			swap(c, i++, j--);
		}
		
		return new String(c);
	}
	
	private static void swap(char [] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	public static void main(String... args) {
		if (args.length != 1) {
			throw new RuntimeException();
		}
		
		String s = args[0];
		System.out.println("Reverse: " + reverse(s));
	}
}