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

class LC221{
	// Time Complexity: O(MN), Space Complexity: O(MN)
	// Runtime: 14ms, beats 64.27%
	public int maximalSquare(char[][] matrix){
		if(matrix.length == 0){
			return 0;
		}

		int m = matrix.length, n = matrix[0].length;
		int maxLen = 0;

		// dp[i][j] indicates take the point (i, j) as the lower-right corner, the maximal length we can get
		int[][] dp = new int[m][n];

		for(int i = 0; i < m; i++){

			dp[i][0] = matrix[i][0] - '0';  // initialized dp[i][0]
			maxLen = Math.max(maxLen, dp[i][0]);  // corner case: ["1", "0"]
			for(int j = 1; j < n; j++){
				if(i == 0){
					dp[0][j] = matrix[0][j] - '0';  // initialized dp[0][j]
				}
				else{
					if(matrix[i][j] == '1'){
						dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
					}else{
						dp[i][j] = 0;
					}
				}
				maxLen = Math.max(maxLen, dp[i][j]);
			}
		}
		return maxLen * maxLen;
	}

//----------------------------------------------------------------------------------------------------
	// Optimization
	// Time Complexity: O(MN), Space Complexity: O(N)
	// Runtime: 18ms, beats 16.28%
	public int maximalSquare2(char[][] matrix){
		if(matrix.length == 0){
			return 0;
		}

		int m = matrix.length, n = matrix[0].length;
		int maxLen = 0;

		// dp[i][j] indicates take the point (i, j) as the lower-right corner, the maximal length we can get
		int[][] dp = new int[2][n];

		for(int i = 0; i < m; i++){
			dp[i % 2][0] = matrix[i][0] - '0';
			maxLen = Math.max(maxLen, dp[i % 2][0]);
			for(int j = 1; j < n; j++){
				if(i == 0){
					dp[0][j] = matrix[0][j] - '0';
				}else{
					if(matrix[i][j] == '1'){
						dp[i % 2][j] = Math.min(Math.min(dp[(i-1) % 2][j-1], dp[(i-1) % 2][j]), dp[i % 2][j-1]) + 1;
					}else{
						dp[i % 2][j] = 0;
					}
				}
				maxLen = Math.max(maxLen, dp[i % 2][j]);
			}
		}
		return maxLen * maxLen;
	}

	public static void main(String[] args){
		char[][] matrix = new char[][]{"10110".toCharArray(), "10111".toCharArray(), "11111".toCharArray(), "10010".toCharArray()};
		LC221 x = new LC221();
		System.out.println(x.maximalSquare(matrix));
	}
}