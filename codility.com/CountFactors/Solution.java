class Solution {
    public int solution(int N) {
        if (N < 1) {
            return 0;    
        }
        
        int count = 0;
        double sqrt = Math.sqrt(N);
        for (int i = 1; i <= sqrt; ++i) {
            if (N % i == 0) {
                if (i == sqrt) {                                        
                    ++count;    
                } else {
                    count += 2;    
                }
            }
        }
        
        
        return count;
    }
}