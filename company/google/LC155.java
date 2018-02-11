/*
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

// Time Complexity: O(N)
class MinStack {
    
    Stack<Long> stack;
    long min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if(x < min) {
                min = x;
            }
        }
        
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        long cur = stack.pop();
        if(cur < 0) {
            min -= cur;
        }
    }
    
    public int top() {
        if(stack.peek() < 0) {
            return (int) min;
        }else {
            return (int) (min + stack.peek());
        }
    }
    
    public int getMin() {
        return (int) min;
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