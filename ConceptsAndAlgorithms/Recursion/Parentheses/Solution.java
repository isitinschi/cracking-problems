class Solution {
	
	public static void main(String... args) {
		int n = 3;
		parentheses(n, 0, 0, "");
	}
	
	private static void parentheses(int n, int opened, int closed, String print) {
		if (opened == closed && opened == n) {
			System.out.println(print);
		} else {
			if (opened < n) {
				parentheses(n, opened + 1, closed, print + "(");
			}
			if (closed < opened) {
				parentheses(n, opened, closed + 1, print + ")");
			}
		}
	}
		
}