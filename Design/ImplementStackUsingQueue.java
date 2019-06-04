class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q = new LinkedList<>();
    private int size=0;
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        for(int i=0; i<size; i++) {
               q.add(q.poll());
        }
        this.size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        this.size--;
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size==0;
    }
}