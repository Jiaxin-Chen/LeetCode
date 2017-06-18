/*
140. Word Break II

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

import java.util.*;

public class LC140{

	// Time Complexity: O(2^N)
	// Runtime: 13ms, beats 85.20%
	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	
	public List<String> wordBreak(String s, List<String> wordDict){
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0)
			return res;

		if(map.containsKey(s)){
			return map.get(s);
		}
		if(wordDict.contains(s))
			res.add(s);

		for(int i = 1; i < s.length(); i++){
			String t = s.substring(i);
			if(wordDict.contains(t)){
				List<String> tmp = wordBreak(s.substring(0, i), wordDict);
				if(tmp.size() != 0){
					for(int j = 0; j < tmp.size(); j++)
						res.add(tmp.get(j) + " " + t);
				}
			}
		}
		map.put(s, res);
		return res;
	}
}