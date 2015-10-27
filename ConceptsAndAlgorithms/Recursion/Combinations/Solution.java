public class Solution {
	
	public void printCombinations(String s, int n) {
		if (s == null || s.isEmpty()) {
			return;
		}
		printCombinations("", s, n);
	}
	
	private void printCombinations(String prefix, String s, int n) {
		if (prefix.length() == n) {
			System.out.println(prefix);
		} else if (prefix.length() < n) {
			for (int i = 0; i < s.length(); ++i) {
				printCombinations(prefix + s.charAt(i), s, n);
			}
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.printCombinations("1234", 3);
	}
	
}