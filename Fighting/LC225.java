/*
225. Implement Stack using Queues

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */

import java.util.*;

// Runtime: 111ms,beats 33.55%
public class LC225{
	Queue<Integer> stack = new LinkedList<>();

	 /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> queue = new LinkedList<>();
        while(!stack.isEmpty())
        	queue.offer(stack.poll());
        stack.offer(x);
        while(!queue.isEmpty())
        	stack.offer(queue.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return stack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }


	public static void main(String[] args){
		LC225 x = new LC225();
		x.push(1);
		x.push(2);
		System.out.println(x.empty());
		System.out.println(x.top());
		System.out.println(x.pop());
		x.push(3);
		System.out.println(x.top());
		System.out.println(x.pop());
		System.out.println(x.top());
		System.out.println(x.pop());
		System.out.println(x.empty());
	}
}