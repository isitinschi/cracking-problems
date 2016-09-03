import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private static final int LIMIT = 10000000;    
    
    public int solution(int[] A) {
        List<int []> criticalPoints = new ArrayList<>(A.length * 2);
        for (int i = 0; i < A.length; ++i) {
            criticalPoints.add(new int [] {i - A[i], i, 0}); // start
            criticalPoints.add(new int [] {i + A[i], i, 1}); // end
        }
        
        Collections.sort(criticalPoints, new Comparator<int []>() {
        
            @Override
            public int compare(int [] p1, int [] p2) {
                int val = Integer.valueOf(p1[0]).compareTo(p2[0]);
                if (val == 0) {
                    val = Integer.valueOf(p1[2]).compareTo(p2[2]); 
                }
                
                return val;
            }
            
        });
        
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < criticalPoints.size(); ++i) {
            while (i < criticalPoints.size() && criticalPoints.get(i)[2] == 0) {
                set.add(criticalPoints.get(i++)[1]);
            }
            
            if (i < criticalPoints.size()) {
                set.remove(criticalPoints.get(i)[1]);
                count += set.size();   
            }
            
            if (count > LIMIT) {
                return -1;    
            }
        }
        
        return count;
    }
}