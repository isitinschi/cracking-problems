import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A == null || A.length < 3) {
            return 0;    
        }
        
        Arrays.sort(A);
        
        int size = A.length;
        
        return max(A, 1, 0, 0, size - 1);
    }
    
    private int max(int [] a, int mult, int count, int start, int end) {
        if (count == 3) {
            return mult;
        }
        
        return Math.max(max(a, mult * a[start], count + 1, start + 1, end), max(a, mult * a[end], count + 1, start, end - 1));
    }
}