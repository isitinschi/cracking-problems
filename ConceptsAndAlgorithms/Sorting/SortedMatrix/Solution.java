class Solution {
	
	public static void main(String... args) {
		int [][] array = new int [][] {{1, 5, 9},
										{2, 6, 10},
										{3, 7, 11},
										{4, 8, 12}};
		int toFind = 8;
		
		System.out.println("Index: " + findIndex(array, toFind));
	}
	
	public static String findIndex(int [][] array, int v) {
		int row = 0;
		int col = array[0].length - 1;
		while (row < array.length && col >= 0) {
			if (array[row][col] == v) {
				return "[" + row + ", " + col + "]";
			} else if (v > array[row][col]) {
				++row;
			} else {
				--col;
			}
		}
		
		return "[-1, -1]";
	}
		
}