/*
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
*/

class LC064{
	// Time Complexity: O(MN), Space Complexity: O(MN)
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
        	return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for(int i = 1; i < m; i++){
        	dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int j = 1; j < n; j++){
        	dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        	}
        }
        return dp[m-1][n-1];
    }

//------------------------------------------------------------------------
    // Time Complexity: O(MN), Space Complexity: O(1)
	public int minPathSum2(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
        	return 0;
        }
        int m = grid.length, n = grid[0].length;

        for(int i = 1; i < m; i++){
        	grid[i][0] += grid[i-1][0];
        }
        for(int j = 1; j < n; j++){
        	grid[0][j] += grid[0][j-1];
        }

        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        	}
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args){
    	LC064 obj = new LC064();
    	int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    	System.out.println(obj.minPathSum2(grid));
    }
}