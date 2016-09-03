import java.util.Set;
import java.util.Stack;
import java.util.HashSet;

class Solution {
    private Set<Integer> set;
    Stack<Integer> stack;
    
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;    
        }
        
        set = new HashSet<>();
        stack = new Stack<>();
        set.add(A[0]);
        stack.push(A[0]);
        int count = 1;
        for (int i = 1; i < A.length; ++i) {
            int height = A[i];
            revalidate(height);
            if (!set.contains(height)) {
                ++count;                
                set.add(height);
                stack.push(height);
            }
        }
        
        return count;
    }
    
    private void revalidate(int height) {
        while (!stack.isEmpty() && stack.peek() > height) {
            set.remove(stack.pop());
        }
    }
}