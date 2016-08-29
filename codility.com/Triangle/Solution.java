import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        
        for (int i = 0; i < A.length - 2; ++i) {
            if (valid(A, i)) {
                return 1;    
            }
        }
        
        return 0;
    }
    
    private boolean valid(int[] a, int i) {
        long p = a[i];
        long q = a[i + 1];
        long r = a[i + 2];
        return p + q > r && q + r > p && r + p > q;
    }
}