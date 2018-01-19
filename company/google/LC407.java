/*
407. Trapping Rain Water II

Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]
Return 4.

The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.

After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
*/

import java.util.*;

class LC407{
	// PriorityQueue, BFS
	// Time Complexity: O(MN)
	// Runtime: 105ms, beats 13.98%
	class Cell{
		int row;
		int col;
		int height;
		Cell(int r, int c, int h){
			row = r;
			col = c;
			height = h;
		}
	}

	public int trapRainWater(int[][] heightMap){
		if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2){
			return 0;
		}

		int m = heightMap.length, n = heightMap[0].length;
		boolean[][] visited = new boolean[m][n];
		PriorityQueue<Cell> queue = new PriorityQueue<>(m + n, (a, b) -> (a.height - b.height));

		for(int j = 0; j < n; j++){
			visited[0][j] = true;
			visited[m-1][j] = true;
			queue.offer(new Cell(0, j, heightMap[0][j]));
			queue.offer(new Cell(m - 1, j, heightMap[m-1][j]));
		}
		for(int i = 1; i < m - 1; i++){
			visited[i][0] = true;
			visited[i][n-1] = true;
			queue.offer(new Cell(i, 0, heightMap[i][0]));
			queue.offer(new Cell(i, n - 1, heightMap[i][n-1]));
		}

		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int res = 0;

		// from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
       // add all its neighbors to the queue.
		while(!queue.isEmpty()){
			Cell cell = queue.poll();
			for(int[] dir : directions){			
				int x = cell.row + dir[0];
				int y = cell.col + dir[1];

				if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
					visited[x][y] = true;
					res += Math.max(0, cell.height - heightMap[x][y]);
					queue.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
				}
			}
		}
		return res;
		
	}

	public static void main(String[] args){
		LC407 x = new LC407();
		int[][] heightMap = new int[][]{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		System.out.println(x.trapRainWater(heightMap));

	}
}