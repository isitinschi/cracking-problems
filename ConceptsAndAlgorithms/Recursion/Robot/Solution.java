import java.util.Random;
import java.util.Scanner;

class Solution {
	
	public static void main(String... args) {
		Scanner s = new Scanner(System.in);

		System.out.print("n = ");
		int n = s.nextInt();
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		
		boolean [][] array = generateArray(n);
		printArray(array, n);
		
		System.out.println("Calculated total paths:" + countPaths(array, n));
	}
	
	private static boolean [][] generateArray(int n) {
		boolean [][] array = new boolean [n][n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int p = r.nextInt(100);
				if (p < 15) { // 15% that we cannot step on this cell
					array[i][j] = false;
				} else {
					array[i][j] = true;
				}
			}
		}		
		return array;
	}
	
	private static void printArray(boolean [][] array, int n) {
		System.out.println("Generated array:");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(array[i][j] ? "1 " : "0 ");
			}
			System.out.println();
		}
	}
	
	private static int countPaths(boolean [][] array, int n) {
		return go(1, 0, array, n) + go(0, 1, array, n);
	}
	
	private static int go(int x, int y, boolean [][] array, int n) {
		if (x == n - 1 && y == n - 1) {
			return 1;
		} else if (x < n && x >= 0 && y < n && y>= 0 && array[x][y]) {
			return go(x + 1, y, array, n) + go(x, y + 1, array, n);
		}
		
		return 0;
	}
	
}