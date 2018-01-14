/*
72. Edit Distance

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

class LC072{

	// Time Complexity: O(MN), Space Complexity: O(MN)
	// Runtime: 16ms, beats 27.60%
	public int minDistance(String word1, String word2){
		int m = word1.length(), n = word2.length();

		// dp[i][j]: the minimum number of operations to convert word1[0..i - 1] to word2[0..j - 1]
		int[][] dp = new int[m+1][n+1];

		for(int i = 0; i <= m; i++){
			dp[i][0] = i;
		}
		for(int j = 0; j <= n; j++){
			dp[0][j] = j;
		}

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i-1][j-1] + 1, // replace word1[i - 1] by word2[j - 1]
							   Math.min(dp[i][j-1] + 1,   // insert word2[j - 1] to word1[0..i - 1] and word1[0..i - 1] + word2[j - 1] = word2[0..j - 1]
							   			dp[i-1][j] + 1)); // delete word1[i - 1] and word1[0..i - 2] = word2[0..j - 1]
				}
			}
		}
		return dp[m][n];
	}

	//---------------------------------------------------------------------------------------
	// Optimization:
	// Time Complexity: O(MN), Space Complexity: O(N)
	// Runtime: 16ms, beats 27.60%
	public int minDistance2(String word1, String word2){
		int m = word1.length(), n = word2.length();

		int[] dp = new int[n + 1];

		for(int j = 0; j <= n; j++){
			dp[j] = j;
		}

		for(int i = 1; i <= m; i++){
			int pre = dp[0];  // actually is dp[i-1][j-1]
			dp[0] = i;
			for(int j = 1; j <= n; j++){
				int cur = dp[j];
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[j] = pre;
				}else{
					dp[j] = Math.min(pre, Math.min(dp[j-1], dp[j])) + 1; // dp[j-1] is dp[i][j-1], dp[j] is dp[i-1][j]
				}
				pre = cur;
			}
		}
		return dp[n];
	}

	public static void main(String[] args){
		String word1 = "abcd", word2 = "ecd";

		LC072 x = new LC072();
		System.out.println(x.minDistance2(word1, word2));
	}
}