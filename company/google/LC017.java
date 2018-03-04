/*
17. Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

import java.util.*;	

class LC017{
	// Iterative: FIFO queue
	// Time Complexity: O(m^n), the average number of letters on every number is m, and the length of digits string is n
	// Runtime: 3ms, beats 67.99%
	public List<String> letterCombinations(String digits){
		LinkedList<String> res = new LinkedList<>();

		if(digits == null || digits.length() == 0){
			return res;
		}
		
		String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		char[] nums = digits.toCharArray();
		res.add("");

		for(int i = 0; i < nums.length; i++){
			char[] letters = map[nums[i] - '0'].toCharArray();

			// res.peek().length() == i indicates current string hasn't be added the letter
			while(res.peek().length() == i){
				String cur = res.remove();
				for(char letter : letters){
					res.add(cur + letter);
				}
			}
		}
		return res;
	}

	// backtracking
	// Time Complexity: O(k^N), m: the average number of letters on every number, n: the length of digits string
	// Runtime: 3ms, beats 67.99%
	public List<String> letterCombinations2(String digits){
		List<String> res = new LinkedList<>();
		if(digits == null || digits.length() == 0){
			return res;
		}
		String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		char[] nums = digits.toCharArray();

		StringBuilder sb = new StringBuilder();
		combination(res, map, nums, sb, 0);
		return res;
	}

	private void combination(List<String> res, String[] map, char[] nums, StringBuilder sb, int idx){
		if(idx == nums.length){
			res.add(sb.toString());
			return;
		}
		char[] letters = map[nums[idx] - '0'].toCharArray();
		for(int i = 0; i < letters.length; i++){
			int len = sb.length();
			combination(res, map, nums, sb.append(letters[i]), idx + 1);
			sb.setLength(len);
		}
	}


	// backtracking
	// Time Complexity: O(k^N), m: the average number of letters on every number, n: the length of digits string
	// Runtime: 3ms, beats 67.99%
	public List<String> letterCombinations3(String digits){
		List<String> res = new LinkedList<>();
		if(digits == null || digits.length() == 0){
			return res;
		}
		String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		char[] nums = digits.toCharArray();

		combination2(res, map, nums, "", 0);
		return res;
	}

	private void combination2(List<String> res, String[] map, char[] nums, String cur, int idx){
		if(idx == nums.length){
			res.add(cur);
			return;
		}
		char[] letters = map[nums[idx] - '0'].toCharArray();
		for(int i = 0; i < letters.length; i++){
			combination2(res, map, nums, cur + letter[i], idx + 1);
			sb.setLength(len);
		}
	}



	public static void main(String[] args){
		String digits = "23";
		LC017 x = new LC017();
		System.out.println(x.letterCombinations2(digits));
	}
}