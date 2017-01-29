import java.util.*;

public class MinStack {
	/* 155. Min Stack
	 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	 * push(x) -- Push element x onto stack.
	 * pop() -- Removes the element on top of the stack.
	 * top() -- Get the top element.
	 * getMin() -- Retrieve the minimum element in the stack.
	 */
	Stack<Integer> stack;
	int min;
	
	public MinStack(){
		stack = new Stack<Integer>();
		min = Integer.MAX_VALUE;
	}
	
	public void push(int x){
		if(x <= min){
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}
	
	public void pop(){
		if(stack.pop() == min){
			min = stack.pop();
		}
	}
	
	public int top(){
		return stack.peek();
	}
	
	public int getMin(){
		return min;
	}
	
	public static void main(String[] args){
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}
