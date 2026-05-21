class MinStack {
    Stack<Integer> st;
    Stack<Integer> meen;

    public MinStack() {
        st = new Stack<>();
        meen = new Stack<>();
    }

    public void push(int val) {
        st.push(val);

        if (meen.isEmpty()) {
            meen.push(val);
        }
        else {
            meen.push(Math.min(meen.peek(), val));
        }
    }

    public void pop() {
        st.pop();
        meen.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return meen.peek();
    }
}