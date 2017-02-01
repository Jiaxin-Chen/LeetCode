import java.util.*;

public class Solution150 {
	/* 150. Evaluate Reverse Polish Notation:
	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	 * Input: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	 * 		  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	
	
	/*
	 * Accepted but cannot handle some corner case such as ["3", "0", "/"]
	 */
	public int evaRPN(String[] tokens){
		Stack <Integer> stack = new Stack<Integer>();
		int tmp1, tmp2;
		
		for(int i = 0; i < tokens.length; i++){
			if(tokens[i].equals("+")){
				stack.push(stack.pop() + stack.pop());
			}else if(tokens[i].equals("-")){
				tmp1 = stack.pop();
				tmp2 = stack.pop();
				stack.push(tmp2 / tmp1);
			}else if(tokens[i].equals("*")){
				stack.push(stack.pop() * stack.pop());
			}else if(tokens[i].equals("/")){
				tmp1 = stack.pop();
				tmp2 = stack.pop();
				stack.push(tmp2 / tmp1);
			}else{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args){
		String[] tokens = {"4", "13", "5", "/", "+"};
		Solution150 res = new Solution150();
		System.out.println(res.evaRPN(tokens));
	}
}
