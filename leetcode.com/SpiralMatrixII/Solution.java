public class Solution {

    public int[][] generateMatrix(int n) {
        int [][] array = new int[n][n];
        if (n < 1) {
            return array;
        }       

        int start = 0;
        int end = n;        

        int index = 1;
        while (start < end) {
            // right
            for (int col = start; col < end; ++col) {
                array[start][col] = index++;
            }            

            // down
            for (int row = start + 1; row < end; ++row) {
                array[row][end - 1] = index++;
            }            

            // left
            for (int col = end - 2; col >= start; --col) {
                array[end - 1][col] = index++;
            }            

            // up
            for (int row = end - 2; row > start; --row) {
                array[row][start] = index++;
            }            

            ++start;
            --end;
        }        

        return array;
    }

}