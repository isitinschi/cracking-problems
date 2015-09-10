public class Solution {
	
	public static void main(String ...args) {
		int n = 3;
		System.out.println("Possible ways for " + n + " stairs: " + countWays(n));
	}
	
	private static int countWays(int n) {
		if (n <= 0) {
			return 0;
		} else {
			return countWays(0, n);
		}
	}
	
	private static int countWays(int sum, int n) {
		if (sum < n) {
			int count = 0;
			count += countWays(sum + 1, n);
			count += countWays(sum + 2, n);
			count += countWays(sum + 3, n);
			return count;
		} else if (sum == n) {
			return 1;
		} else {
			return 0;
		}
	}
}