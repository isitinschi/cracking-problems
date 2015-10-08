class Solution2 {
	
	public static void main(String... args) {
		String s = "abc";
		permutations("", s);		
	}
	
	private static void permutations(String prefix, String s) {
		if (s.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < s.length(); ++i) {
				permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
			}
		}
	}
		
}