/*
305. Number of Islands II
A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]
*/

import java.util.*;


class LC305{
	// Time Complexity: O(klogmn), Space Complexity: O(MN)
	// Runtime: 18ms, beats 72.66% 

	// four direction for the current position to move towards
	int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public List<Integer> numIslands(int m, int n, int[][] positions){
		List<Integer> res = new ArrayList<>();
		if(positions == null || positions.length == 0 || positions[0].length == 0){
			return res;
		}

		int[] parents = new int[m * n];
		Arrays.fill(parents, -1);
		int count = 0;

		for(int k = 0; k < positions.length; k++){
			int i = positions[k][0];
			int j = positions[k][1];
			int idx = i * n + j;
			int curRoot = idx;      // let curRoot equals to the idx
			parents[idx] = curRoot; // assume every '1' position is isolated island firstly
			count++;                // add new island

			for(int[] dir : directions){
				int x = i + dir[0];
				int y = j + dir[1];
				int neighborIdx = x * n + y;

				// x, y must be in the matrix range
				// parents[neighborIdx] != -1 indicates grid[x][y] = '1'
				if(x >= 0 && x < m && y >= 0 && y < n && parents[neighborIdx] != -1){
					int neighborRoot = getRoot(parents, neighborIdx);

					// if curRoot != neighborRoot, we need union these two islands
					if(curRoot != neighborRoot){
						// let neighborRoot points curRoot to union them
						parents[neighborRoot] = curRoot;
						count--;
					}
				}
			}
			res.add(count);
		}

		return res;
	}

	// find the root of current idx by union find
	private int getRoot(int[] parents, int idx){
		while(idx != parents[idx]){
			// Optimization 1:
			parents[idx] = parents[parents[idx]]; // short the tree to reduce the runtime, not necessary
			idx = parents[idx];
		}
		return idx;
	}

	public static void main(String[] args){
		//int m = 3, n = 3;
		//int[][] positions = {{0, 1}, {2, 1}, {1, 2}, {1, 0}, {1, 1}};
		int m = 8, n = 2;
		int[][] positions = {{7, 0}};
		LC305 x = new LC305();
		List<Integer> res = x.numIslands(m, n, positions);

		System.out.println("******");
		System.out.println(res);
		
	}


}