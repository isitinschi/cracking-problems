class Queue {    

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();    

    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (out.isEmpty() && !in.isEmpty()) {
            rearrange();
        }
        out.pop();
    }   

    private void rearrange() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }

    // Get the front element.
    public int peek() {
        if (out.isEmpty() && !in.isEmpty()) {
            rearrange();
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

}