/*
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
11110
11010
11000
00000
Answer: 1

Example 2:
11000
11000
00100
00011
Answer: 3
 */

public class LC200{
	// Time Complexity: O(MN)
	// Runtime: 2ms, beats 93.96%
	public int numIslands(char[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
		int M = grid.length, N = grid[0].length;
		int count = 0;
		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(grid[i][j] == '1'){
					DFS(grid, i, j, M, N);
					count++;
				}
			}
		}
		return count;
	}

	private void DFS(char[][] grid, int i, int j, int M, int N){
		if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		DFS(grid, i - 1, j, M, N);
		DFS(grid, i + 1, j, M, N);
		DFS(grid, i, j - 1, M, N);
		DFS(grid, i, j + 1, M, N);
	}

	public static void main(String[] args){
		char[][] grid = {"11110".toCharArray(), "11010".toCharArray(), 
						 "11000".toCharArray(), "00100".toCharArray()};
		LC200 x = new LC200();
		System.out.println(x.numIslands(grid));
	}
}