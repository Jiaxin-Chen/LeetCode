import java.util.*;

public class MyStack {
	/* 225. Implement Stack using Queues:
	 * Implement the following operations of a stack using queues.
	 * push(x) -- Push element x onto stack.
	 * pop() -- Removes the element on top of the stack.
	 * top() -- Get the top element.
	 * empty() -- Return whether the stack is empty.
	 */
	
	Queue<Integer> stack;
	
	public MyStack(){
		stack = new LinkedList<Integer>();
	}
	
	public void push (int x){
		stack.add(x);
		int length = stack.size();
		for(int i = 0; i < length - 1; i++){
			stack.add(stack.poll());
		}
	}
	
	public int pop(){
		return stack.poll();
	}
	
	public int top(){
		return stack.element();
	}
	
	public boolean empty(){
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		MyStack obj = new MyStack();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.pop());
		System.out.println(obj.top());
		System.out.println(obj.pop());
		if(obj.empty()){
			System.out.println("true");
		}
	}

}
