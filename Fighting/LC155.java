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

import java.util.*;


// Time Complexity: O(1)
// Runtime: 111ms, beats 72.17%
public class LC155{

	Stack<Long> stack;
	long min;

	public LC155(){
		stack = new Stack<Long>();
	}

	public void push(int x){
		if(stack.isEmpty()){
			stack.push(0L);
			min = x;
		}else{
			stack.push(x - min);
			if(x < min)
				min = x;
		}
	}

	public void pop(){
		if(stack.isEmpty())
			return;
		long pop = stack.pop();
		if(pop < 0)
			min -= pop;
	}

	public int top(){
		long top = stack.peek();
		if(top < 0)
			return (int)(min);
		else
			return (int)(top + min);
	}

	public int getMin(){
		return (int)(min);
	}
}