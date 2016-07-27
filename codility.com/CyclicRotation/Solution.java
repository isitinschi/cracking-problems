class Solution {
    public int[] solution(int[] A, int K) {
        if (A == null || A.length < 2 || K % A.length == 0) {
            return A;
        }
        
        int length = A.length;
        if (length < 2) {
            return A;
        }
        
        K = K % A.length;
        if (K == 0) {
            return A;
        }
        
        int [] rotated = new int [length];
        for (int i = 0; i < length; ++i) {
            if (i < K) {
                rotated[i] = A[length - K + i];    
            } else {
                rotated[i] = A[i - K];    
            }
        }
        
        return rotated;
    }
}