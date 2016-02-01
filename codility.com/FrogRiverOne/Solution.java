import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int X, int[] A) {
        if (X <= 0 || A == null || A.length == 0) {
            return -1;    
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], i);    
            }
        }
        
        int max = -1;
        for (int i = 1; i <= X; ++i) {
            Integer sec = map.get(i);
            if (sec == null) {
                return -1;    
            } else {
                max = Math.max(max, sec); 
            }
        }
        
        return max;
    }
}