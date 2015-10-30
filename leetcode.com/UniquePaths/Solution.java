public class Solution {

    public int uniquePaths(int m, int n) {
        int [][] cache = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cache[i][j] = -1;
            }
        }        

        return go(0, 0, m - 1, n - 1, cache);
    }    

    private int go(int x, int y, int finishX, int finishY, int [][] cache) {
        if (x == finishX && y == finishY) {
            return 1;
        } else if (x <= finishX && y <= finishY) {
            if (cache[x][y] != -1) {
                return cache[x][y];
            }

            int sum = 0;
            sum += go(x + 1, y, finishX, finishY, cache); // right
            sum += go(x, y + 1, finishX, finishY, cache); // down
            
            cache[x][y] = sum;            

            return sum;
        }        

        return 0;
    }

}