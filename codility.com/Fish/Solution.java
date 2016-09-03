import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        int i = 0;
        int count = 0;
        int N = A.length;
        Stack<Integer> stack = new Stack<>();
        while (i < N) {
            if (B[i] == 0) {
                while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    stack.pop();    
                }
                if (stack.isEmpty()) {
                    ++count;    
                }
            } else {
                stack.push(i);
            }
            
            ++i;
        }
        
        return count + stack.size();
    }
}