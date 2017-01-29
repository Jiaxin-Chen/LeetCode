import java.util.*;

public class MyQueue {
	/* 232. Implement Queue using Stacks
	 * Implement the following operations of a queue using stacks.
	 * push(x) -- Push element x to the back of queue.
	 * pop() -- Removes the element from in front of queue.
	 * peek() -- Get the front element.
	 * empty() -- Return whether the queue is empty.
	 */

	Stack<Integer> queue;
	
	public MyQueue(){
		queue = new Stack<Integer>();
	}
	
	public void push(int x){
		Stack<Integer> tmp = new Stack<Integer>();
		while(!queue.empty()){
			tmp.push(queue.pop());
		}
		queue.push(x);
		while(!tmp.empty()){
			queue.push(tmp.pop());
		}
	}
	
	public int pop(){
		return queue.pop();
	}
	
	public int peek(){
		return queue.peek();
	}
	
	public boolean empty(){
		return queue.empty();
	}
	
	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.pop());
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		if(obj.empty()){
			System.out.println("true");
		}
	}

}
