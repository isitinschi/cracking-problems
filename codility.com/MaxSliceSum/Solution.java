class Solution {
    public int solution(int[] A) {
        if (A == null || A.length < 1) {
            return 0;    
        }
        
        int maxSum = 0;
        int maxSumSoFar = 0;
        int maxValue = A[0];
        for (int i = 0; i < A.length; ++i) {
            maxSumSoFar = Math.max(0, maxSumSoFar + A[i]);
            maxSum = Math.max(maxSum, maxSumSoFar);
            if (A[i] > maxValue) {
                maxValue = A[i];    
            }
        }
        
        return maxSum > 0 ? maxSum : maxValue;
    }
}