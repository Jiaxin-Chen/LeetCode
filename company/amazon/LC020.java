/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.*;

class LC020{
	public boolean isValid(String s) {
		if (s.length() == 0 || s.equals(""))
			return false;

		Stack<Character> stack = new Stack<>();
		int len = s.length();
		char[] chs = s.toCharArray();

		for(char ch : chs) {
			if (ch == '(') {
				stack.push(')');
			}
			else if (ch == '[') {
				stack.push(']');
			}
			else if (ch == '{') {
				stack.push('}');
			}
			else if (stack.isEmpty() || c != stack.pop()) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args){
		String s = "({{(}})";
		LC020 x = new LC020();
		System.out.println(x.isValid(s));
	}
}
