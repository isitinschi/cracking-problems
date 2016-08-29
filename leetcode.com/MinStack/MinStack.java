public class MinStack {
    
    private Stack<Integer> valStack = null;
    private Stack<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
        
        valStack.push(x);
    }
    
    public void pop() {
        valStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */