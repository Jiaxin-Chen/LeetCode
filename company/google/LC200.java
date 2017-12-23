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
//*---------------------------------------------------------------------
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
		// Go through the corner cases
		if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		DFS(grid, i - 1, j, M, N);
		DFS(grid, i + 1, j, M, N);
		DFS(grid, i, j - 1, M, N);
		DFS(grid, i, j + 1, M, N);
	}

//*----------------------------------------------------------------------------
	// four direction for the current position to move towards
	int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public int numIslands2(char[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int M = grid.length, N = grid[0].length;
		int[] parents = new int[M * N];  // one island = one tree
		int count = 0;                   // number of islands 

		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(grid[i][j] == '1'){
					int idx = i * N + j;
					parents[idx] = idx;  // assume every '1' position is isolated island firstly
					count++;               // add new island
				}
			}
		}
		System.out.println(count);

		for(int i = 0; i < M; i++){
			for(int j = 0; j < N; j++){
				if(grid[i][j] == '1'){
					int idx = i * N + j;

					// Optimization 2: put out of the for loop
					int curRoot = getRoot(parents, idx);
					System.out.println("\npos["+i+"]["+j+"] = " + idx);
					for(int[] dir : directions){
						int x = i + dir[0];
						int y = j + dir[1];

						if(x >= 0 && x < M && y >= 0 && y < N && grid[x][y] == '1'){
							int neighborIdx = x * N + y;
							int neighborRoot = getRoot(parents, neighborIdx);
							//int curRoot = getRoot(parents, idx);
							System.out.println("neighborId["+x+"]["+y+"] = " + neighborIdx + ", neighborRoot = " + neighborRoot);
							
							// if curRoot != neighborRoot, we need union these two islands
							if(curRoot != neighborRoot){
								// Attention here! we should let parents[neighborRoot] = curRoot, not parents[neighborIdx] = curRoot
								// let neighborRoot points curRoot to union them
								parents[neighborRoot] = curRoot;
								count--;
								System.out.println("count = " + count + ", neighbor's curRoot = " + curRoot);
							}
						}
					}
				}
			}
		}
		return count;

	}

	// find the root of current idx by union find
	public int getRoot(int[] parents, int idx){
		while(parents[idx] != idx){
			// Optimization 1:
			parents[idx] = parents[parents[idx]]; // short the tree to reduce the runtime, not necessary
			idx = parents[idx];
		}
		return idx;
	}

	public static void main(String[] args){
		char[][] grid = {"111".toCharArray(), "010".toCharArray(), 
						 "111".toCharArray()};
		LC200 x = new LC200();
		System.out.println(x.numIslands2(grid));
	}
}