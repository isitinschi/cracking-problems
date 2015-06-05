import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		int[][] matrix = readMatrixFromCommandLine();
		
		int N = matrix.length;
		
		if (N > 1) {
			for (int layer = 0; layer < N; ++layer, --N) {
				for (int i = layer; i < N - 1; ++i) {
					// #1
					int sourceRow = layer;
					int sourceCol = i;
					int destRow = sourceCol;
					int destCol = matrix.length - sourceRow - 1;
					int temp1 = matrix[destRow][destCol];
					matrix[destRow][destCol] = matrix[sourceRow][sourceCol];
					
					// #2
					sourceRow = destRow;
					sourceCol = destCol;
					destRow = sourceCol;
					destCol = matrix.length - sourceRow - 1;
					int temp2 = matrix[destRow][destCol];
					matrix[destRow][destCol] = temp1;
					
					// #3
					sourceRow = destRow;
					sourceCol = destCol;
					destRow = sourceCol;
					destCol = matrix.length - sourceRow - 1;
					temp1 = matrix[destRow][destCol];
					matrix[destRow][destCol] = temp2;
					
					// #4
					sourceRow = destRow;
					sourceCol = destCol;
					destRow = sourceCol;
					destCol = matrix.length - sourceRow - 1;
					temp2 = matrix[destRow][destCol];
					matrix[destRow][destCol] = temp1;
				}
			}
		}
		
		showMatrix(matrix);
	}

	private static int[][] readMatrixFromCommandLine() {

		Scanner s = new Scanner(System.in);

		System.out.print("N = ");
		int N = s.nextInt();
		
		if (N < 1) {
			System.out.println("You didn't provide correct matrix size");
			System.exit(0);
		}
		
		s.nextLine(); // throw away the newline.

		int[][] numbers = new int[N][N];
		System.out.print("Matrix: ");
		Scanner numScanner = new Scanner(s.nextLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (numScanner.hasNextInt()) {
					numbers[i][j] = numScanner.nextInt();
				} else {
					System.out.println("You didn't provide enough numbers");
					System.exit(0);
				}
			}
		}

		return numbers;
	}
	
	private static void showMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {				
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}

}