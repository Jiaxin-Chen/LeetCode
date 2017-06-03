/*
17. Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

import java.util.*;

public class LC017{
	// Time Complexity: O(N)
	// Runtime: 4ms, beats 46.69%
	public List<String> letterCombinations(String digits){
		List<String> res = new LinkedList<>();
		if(digits == null || digits.length() == 0)
			return res;

		String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		for(int i = 0; i < digits.length(); i++){
			int num = digits.charAt(i) - '0';
			while(res.get(0).length() == i){
				String tmp = res.remove(0);  // Retrieves and removes the head (first element) of this list.
				char[] chars = map[num].toCharArray();
				for(char ch : chars)
					res.add(tmp + ch);
			}
		}
		return res;
	}

	public static void main(String[] args){
		String digits = "456";
		LC017 x= new LC017();
		List<String> res = x.letterCombinations(digits);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}