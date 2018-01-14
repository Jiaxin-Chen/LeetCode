/*
712. Minimum ASCII Delete Sum for Two Strings

Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
Note:

0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].
*/

class LC712{
	// Time Complexity: O(mn), Space Complexity: O(MN)
	// Runtime: 48ms, beats 54.51%
	public int minimumDeleteSum(String s1, String s2){
		int m = s1.length(), n = s2.length();

		int[][] dp = new int[m+1][n+1];
		for(int i = 1; i <= m; i++){
			dp[i][0] = dp[i-1][0] + Integer.valueOf(s1.charAt(i-1));
		}
		for(int j = 1; j <= n; j++){
			dp[0][j] = dp[0][j-1]+ Integer.valueOf(s2.charAt(j-1));
		}

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i - 1][j] + Integer.valueOf(s1.charAt(i-1)), dp[i][j - 1] + Integer.valueOf(s2.charAt(j-1)));
				}
			}
		}
		return dp[m][n];
	}

//------------------------------------------------------------------
	// Time Complexity: O(mn), Space Complexity: O(MN)
	// Runtime: 25ms, beats 99.72%
	public int minimumDeleteSum2(String s1, String s2){
		int m = s1.length(), n = s2.length();

		int[][] dp = new int[m+1][n+1];
		char[] ch1 = s1.toCharArray(), ch2 = s2.toCharArray();
		for(int i = 1; i <= m; i++){
			dp[i][0] = dp[i-1][0] + ch1[i-1];
		}
		for(int j = 1; j <= n; j++){
			dp[0][j] = dp[0][j-1]+ ch2[j-1];
		}

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(ch1[i-1] == ch2[j-1]){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i - 1][j] + ch1[i-1], dp[i][j - 1] + ch2[j-1]);
				}
			}
		}
		return dp[m][n];
	}

//--------------------------------------------------------------------
	// Time Complexity: O(mn), Space Complexity: O(N)
	// Runtime: 30ms, beats 96.45%
	public int minimumDeleteSum3(String s1, String s2){
		int m = s1.length(), n = s2.length();

		int[] dp = new int[n+1];
		char[] ch1 = s1.toCharArray(), ch2 = s2.toCharArray();

		for(int j = 1; j <= n; j++){
			dp[j] = dp[j-1]+ ch2[j-1];
		}

		for(int i = 1; i <= m; i++){
			int pre = dp[0];
			dp[0] += ch1[i-1];
			for(int j = 1; j <= n; j++){
				int cur = dp[j];
				if(ch1[i-1] == ch2[j-1]){
					dp[j] = pre;
				}else{
					dp[j] = Math.min(dp[j] + ch1[i-1], dp[j - 1] + ch2[j-1]);
				}
				pre = cur;
			}
		}
		return dp[n];
	}

	public static void main(String[] args){
		String s1 = "sea", s2 = "eat";
		LC712 x = new LC712();

		System.out.println(x.minimumDeleteSum3(s1, s2));
	}
}