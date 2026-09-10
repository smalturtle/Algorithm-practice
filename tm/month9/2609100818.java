/**
 * 力扣：155. 最小栈
 * 
 */

/**
思路：入栈的时候，最小栈同时维护一个此时入栈的最小值

 */

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>(); 
        minstack = new Stack<>(); 
        minstack.push(Integer.MAX_VALUE);
    }
    
    public void push(int value) {
        stack.push(value);
        //此时最小栈的栈顶就是value对应的最小元素，只需要记得pop的时候连同这个最小值一起pop了
        minstack.push(Math.min(minstack.peek(),value));
    }
    
    public void pop() {
        stack.pop();
        minstack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */