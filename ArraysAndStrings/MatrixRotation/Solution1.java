import java.util.Scanner;

class Solution1 {

	public static void main(String... args) {
		int[][] matrix = readMatrixFromCommandLine();
		
		int N = matrix.length;
		
		if (N > 1) {
			for (int layer = 0; layer < N / 2; ++layer) {
				int first = layer;
				int last = N - layer - 1;
				for (int i = layer; i < last; ++i) {
					int top = matrix[first][i];
					matrix[first][i] = matrix[N - i - 1][first];
					matrix[N - i - 1][first] = matrix[last][N - i - 1];
					matrix[last][N - i - 1] = matrix[i][last];
					matrix[i][last] = top;					
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