class Solution {
    public int solution(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length || A.length == 0) {
            return 0;    
        }
        
        if (A.length == 1) {
            return 1;    
        }
            
        int count = 1;
        int end = B[0];
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > B[i - 1] || A[i] > end) {
                count++;
                end = B[i];
            }
        }
        
        
        
        return count;
    }
}