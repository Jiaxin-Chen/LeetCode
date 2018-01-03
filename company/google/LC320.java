/*
320. Generalized Abbreviation

Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/

import java.util.*;

class LC320{
	// Time Complexity: O(2^N)
	// Runtime: 21ms, beats 42.01%
	public List<String> generateAbbreviations(String word){
		List<String> res = new LinkedList<>();
		if(word == null || word.length() == 0){
			return res;
		}
		char[] chs = word.toCharArray();
		backtracking(res, chs, 0, "", 0);
		return res;
	}

	private void backtracking(List<String> res, char[] chs, int pos, String cur, int count){
		if(pos == chs.length){
			if(count > 0){
				cur += count;
			}
			res.add(cur);
		}else{
			// abbreviations characters with number
			backtracking(res, chs, pos + 1, cur, count + 1);
			// characters
			backtracking(res, chs, pos + 1, cur + (count>0 ? count : "") + chs[pos], 0);
		}
	}

	public static void main(String[] args){
		String word = "word";
		LC320 X = new LC320();
		System.out.println(X.generateAbbreviations(word));
	}
}