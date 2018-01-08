/*
10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

class LC010{
	/*
	1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
	2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
	3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]   // in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
*/
	public boolean isMatch(String s, String p){
		if(s == null || p == null){
			return false;
		}
		int m = s.length(), n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		for(int j = 1; j <= n; j++){
			if(p.charAt(j - 1) == '*'){
				if(dp[0][j-1] || (j > 1 && dp[0][j - 2])){
					dp[0][j] = true;
				} 
			}
		}

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
					dp[i][j] = dp[i-1][j-1];
				}
				if(p.charAt(j - 1) == '*'){
					if(s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.'){
						dp[i][j] = dp[i][j - 2];
					}else{ 
						dp[i][j] = dp[i-1][j]   //in this case, a* counts as multiple a 
								|| dp[i][j-1]	// in this case, a* counts as single a
								|| dp[i][j-2];	// in this case, a* counts as empty
					}
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args){
		LC010 x = new LC010();
		String s = "aab", p = "c*a*b";
		System.out.println(x.isMatch(s, p));
	}
}