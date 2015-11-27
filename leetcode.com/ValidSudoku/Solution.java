public class Solution {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }        

        int size = 9;
        int[][] rows = new int [size][size];
        int[][] cols = new int [size][size];
        int[][] boxes = new int [size][size];        

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++ j) {
                char c = board[i][j];
                if (c != '.') {
                    int val = c - '1';                    

                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (rows[i][val] == 1 || cols[j][val] == 1 || boxes[boxIndex][val] == 1) {
                        return false;
                    }
                    rows[i][val] = cols[j][val] = boxes[boxIndex][val] = 1;
                }
            }
        }        

        return true;
    }

}