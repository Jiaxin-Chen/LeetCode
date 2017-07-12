/*
224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
 */

import java.util.*;

public class LC224{
	// Time Complexity: O(N)
	// Runtime: 9ms, beats 94.12%
	public int calculate(String s){
		Stack<Integer> stack = new Stack<>();
		char[] ch = s.toCharArray();
		int res = 0, sign = 1;
		for(int i = 0; i < ch.length; i++){
			if(ch[i] >= '0' && ch[i] <= '9'){
				int num = ch[i] - '0';
				while(i + 1 < ch.length && (ch[i+1] >= '0' && ch[i+1] <= '9'))
					num = num * 10 + ch[++i] - '0';					
				res += sign * num;
			}
			else if(ch[i] == '+'){
				sign = 1;
			}else if(ch[i] == '-'){
				sign = -1;
			}else if(ch[i] == '('){
				stack.push(res);
				stack.push(sign);
				res = 0; 
				sign = 1;
			}else if(ch[i] == ')'){
				res = stack.pop() * res + stack.pop();
			}
		}
		return res;
	}

	public static void main(String[] args){
		LC224 x = new LC224();
		String s = "2147483647";
		int res = x.calculate(s);
		System.out.println(res);
	}
}