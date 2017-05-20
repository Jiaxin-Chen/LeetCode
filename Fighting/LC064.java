/*
64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: 
You can only move either down or right at any point in time.
*/

public class LC064{

	// Time Complexity: O(N^2)
	// Runtime: 3ms, beats 87.69%
	public int minPathSum(int[][] grid){
		int m = grid.length, n = grid[0].length;

		if(grid.length == 0){
			return -1;
		}

		int[] cur = grid[0];
		for(int j = 1; j < n; j++){
			cur[j] += cur[j-1];
		}

		for(int i = 1; i < m; i++){
			cur[0] += grid[i][0];
			for(int j = 1; j < n; j++){
				cur[j] = Math.min(cur[j-1], cur[j]) + grid[i][j];
			}
		}
		return cur[n-1];
	}

	public static void main(String[] args){
		int[][] grid = {{3, 6, 2}, {1, 5, 0}, {4, 3, 8}};
		LC064 x = new LC064();
		int res = x.minPathSum(grid);
		System.out.println(res);
	}
}