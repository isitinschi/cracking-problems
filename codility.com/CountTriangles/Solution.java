import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A == null || A.length < 3) {
            return 0;    
        }
        
        Arrays.sort(A);
        
        int N = A.length;
        int count = 0;
        for (int i = 0; i < N - 2; ++i) {
            int k = i + 2;
            for (int j = i + 1; j < N - 1; ++j) {
                while (k < N && A[i] + A[j] > A[k]) {
                    ++k;    
                }
                count += k - j - 1;
            }
        }
        
        return count;
    }
}