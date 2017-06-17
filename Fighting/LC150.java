/*
150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

import java.util.*;

public class LC150{
	// Time Complexity: O(N)
	// Runtime: 13ms, beats 73.37%
	public int evalRPN(String[] tokens){
		if(tokens.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int op1 = 0, op2 = 0;
		for(String s : tokens){
			if(s.equals("+")){
				stack.push(stack.pop() + stack.pop());
			}else if(s.equals("*")){
				stack.push(stack.pop() * stack.pop());
			}else if(s.equals("-")){
				op2 = stack.pop();
				op1 = stack.pop();
				stack.push(op1 - op2);
			}else if(s.equals("/")){
				op2 = stack.pop();
				op1 = stack.pop();
				stack.push(op1 / op2);
			}else{
				stack.push(Integer.valueOf(s));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args){
		String[] tokens = {"2", "1", "+", "3", "*"};
		LC150 x = new LC150();
		System.out.println(x.evalRPN(tokens));
	}
}

