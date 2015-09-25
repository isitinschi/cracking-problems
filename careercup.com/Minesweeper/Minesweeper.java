import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
	
	private static final int BOMB = 10;
	private static final int CLOSED = -1;	
	
	private int [][] board;
	private int [][] hiddenBoard;
	
	private int size = 0;
	private int nBombs = 0;
	private int opened = 0;
	
	public Minesweeper(int size, int nBombs) {
		this.nBombs = nBombs;
		this.size = size;
		board = new int[size][size];
		hiddenBoard = new int[size][size];
		
		for (int i = 0 ;i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				board[i][j] = CLOSED;
			}
		}
		
		Random random = new Random();
		int bombs = 0;
		while (bombs < nBombs) {
			int i = random.nextInt(size);
			int j = random.nextInt(size);
			if (hiddenBoard[i][j] != BOMB) {
				hiddenBoard[i][j] = BOMB;
				++bombs;
			}
		}
		
		for (int i = 0 ;i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (hiddenBoard[i][j] != BOMB) {
					int count = 0;
					count += isBomb(hiddenBoard, i - 1, j - 1);
					count += isBomb(hiddenBoard, i - 1, j);
					count += isBomb(hiddenBoard, i - 1, j + 1);
					count += isBomb(hiddenBoard, i, j - 1);
					count += isBomb(hiddenBoard, i, j + 1);
					count += isBomb(hiddenBoard, i + 1, j - 1);
					count += isBomb(hiddenBoard, i + 1, j);
					count += isBomb(hiddenBoard, i + 1, j + 1);
					hiddenBoard[i][j] = count;
				}
			}
		}
	}
	
	private int isBomb(int [][] array, int i, int j) {
		if (i >= 0 && j >= 0 && i < size && j < size) {
			if (array[i][j] == BOMB) {
				return 1;
			}
		}
		return 0;
	}
	
	public int[][] getBoard() {
		return board.clone();
	}
	
	public void open(int i, int j) {
		if (i < 0 || i >= size || j < 0 || j >= size) {
			System.out.println("Wrong input!");
			return;
		}
		if (hiddenBoard[i][j] == BOMB) {
			System.out.println("BOOM!");
			System.exit(0);
		}
		board[i][j] = hiddenBoard[i][j];
		++opened;
		if (size*size - nBombs == opened) {
			System.out.println("You win!");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		int size = 3;
		Minesweeper minesweeper = new Minesweeper(size, 3);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int [][] board = minesweeper.getBoard();
			for (int i = 0; i < size; ++i) {
				for (int j = 0; j < size; ++j) {
					if (board[i][j] == BOMB) {
						System.out.print("B");
					} else if (board[i][j] == CLOSED) {
						System.out.print("C");
					} else {
						System.out.print(board[i][j]);
					}
				}
				System.out.println();
			}
			System.out.println("Cell to open: ");
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			minesweeper.open(i, j);
		}
	}
	
}