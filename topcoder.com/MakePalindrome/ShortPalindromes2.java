public class ShortPalindromes2 {
	
	public String shortest(String base) {
		if (isPalindrome(base)) {
			return base;
		}
		
		char first = base.charAt(0);
		char last = base.charAt(base.length() - 1);
		if (first == last) {
			return "" + first + shortest(base.substring(1, base.length() - 1)) + last;
		} else {
			return min("" + first + shortest(base.substring(1, base.length())) + first,
							"" + last + shortest(base.substring(0, base.length() - 1)) + last);
		}
	}
	
	private boolean isPalindrome(String s) {
		if (s.length() < 2) {
			return true;
		}
		int l = 0;
		int g = s.length() - 1;
		while (l < g) {
			if (s.charAt(l) != s.charAt(g)) {
				return false;
			}
			++l;
			--g;
		}
		return true;
	}
	
	private String min(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return s1;
		} else if (s2.length() < s1.length()) {
			return s2;
		}
		
		if (s1.compareTo(s2) <= 0) {
			return s1;
		} else {
			return s2;
		}
	}
	
	public static void main(String ... args) {
		ShortPalindromes2 shortPalindromes = new ShortPalindromes2();
		String result = shortPalindromes.shortest("MADAMIMADAM");
		if (!"MADAMIMADAM".equals(result)) {
			throw new RuntimeException("Expected MADAMIMADAM, but was " + result);
		}
		result = shortPalindromes.shortest("abcde");
		if (!"abcdedcba".equals(result)) {
			throw new RuntimeException("Expected abcdedcba, but was " + result);
		}
	}
	
}