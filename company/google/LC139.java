/*
139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). 
Please reload the code definition to get the latest changes.
*/

import java.util.*;

class LC139{
	// Time Complexity: O(N^2), N is the length of s
	// Runtime: 19ms, beats 18.25%
	public boolean wordBreak(String s, List<String> wordDict){
		int n = s.length();
		boolean[] dp = new boolean[n + 1];

		dp[0] = true;
		for(int i = 1; i <= n; i++){ // i <= n, which can let it go to the end of the string
			for(int j = 0; j < i; j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true; // indicates the wordDict contains the s.substring(j, i), we can go the the next part of the string
					System.out.println("dp[" + i + "] = " + dp[i]);
				
					break;  // we can break to find next substring
				}	
			}
		}
		return dp[n];
	}

	public static void main(String[] args){
		List<String> wordDict = Arrays.asList("leet", "code");

		String s = "leetcode";
		LC139 x = new LC139();

		System.out.println(x.wordBreak(s, wordDict));
	}
}
