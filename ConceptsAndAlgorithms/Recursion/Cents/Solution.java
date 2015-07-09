class Solution {
	
	private enum Coin {
		C_25(25), C_10(10), C_5(5), C_1(1), C_0(0);
		
		Coin(int value) {
			this.value = value;
		}
		
		private int value;
		
		int getValue() {
			return value;
		}
	}
	
	public static void main(String... args) {
		int n = 25;
		int count = findCoins(0, n, new StringBuilder(), Coin.C_0);
		System.out.println("Count: " + count);
	}
	
	private static int findCoins(int sum, int n, StringBuilder print, Coin add) {
		sum += add.getValue();
		if (sum == n) {
			System.out.println(print);
			return 1;
		} else if (sum < n) {
			int count = 0;
			switch (add) {
				default:
				case C_1:
					count += findCoins(sum, n, new StringBuilder(print).append(Coin.C_1.getValue() + " "), Coin.C_1);
				case C_5:
					count += findCoins(sum, n, new StringBuilder(print).append(Coin.C_5.getValue() + " "), Coin.C_5);
				case C_10:
					count += findCoins(sum, n, new StringBuilder(print).append(Coin.C_10.getValue() + " "), Coin.C_10);
				case C_25:
					count += findCoins(sum, n, new StringBuilder(print).append(Coin.C_25.getValue() + " "), Coin.C_25);
			}			
			return count;
		}
		return 0;
	}
		
}