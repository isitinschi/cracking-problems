class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;    
        }
        
        if (A.length == 1) {
            return A[0];    
        }
        
        if (A.length == 2) {
            return A[0] + A[1];    
        }
        
        int [] best = new int[A.length];
        best[0] = A[0];
        for (int i = 1; i < A.length; ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0 && j >= i - 6; --j) {
                max = Math.max(max, best[j]);
            }            
            best[i] = max + A[i];            
        }
        
        return best[A.length - 1];
    }
}