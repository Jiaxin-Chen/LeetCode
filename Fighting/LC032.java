/*
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

import java.util.*;

public class LC032{
	public int longestValidParentheses(String s){
		if(s.length() == 0)
			return 0;

		// Utilize Deque instead of Stack to avoid TLE
		// Stack and ArrayDeque are implemented with resizable array, and every time it is full, 
		// all of the elements will be copied to a new allocated array, which is costly if this 
		// process is invoked repeatedly and thus leads to TLE on large test cases. 
		// Specifying an initial capacity can prevent this from happening.
		Deque<Integer> stack = new ArrayDeque<>(s.length());
		//Stack<Integer> stack = new Stack<Integer>();
		char[] ch = s.toCharArray();
		int max = 0, left = -1;
		for(int i = 0; i < ch.length; i++){
			if(ch[i] == '('){
				stack.push(i);
			}else{
				// Set for the new subString
				if(stack.isEmpty())
					left = i;
				else{
					stack.pop();
					if(stack.isEmpty())
						max = Math.max(max, i - left);
					else
						max = Math.max(max, i - stack.peek());
				}
			}
		}
		return max;
	}

	public static void main(String[] args){
		LC032 x = new LC032();
		String s = "()(()";
		int len = x.longestValidParentheses(s);
		System.out.println(len);
	}
}