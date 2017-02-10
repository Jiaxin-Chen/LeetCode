import java.util.*;

public class Solution22 {
	/*
	 * 22. Generate Parentheses:
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	 * For example, given n = 3, a solution set is:
	 * ["((()))",
	 *  "(()())",
	 *  "(())()",
	 *  "()(())",
	 *  "()()()"]
	 */
	
	
	// R
	public List<String> generateParenthesis(int n){
		List<String> res = new ArrayList<String>();
		
		generate(new StringBuilder(""), n, n, res);
		return res;
	}
	
	private void generate(StringBuilder cur, int open, int close, List<String> res){
		if(open == 0 && close == 0){
			res.add(cur.toString());
		}
		
		if(open > 0){
			cur.append('(');
			generate(cur, open - 1, close, res);
			cur.deleteCharAt(cur.length() - 1);
		}
		
		if(open < close){
			cur.append(')');
			generate(cur, open, close - 1, res);
			cur.deleteCharAt(cur.length() - 1);
		}
	}
	
	
	public static void main(String[] args){
		int n = 3;
		Solution22 res = new Solution22();
		System.out.println(res.generateParenthesis(n));
	}
}
