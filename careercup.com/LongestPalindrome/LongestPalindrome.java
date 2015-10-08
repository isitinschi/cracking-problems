public class LongestPalindrome {
	
	public String find(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		
		int maxLength = 0;
		int start = 0;
		for (int center = 0; center < s.length() - 1; ++center) {
			int length = Math.max(findPalindromeLength(s, center), findPalindromeLength(s, center, center + 1));			
			if (length > maxLength) {
				maxLength = length;
				start = center - maxLength / 2;
				if (maxLength % 2 == 0) {
					start += 1;
				}
			}
		}
		
		return s.substring(start, start + maxLength);
	}
	
	private int findPalindromeLength(String s, int center) {
		int length = 1;
		return length + findPalindromeLength(s, center - 1, center + 1);
	}
	
	private int findPalindromeLength(String s, int i1, int i2) {
		int length = 0;
		while (i1 >= 0 && i2 < s.length() && s.charAt(i1) == s.charAt(i2)) {
			length += 2;
			--i1;
			++i2;
		}
		return length;
	}

	public static void main(String [] args) {
		LongestPalindrome lp = new LongestPalindrome();
		String s = "habrahabr";
		System.out.println("Longest palindrome for " + s + " is " + lp.find(s));
	}
}