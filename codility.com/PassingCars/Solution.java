class Solution {
    private static final int MAX = 1000000000;
    
    public int solution(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        
        int passed = 0;
        int count = 0;
        for (int i = A.length - 1; i >= 0; --i) {
            if (A[i] == 0) {
                passed += count;
            } else {
                ++count;
            }
            if (passed > MAX) {
                return -1;
            }
        }
        
        return passed;
    }
}