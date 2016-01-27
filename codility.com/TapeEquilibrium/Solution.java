class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;    
        }
        
        if (A.length == 1) {
            return A[0];    
        }
        
        if (A.length == 2) {
            return Math.min(Math.abs(A[0] + A[1]), Math.abs(A[1] - A[0]));    
        }
        
        int [] aF = new int [A.length];
        int [] aB = new int [A.length];
        
        aF[0] = A[0];
        for (int i = 1; i < A.length; ++i) {
            aF[i] = aF[i - 1] + A[i];    
        }
        
        aB[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; --i) {
            aB[i] = aB[i + 1] + A[i];    
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int p = 1; p < A.length - 1; ++p) {
            minDiff = Math.min(minDiff, Math.abs(aF[p - 1] - aB[p]));    
        }
        
        return minDiff;
    }
}