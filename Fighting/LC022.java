/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

import java.util.*;

public class LC022{
	// Time Complexity: O(NlogN)
	// Runtime: 2ms, beats 90.34%
	public List<String> generateParenthesis(int n){
		List<String> res = new ArrayList<String>();
		backtracking(res, new StringBuilder(), n, n);
		return res;
	}

	private void backtracking(List<String> res, StringBuilder cur, int open, int close){
		if(open == 0 && close == 0)
			res.add(cur.toString());

		if(open > 0){
			cur.append('(');
			backtracking(res, cur, open - 1, close);
			cur.deleteCharAt(cur.length() - 1);
		}

		if(open < close){
			cur.append(')');
			backtracking(res, cur, open, close - 1);
			cur.deleteCharAt(cur.length() - 1);
		}
	}

	public static void main(String[] args){
		LC022 x = new LC022();
		int n = 5;
		List<String> res = x.generateParenthesis(n);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}