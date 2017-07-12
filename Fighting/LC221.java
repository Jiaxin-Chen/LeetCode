/*
221. Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */

public class LC221{
	// Time Complexity: O(N^2)
	// Runtime: 16ms, beats 11.13%
	public int maximalSquare(char[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length, n = matrix[0].length;
		// dp[i][j] is the length of the square whose lower-right corner is at (i,j) 
		int[][] dp = new int[m + 1][n + 1];
		int maxLen = 0;

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(matrix[i - 1][j - 1] == '1'){
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
					maxLen = Math.max(maxLen, dp[i][j]);
				}
			}
		}

		return maxLen * maxLen;
	}
}