class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;    
        }
        
        int max = A[0];
        int sum = 0;
        for (int i = 0; i < A.length; ++i) {
            A[i] = Math.abs(A[i]);
            max = Math.max(max, A[i]);
            sum += A[i];
        }
        
        int [] count = new int[max + 1];
        for (int i = 0; i < A.length; ++i) {
            count[A[i]] += 1;
        } 
        
        int [] dp = new int[sum + 1];
        for (int i = 0; i <= sum; ++i) {
            dp[i] = -1;    
        }
        dp[0] = 0;
        
        int size = A.length;
        
        for (int a = 1; a <= max; ++a) {
            if (count[a] > 0) {
                for (int j = 0; j < sum; ++j) {
                    if (dp[j] >= 0) {
                        dp[j] = count[a];
                    } else if (j >= a && dp[j - a] > 0) {
                        dp[j] = dp[j - a] - 1;
                    }
                }
            }
        }
        
        int min = sum;
        for (int i = 0; i < sum / 2 + 1; ++i) {
            if (dp[i] >= 0) {
                min = Math.min(min, sum - 2*i);    
            }
        }
        
        return min;
    }
    
}