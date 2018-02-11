/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.*;

class LC020{
	// Time Complexity: O(N)
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if(ch == '[') {
				stack.push(']');
			} else if (ch == '(') {
				stack.push(')');
			} else if (ch == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || ch != stack.pop()) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}