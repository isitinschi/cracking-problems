class Solution {
    
    private static final int MAX = 1000000000;
    
    public int solution(int M, int[] A) {
        int count = 0;
        
        if (M < 0 || A == null || A.length == 0) {
            return 0;    
        }        
        
        int [] B = new int [M + 1];
        for (int i = 0; i <= M; ++i) {
            B[i] = -1;    
        }
        
        try {
            int start = 0;
            for (int i = 0; i < A.length; ++i) {
                if (B[A[i]] >= start) {
                    int i1 = B[A[i]];
                    count = Math.addExact(count, calc(start, i - 1) - calc(i1 + 1, i - 1));
                    start = i1 + 1;
                }
                B[A[i]] = i;
            }
            count = Math.addExact(count, calc(start, A.length - 1)); 
            
            count = Math.addExact(count, A.length); // (0, 0), (1, 1), ..., (N - 1, N - 1)
            
            if (count > MAX) {
                return MAX;
            }
            
            return count;
        } catch (ArithmeticException e) {
            return MAX;
        }
    }
    
    private int calc(int start, int i) {
        int N1 = i - start + 1;
        int N2 = N1 - 1;
        
        if (N1 % 2 == 0) {
            N1 /= 2;
        } else {
            N2 /= 2;
        }
        
        return Math.multiplyExact(N1, N2);
    }
}