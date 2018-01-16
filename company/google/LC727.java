/*
727. Minimum Window Subsequence

Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
*/

class LC727{
	// Time Complexity: O(MN), Space Complexity: O(MN)
	// Runtime: 71ms, beats 86.10%
	public String minWindow(String s, String t){
		int m = s.length(), n = t.length();

		// dp[i][j] stores the starting index of the substring where T has length i and S has length j.
		int[][] dp = new int[m+1][n+1];

		// we must initialize dp[i][0] = i + 1, not i, because consider about the corner case 
		// which the subsequence t is begin with the 0-th position of the string s
		for(int i = 0; i <= m; i++){
			dp[i][0] = i + 1;
		}

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				//we could borrow the start index from dp[i - 1][j - 1] to make the current substring valid;
				if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
					System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
				//we only need borrow the start index from dp[i][j - 1] which could either exist or not.
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		int start = 0, minLen = Integer.MAX_VALUE;
		for(int i = 1; i <= m; i++){
			if(dp[i][n] != 0){
				if(i - dp[i][n] + 1 < minLen){
					start = dp[i][n] - 1;
					minLen = i - dp[i][n] + 1;
				}
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
	}

	public static void main(String[] args){
		//String s = "abcdebdde", t = "bde";
		String s = "fgrqsqsnodwmxzkzxwqegkndaa", t = "fnok";
		LC727 x = new LC727();
		System.out.println(x.minWindow(s, t));
	}
}