import java.util.List;
import java.util.ArrayList;

class Solution {
	
	private static final int BOARD_SIZE = 8;
	
	private static class Queen {
		
		public Queen() {}
		
		public Queen(int x, int y) {
			row = x;
			col = y;
		}
		
		int row;
		int col;		
	}
	
	public static void main(String... args) {
		putQueen(0, new ArrayList<Queen>());
	}
	
	public static void putQueen(int row, List<Queen> queens) {
		if (row == BOARD_SIZE) {
			// found solution
			for (Queen q : queens) {
				System.out.print("(" + q.row + ", " + q.col + ") ");
			}
			System.out.println();
		} else if (row < BOARD_SIZE) {
			for (int col = 0; col < BOARD_SIZE; ++col) {
				boolean free = true;
				for (Queen q : queens) {
					if (q.row == row || q.col == col || q.row - row == q.col - col || q.row - row == col - q.col) {
						free = false;
						break;
					}
				}
				if (free) {
					List<Queen> newQueens = new ArrayList<>(queens);
					newQueens.add(new Queen(row, col));				
					putQueen(row + 1, newQueens);
				}
			}
		}
	}
		
}