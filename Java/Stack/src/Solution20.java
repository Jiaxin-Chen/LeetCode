import java.util.*;

public class Solution20 {
	/* 20. Valid Parentheses:
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 */
	
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()){
			if (c == '('){
				stack.push(')');
			}else if (c == '['){
				stack.push(']');
			}else if (c == '{'){
				stack.push('}');
			}else if (stack.isEmpty() || stack.pop() != c){
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "[]({{}}[])";
		Solution20 res = new Solution20();
		if(res.isValid(s)){
			System.out.println("True");
		}

	}
}
