import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return -1;    
        }
        
        Arrays.sort(A);
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; ++i) {
            int search = -1 * A[i];
            int pos = Arrays.binarySearch(A, search);
            if (pos >= 0) {
                return 0;    
            }
            
            pos = ~pos;
            
            int minAbs;
            if (pos == 0) {
                minAbs = Math.abs(A[i] + A[pos]);
            } else if (pos == A.length) {
                minAbs = Math.abs(A[i] + A[pos - 1]);
            } else {
                minAbs = Math.min(Math.abs(A[i] + A[pos]), Math.abs(A[i] + A[pos - 1])); 
            }
            min = Math.min(min, minAbs);
        }
        
        return min;
    }
}