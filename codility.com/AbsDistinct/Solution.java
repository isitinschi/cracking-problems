import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] A) {
        return count2(A);
    }
    
    private int count1(int [] A) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < A.length; ++i) {
            set.add(abs(A[i]));    
        }
        
        return set.size();    
    }
    
    // in place
    private int count2(int [] A) {
        int count = 0;
        int i = 0;
        int j = A.length - 1;
        
        while (i <= j) {
            while (i < j && A[i] == A[i + 1])
                ++i;
            while (i < j && A[j] == A[j - 1])
                --j;
            
            long ai = abs(A[i]);    
            long aj = abs(A[j]);
            if (ai != aj) {
                if (aj > ai) {
                    --j;    
                } else {
                    ++i;    
                }
            } else {
                while (i <= j && abs(A[i]) == ai && abs(A[i]) == abs(A[j])) {
                    ++i;
                    --j;
                }
            }
            
            ++count;
        }
        
        return count;
    }
    
    private long abs(int val) {
        return Math.abs((long) val);    
    }
}