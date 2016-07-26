class Solution {
    public int solution(int N) {
        if (N < 0) {
            N *= -1;    
        }
        int gap = 0;
        
        int lastIndex = -1;
        int i = 0;
        while (N > 0) {
            int rest = N % 2;
            if (rest == 1) {
                if (lastIndex == -1) {
                    lastIndex = i;    
                } else {
                    gap = Math.max(gap, i - lastIndex - 1);
                    lastIndex = i;
                }
            }
            
            N /= 2;
            ++i;
        }
        
        return gap;
    }
}