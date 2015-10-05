public class Solution {

    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }        

        int [] stairs = new int[n + 1];
        stairs[0] = 1;
        stairs[1] = 1;        

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= 2; ++j) {
                stairs[i] += stairs[i - j];
            }
        }        

        return stairs[n];
    }    

}