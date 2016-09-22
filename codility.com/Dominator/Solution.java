class Solution {
    public int solution(int[] A) {
        if (A == null || A.length < 1) {
            return -1;    
        }
        
        int count = 0;
        int dominator = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == A[dominator]) {
                ++count;    
            } else {
                --count;    
            }
            if (count == 0) {
                dominator = i;
                count = 1;
            }
        }
        
        // is a real dominator?
        count = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == A[dominator]) {
                ++count;    
            }
        }
        
        return count > (double) A.length / 2 ? dominator : -1;
    }
}