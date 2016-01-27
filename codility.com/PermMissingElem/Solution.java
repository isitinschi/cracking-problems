class Solution {
    public int solution(int[] A) {
        int val = 0;
        for (int i = 0; i < A.length; ++i) {
            val += i + 1;
            val -= A[i];
        }
        val += A.length + 1;
        
        return val;
    }
}