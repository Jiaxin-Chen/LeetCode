/*
62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

class LC062{
	// Time Complexity: O(MN), Space Complexity: O(MN)
	// Runtime: 1ms, beats 4.95%
	public int uniquePaths(int m, int n){
		if(m < 0 || n < 0){
			return 0;
		}

		int[][] dp = new int[m][n];

		// Because only for horizontal path, the path number should be 1
		for(int i = 0; i < m; i++){
			dp[i][0] = 1;
		}
		// only for the vertical path, the path number should be 1
		for(int j = 0; j < n; j++){
			dp[0][j] = 1;
		}

		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}

//--------------------------------------------------------
	// Optimization: Space
	// Time Complexity: O(MN), Space Complexity: O(N)
	public int uniquePaths2(int m, int n){
		if(m < 0 || n < 0){
			return 0;
		}

		int[] dp = new int[n];

		for(int j = 0; j < n; j++){
			dp[j] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				dp[j] += dp[j-1];
			}
		}
		return dp[n-1];
	}

	public static void main(String[] args){
		LC062 x = new LC062();

		int m = 3, n = 7;

		System.out.println(x.uniquePaths2(m, n));
	}
}
