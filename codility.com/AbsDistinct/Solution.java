import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] A) {
        int count = 0;
        
        Set<Integer> set = new HashSet<>();
        if (A != null && A.length != 0) {
            for (int i = 0; i < A.length; ++i) {
                set.add(Math.abs(A[i]));
            }
            
            count = set.size();
        }
        
        return count;
    }
}