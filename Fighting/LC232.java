/*
232. Implement Queue using Stacks

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

import java.util.*;

// Runtime: 89ms, beats 94.66%
public class LC232{
	Stack<Integer> queue = new Stack<>();
	 /** Initialize your data structure here. */
    public LC232() {
        //queue = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
        	stack.push(queue.pop());
        }
        queue.push(x);
        while(!stack.isEmpty()){
        	queue.push(stack.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args){
    	LC232 x = new LC232();
    	x.push(1);
    	x.push(2);
    	x.push(3);
    	System.out.println(x.empty());
    	System.out.println(x.peek());
    	System.out.println(x.pop());
    	System.out.println(x.peek());
    	System.out.println(x.pop());
    	System.out.println(x.peek());
    	System.out.println(x.pop());
    	System.out.println(x.empty());
    }
}