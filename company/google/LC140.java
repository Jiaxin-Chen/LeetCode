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

class LC140{
	// Brute Force: backtracking
	// TLE
	// Time Complexity: O(2^N)
	public List<String> wordBreak(String s, List<String> wordDict){
		List<String> res = new LinkedList<>();
		if(wordDict == null || wordDict.size() == 0){
			return res;
		}
		backtracking(res, s, wordDict, new StringBuilder(), 0);
		return res;
	}

	private void backtracking(List<String> res, String s, List<String> wordDict, StringBuilder sb, int pos){
		if(pos == s.length()){
			res.add(sb.toString());
			return;
		}
		for(int i = pos; i < s.length(); i++){
			String str = s.substring(pos, i + 1);
			if(wordDict.contains(str)){
				//System.out.println(str);
				if(i + 1 != s.length()){
					sb.append(str).append(" ");
					backtracking(res, s, wordDict, sb, i + 1);
					sb.setLength(sb.length() - str.length() - 1);
				}else{
					sb.append(str);
					backtracking(res, s, wordDict, sb, i + 1);
					// we cannot omit this step because we should set the lenght back to the empty for the next list
					sb.setLength(sb.length() - str.length()); 
				}
			}
		}
	}

	/* Consider the input “aaaaaa”, with wordDict = [“a”, “aa”, “aaa”, “aaaa”, “aaaaa”, “aaaaa”]. 
	Every possible partition is a valid sentence, and there are 2^n-1 such partitions. 
	It should be clear that the algorithm cannot do better than this since it generates all valid sentences. 
	The cost of iterating over cached results will be exponential, as every possible partition will be cached, 
	resulting in the same runtime as regular backtracking. Likewise, the space complexity will also be O(2^n) 
	for the same reason - every partition is stored in memory.

	Where this algorithm improves on regular backtracking is in a case like this: “aaaaab”, 
	with wordDict = [“a”, “aa”, “aaa”, “aaaa”, “aaaaa”, “aaaaa”], i.e. the worst case scenario for Word Break I, 
	where no partition is valid due to the last letter ‘b’. In this case there are no cached results, 
	and the runtime improves from O(2^n) to O(n^2).
	*/

	// Optimization: use HashMap to avoid duplicates
	// Time Complexity: O(2^N)
	// Runtime: 12ms, beats 83.27%
	public List<String> wordBreak2(String s, List<String> wordDict){
		// key is the current string, value is it's all corresponding string list.
		// we can consider the map as the dp map
		// because we can obtain the calculated List<String> res by map.get(s)
		Map<String, LinkedList<String>> map = new HashMap<>();
		return dfs(s, wordDict, map);
	}

	private List<String> dfs(String s, List<String> wordDict, Map<String, LinkedList<String>> map){
		if(map.containsKey(s)){
			return map.get(s);
		}

		LinkedList<String> res = new LinkedList<>();
		if(s == null || s.length() == 0){
			res.add("");
			return res;
		}

		for(String word : wordDict){
			if(s.startsWith(word)){
				// dfs the left part of the s, which is s.substring(word.length())
				List<String> tmp = dfs(s.substring(word.length()), wordDict, map);
				for(String str : tmp){
					res.add(word + (str.isEmpty() ? "" : " ") + str);
				}
			}
		}
		map.put(s, res);
		return res;
	}


	public static void main(String[] args){
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		String s = "catsanddog";

		LC140 x = new LC140();
		System.out.println(x.wordBreak2(s, wordDict));
	}


}