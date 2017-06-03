/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.*;

public class LC020{
	// Time Complexity: O(N)
	// Runtime: 10ms, beats 61.35%
	public boolean isValid(String s){
		if(s == null || s.length() == 0)
			return false;
		Stack<Character> stack = new Stack<>();

		char[] ch = s.toCharArray();
		for(char c : ch){
			if(c == '[')
				stack.push(']');
			else if(c == '(')
				stack.push(')');
			else if(c == '{')
				stack.push('}');
			// Handle the case "]"
			else if(stack.isEmpty() || c != stack.pop())
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args){
		LC020 x = new LC020();
		String s = "()()";
		System.out.println(x.isValid(s));
	}
}