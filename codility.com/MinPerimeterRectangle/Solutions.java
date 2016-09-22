class Solution {
    public int solution(int N) {
        if (N < 1) {
            return 0;    
        }
        
        int count = 0;
        double sqrt = Math.sqrt(N);
        int minP = Integer.MAX_VALUE;
        for (int i = 1; i <= sqrt; ++i) {
            if (N % i == 0) {
                int p = calcPerimeter(i, N / i);
                minP = Math.min(minP, p);
            }
        }        
        
        return minP;
    }
    
    private int calcPerimeter(int a, int b) {
        return 2 * (a + b);    
    }
}