/*
115. Distinct Subsequences

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit". Return 3.
 */

public class LC115{
	// Time Complexity: O(MN)
	// Runtime: 14ms, beats 69.69%
	public int numDistinct(String s, String t){
		int[][] dp = new int[t.length() + 1][s.length() + 1];

		for(int j = 0; j < s.length(); j++)
			dp[0][j] = 1;

		for(int i = 0; i < t.length(); i++){
			for(int j = 0; j < s.length(); j++){
				if(t.charAt(i) == s.charAt(j))
					dp[i+1][j+1] = dp[i+1][j] + dp[i][j];
				else
					dp[i+1][j+1] = dp[i+1][j];
			}
		}
		return dp[t.length()][s.length()];
	}

	public static void main(String[] args){
		String s = "rabbbit", t = "rabbit";
		LC115 x = new LC115();
		System.out.println(x.numDistinct(s, t));
	}
}