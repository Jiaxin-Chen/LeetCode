/*
583. Delete Operation for Two Strings

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
*/

class LC583{

	// Time Complexity: O(MN), Space Complexity: O(N)
	// Runtime: 61ms, beats 68.59
	public int minDinstance(String word1, String word2){
		int m = word1.length(), n = word2.length();

		// we can consider convert word1 into word2, which means delete char from word2 = insert char into word1
		// dp[i][j]: the minimum number of operations to convert word1[0..i - 1] to word2[0..j - 1]
		int[][] dp = new int[m + 1][n + 1];

		// word1[0...i-1] convert to word2[0] = ""
		for(int i = 0; i <= m; i++){
			dp[i][0] = i;
		}
		// word1[0] = "" convert to word2[0...j-1] 
		for(int j = 0; j <= n; j++){
			dp[0][j] = j;
		}

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i-1][j] + 1, // delete word1[i - 1] and word1[0..i - 2] = word2[0..j - 1]
							   dp[i][j-1] + 1);  // insert word2[j - 1] to word1[0..i - 1] and word1[0..i - 1] + word2[j - 1] = word2[0..j - 1]
				}
			}
		}
		return dp[m][n];
	}

//---------------------------------------------------------------------
	// Optimization:
	// Time Complexity: O(MN), Space Complexity: O(N)
	// Runtime: 61ms, beats 68.59
	public int minDinstance2(String word1, String word2){
		int m = word1.length(), n = word2.length();
		int[] dp = new int[n + 1];

		for(int j = 0; j <= n; j++){
			dp[j] = j;
		}

		for(int i = 1; i <= m; i++){
			int pre = dp[0];
			dp[0] = i;
			for(int j = 1; j <= n; j++){
				int cur = dp[j];
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[j] = pre;
				}else{
					dp[j] = Math.min(dp[j] + 1, dp[j-1] + 1);
				}
				pre = cur;
			}
		}

		return dp[n];

	}

	public static void main(String[] args){
		String word1 = "sea", word2 = "eatE";
		LC583 x = new LC583();
		
		System.out.println(x.minDinstance2(word1, word2));
	}
}