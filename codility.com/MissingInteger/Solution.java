import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] a) {
        if (a == null || a.length == 0) {
            return 0;    
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; ++i) {
            set.add(a[i]);    
        }
        
        for (int i = 1; i <= a.length + 1; ++i) {
            if (!set.contains(i)) {
                return i;    
            }
        }
        
        return 0;
    }
}