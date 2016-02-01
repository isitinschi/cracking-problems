import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;    
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; ++i) {
            if (set.contains(A[i])) {
                return 0;    
            } else {
                set.add(A[i]);    
            }
        }
        
        for (int i = 1; i <= A.length; ++i) {
            if (!set.contains(i)) {
                return 0;    
            }
        }
        
        return 1;
    }
}