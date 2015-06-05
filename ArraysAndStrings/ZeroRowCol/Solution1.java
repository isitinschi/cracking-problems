import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		int[][] matrix = readMatrixFromCommandLine();
		int M = matrix.length;
		int N = matrix[0].length;
		
		if (M > 1 && N > 1) {		
			int [] rows = new int[M];
			int [] cols = new int[N];
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == 0 && rows[i] != 1 && cols[j] != 1) {
						rows[i] = 1;
						cols[j] = 1;
					}
				}
			}
			
			for (int i = 0; i < M; ++i) {
				if (rows[i] == 1) {
					zeroRow(matrix, i);
				}
			}
			for (int i = 0; i < N; ++i) {
				if (cols[i] == 1) {
					zeroCol(matrix, i);
				}
			}
		}
		
		showMatrix(matrix);
	}
	
	private static void zeroRow(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; ++i) {
			matrix[row][i] = 0;
		}
	}
	
	private static void zeroCol(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; ++i) {
			matrix[i][col] = 0;
		}
	}

	private static int[][] readMatrixFromCommandLine() {

		Scanner s = new Scanner(System.in);

		System.out.print("M = ");
		int M = s.nextInt();
		System.out.print("N = ");
		int N = s.nextInt();
		
		if (M < 1 && N < 1) {
			System.out.println("You didn't provide correct matrix size");
			System.exit(0);
		}
		
		s.nextLine(); // throw away the newline.

		int[][] numbers = new int[M][N];
		System.out.print("Matrix: ");
		Scanner numScanner = new Scanner(s.nextLine());
		for (int i = 0; i < M; i++) {
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
			for (int j = 0; j < matrix[0].length; j++) {				
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}

}