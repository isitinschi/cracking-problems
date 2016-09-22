class Solution {
    public int solution(int[] A) {
        if (A == null || A.length < 2) {
            return 0;    
        }
        
        int minSoFar = -1;
        int maxProfit = 0;
        for (int i = 0; i < A.length; ++i) {
            if (minSoFar != -1) {
                maxProfit = Math.max(maxProfit, A[i] - A[minSoFar]);
            }
            if (minSoFar == -1 || A[i] < A[minSoFar]) {
                minSoFar = i;    
            }
        }
        
        return maxProfit;
    }
}