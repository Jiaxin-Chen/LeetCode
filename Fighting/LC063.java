/*
63. Unique Paths II

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
*/

public class LC063{
	// Time Complexity: O(N^2), Space Complexity: O(N)
	// Runtime: 1ms, beats 17.49%
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[] cur = new int[n];
		cur[0] = 1;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(obstacleGrid[i][j] == 1){
					cur[j] = 0;
				}else if(j > 0){
					cur[j] += cur[j-1];
				}
			}
		}
		return cur[n-1];
	}

	// Time Complexity: O(N^2), Space Complexity: O(M)
	// Runtime: 2ms, beats 3.23%
	// Cache miss...
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] cur = new int[m];
        cur[0] = 1;
        
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                if(obstacleGrid[i][j] == 1){
                    cur[i] = 0;
                }else if(i > 0){
                    cur[i] += cur[i-1];
                }
            }
        }
        return cur[m-1];
    }

	public static void main(String[] args){
		int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		LC063 x = new LC063();
		int res = x.uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);
	}
}
