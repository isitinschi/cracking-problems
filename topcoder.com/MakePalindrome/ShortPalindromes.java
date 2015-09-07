public class ShortPalindromes {
	
	public String shortest(String base) {
		if (isPalindrome(base)) {
			return base;
		}
		
		int n = base.length();
		for (int count = 1; count < n; ++count) {
			for (int pos = n; pos > n / 2; --pos) {			
				StringBuilder builder = new StringBuilder(base);
				for (int i = n - pos; i < Math.min(n - pos + count, base.length()); ++i) {
					builder.insert(pos, base.charAt(i));
				}
				if (isPalindrome(builder.toString())) {
					return builder.toString();
				}
			}
		}
		
		return null;
	}
	
	private boolean isPalindrome(String s) {
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
	
	public static void main(String ... args) {
		ShortPalindromes shortPalindromes = new ShortPalindromes();
		String result = shortPalindromes.shortest("neverodd");
		if (!"neveroddoreven".equals(result)) {
			throw new RuntimeException("Expected neveroddoreven, but was " + result);
		}
		result = shortPalindromes.shortest("MADAMIMADAM");
		if (!"MADAMIMADAM".equals(result)) {
			throw new RuntimeException("Expected MADAMIMADAM, but was " + result);
		}
		result = shortPalindromes.shortest("abcde");
		if (!"abcdedcba".equals(result)) {
			throw new RuntimeException("Expected abcdedcba, but was " + result);
		}
	}
	
}