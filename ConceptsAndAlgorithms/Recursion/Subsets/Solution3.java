class Solution3 {
	
	public static void main(String... args) {
		findSubsets("", "abc");
	}
	
	private static void findSubsets(String prefix, String s) {
		if (!prefix.isEmpty()) {
			System.out.println(prefix);
		}
		for (int i = 0; i < s.length(); ++i) {
			findSubsets(prefix + s.charAt(i), s.substring(i + 1));
		}
	}
	
}