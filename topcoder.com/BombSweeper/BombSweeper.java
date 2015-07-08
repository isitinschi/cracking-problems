public class BombSweeper {

	public double winPercentage(String[] board) {
		int bombs = 0;
		int space = 0;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length(); ++j) {
				if (board[i].charAt(j) == 'B') {
					++bombs;
				} else if (isSpace(board, i, j)) {
					++space;
				}
			}
		}
		return 100 * space / (double) (bombs + space);
	}
	
	private boolean isSpace(String[] board, int i, int j) {
		if (!isBomb(board, i - 1, j - 1) &&
				!isBomb(board, i, j - 1) &&
				!isBomb(board, i + 1, j - 1) &&
				!isBomb(board, i - 1, j) &&
				!isBomb(board, i + 1, j) &&
				!isBomb(board, i - 1, j + 1) &&
				!isBomb(board, i, j + 1) &&
				!isBomb(board, i + 1, j + 1)) {
			return true;
		}
		return false;
	}
	
	private boolean isBomb(String[] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[i].length()) {
			return board[i].charAt(j) == 'B';
		}
		return false;
	}
	
	public static void main(String [] args) {
		BombSweeper bombSweeper = new BombSweeper();
		String [] board = new String [] {".....",
				 ".....",
				 "..B..",
				 ".....",
				 "....."};
		System.out.println("Answer: " + bombSweeper.winPercentage(board));
	}
	
}