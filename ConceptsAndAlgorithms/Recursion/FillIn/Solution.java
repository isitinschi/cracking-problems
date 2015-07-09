class Solution {
	
	public static void main(String... args) {
		int [][] image = new int [][] {{1,2,3,4},
										{1,2,2,2},
										{1,2,3,2}};
		int color = 7;						
		fillIn(image, 1, 1, color);
		
		for (int i = 0; i < image.length; ++i) {
			for (int j = 0; j < image[0].length; ++j) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void fillIn(int [][] image, int x, int y, int color) {
		int sourceColor = image[x][y];
		if (sourceColor == color) {
			return;
		}
		fillIn(image, x, y, sourceColor, color);
	}
	
	private static void fillIn(int [][] image, int x, int y, int sourceColor, int destColor) {
		if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
			return;
		}
		if (image[x][y] == sourceColor) {
			image[x][y] = destColor;
			fillIn(image, x, y - 1, sourceColor, destColor);
			fillIn(image, x, y + 1, sourceColor, destColor);
			fillIn(image, x - 1, y, sourceColor, destColor);
			fillIn(image, x + 1, y, sourceColor, destColor);
		}
	}
		
}