class MyStack {    

    private Queue<Integer> q1 = new LinkedList<>();    

    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> q2 = new LinkedList<>();
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }        

        q1 = q2;
    }

    // Get the top element.
    public int top() {
        Queue<Integer> q2 = new LinkedList<>();
        int val = 0;
        while (!q1.isEmpty()) {
            if (q1.size() == 1) {
                val = q1.peek();
            }
			
            q2.add(q1.poll());
        }        

        q1 = q2;        

        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }

}