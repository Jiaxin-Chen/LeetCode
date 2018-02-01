/*
463. Island Perimeter

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
*/

class LC463{
	// Time Complexity: O(MN)
	// Runtime: 168ms, beats 32.78%
	public int islandPerimeter(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		int count = 0;
		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
 				if(grid[i][j] == 1){
 					for(int[] dir : directions){
 						int x = i + dir[0];
 						int y = j + dir[1];
 						// attention to the corner case here
 						if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0){
 							count++;
 						}
 					}
 				} 
			}
		}
		return count;
	}

	//-----------------------------------------------------------------------------------------------
	// DFS
	// Time Complexity: O(MN)
	public int islandPerimeter2(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}

		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
					return dfs(grid, directions, i, j);
				}
			}
		}
		return 0;
	}


	private int dfs(int[][] grid, int[][] directions, int i, int j){
		int count = 0;
		grid[i][j] = -1;

		for(int[] dir : directions){
			int x = i + dir[0];
			int y = j + dir[1];
			if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0){
				count++;
			}else{
				if(grid[x][y] == 1){
					count += dfs(grid, directions, x, y);
				}
			}
		}
		return count;
	}

	public static void main(String[] args){
		LC463 obj = new LC463();
		int[][] grid = new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
		System.out.println(obj.islandPerimeter2(grid));
	}
}