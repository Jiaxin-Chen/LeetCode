/*
44. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

class LC044{
	// Time Complexity: O(MN)
	// Runtime: 78ms, beats 46.34%
	public boolean isMatch(String s, String p){
		if(s == null || p == null){
			return false;
		}
		int m = s.length(), n = p.length();

		// dp[i][j] denotes if s[0…i-1] matches p[0…j-1]
		boolean[][] dp = new boolean[m + 1][n + 1];

		dp[0][0] = true;
		for(int j = 0; j < n; j++){
			if(p.charAt(j) == '*'){
				dp[0][j + 1] = dp[0][j];
			}
		}

		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
					dp[i+1][j+1] = dp[i][j];
				}
				if(p.charAt(j) == '*'){
					dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args){
		String s = "aab", p = "c*a*b";
		LC044 x = new LC044();
		System.out.println(x.isMatch(s, p));
	}
}