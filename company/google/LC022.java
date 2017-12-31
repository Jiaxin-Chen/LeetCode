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

class LC022{
	// Time Complexity: (n^2)
	// Runtime: 3ms, beats 50.74%
	public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if(n < 1){
        	return res;
        }

        backtracking(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void backtracking(List<String> res, StringBuilder sb, int n, int left, int right){
    	if(sb.length() == 2 * n){
    		res.add(sb.toString());
    	}else{
    		if(left < n){
    			sb.append("(");
    			backtracking(res, sb, n, left + 1, right);
    			sb.setLength(sb.length() - 1);
    		}
    		if(right < left){
    			sb.append(")");
    			backtracking(res, sb, n, left, right + 1);
    			sb.setLength(sb.length() - 1);
    		}
    	}
    }

    public static void main(String[] args){
    	LC022 x = new LC022();
    	int n = 3;
    	System.out.println(x.generateParenthesis(n));
    }
}