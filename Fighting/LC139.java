/*
139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

import java.util.*;

public class LC139{
	// Time Complexity: O(N^2)
	// Runtime: 13ms, beats 73.88%
	public boolean wordBreak(String s, List<String> wordDict){
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;

		for(int i = 1; i <= len; i++){
			for(int j = 0; j < i; j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}

			}
		}
		return dp[len];
	}
}