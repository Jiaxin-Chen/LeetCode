/*
227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
 */

import java.util.*;

public class LC227{
	// Time Complexity: O(N)
	// Runtime: 22ms, beats 91.20%
	public int calcualte(String s){
		Stack<Integer> stack = new Stack<>();
		char[] ch = s.toCharArray();
		int res = 0, num = 0;
		char op = '+';

		for(int i = 0; i < ch.length; i++){
			// Cannot skip ' ' here!!!
			/*if(ch[i] == ' ')
				continue;*/
			if(ch[i] >= '0' && ch[i] <= '9'){
				num = ch[i] - '0';
				while(i+1 < ch.length && (ch[i+1] >= '0' && ch[i+1] <= '9'))
					num = num * 10 + ch[++i] - '0';
			}
			// Corner case: ch[i] != ' ' : "3 + 5 / 2"
			// Corner case: i == ch.length - 1 : "1"
			if(((ch[i] < '0' || ch[i] > '9') && (ch[i] != ' ')) || i == ch.length - 1){
				if(op == '+'){
					stack.push(num);
				}else if(op == '-'){
					stack.push(-num);
				}else if(op == '*'){
					stack.push(stack.pop() * num);
				}else if(op == '/'){
					stack.push(stack.pop() / num);
				} 
				op = ch[i];
				num = 0;
			}
		}

		while(!stack.isEmpty())
			res += stack.pop();

		return res;
	}

	public static void main(String[] args){
		LC224 x = new LC224();
		String s = "3+ 5 / 2 ";
		int res = x.calculate(s);
		System.out.println(res);
	}
}

