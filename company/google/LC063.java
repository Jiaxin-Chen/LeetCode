/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

class LC063 {
	// Time Complexity: O(MN), Space Complexity: O(MN)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 ){
            return 0;
        }
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i = 1; i < m; i++){
            dp[i][0] = (obstacleGrid[i][0] == 1) ? 0 : dp[i-1][0];
        }
        
        for(int j = 1; j < n; j++){
            dp[0][j] = (obstacleGrid[0][j] == 1) ? 0 : dp[0][j-1];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = (obstacleGrid[i][j] == 1) ? 0 : dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    //--------------------------------------------------------------------------------
    // Optimization: 
    // Time Complexity: O(MN), Space Complexity: O(N)
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 ){
            return 0;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(obstacleGrid[i][j] == 1){
        			dp[j] = 0;
        		}else if(j > 0){
        			dp[j] += dp[j-1];
        		}
        	}
        }
        return dp[n-1];
    }

    public static void main(String[] args){
    	LC063 x = new LC063();
    	//int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
    	int[][] obstacleGrid = new int[][]{{0,0},{1,0}};
    	System.out.println(x.uniquePathsWithObstacles2(obstacleGrid));
    }
}