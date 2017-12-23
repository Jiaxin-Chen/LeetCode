/*
130. Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

import java.util.*;

public class LC130{
	// Time Complexity: O(MN), Space Complexity: O(1)
	// Runtime: 0ms, beats 40.12%

	public void solve(char[][] board){
		// Corner case: board length < 3 can return board directly
		if(board == null || board.length < 3 || board[0].length < 3){
			return;
		}

		int m = board.length, n = board[0].length;

		// Step 1: keep the 'O' in the boundary and the position in the middle related to 'O' into '1'
		// handle the most left and right boundary
		for(int i = 0; i < m; i++){
			DFS(i, 0, m, n, board);
			DFS(i, n - 1, m, n, board);
		}
		// handle the most top and bottom boundary
		for(int j = 0; j < n; j++){
			DFS(0, j, m, n, board);
			DFS(m - 1, j, m, n, board);
		}

		// Step 2: flip the 'O' in the middle of board into 'X'
		for(int i = 1; i < m - 1; i++){
			for(int j = 1; j < n - 1; j++){
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}

		// Step 3: flip the '1' in the four boundaries and their related position's '1' back to 'O'
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(board[i][j] == '1'){
					board[i][j] = 'O';
				}
			}
		}
	}


	private void DFS(int i , int j, int m, int n, char[][] board){
		// Step 1: keep the 'O' in the boundary and the position in the middle related to 'O' into '1'
		if(board[i][j] == 'O'){
			board[i][j] = '1';
			if(i < m - 1)
				DFS(i + 1, j, m, n, board);
			if(i > 1)
				DFS(i - 1, j, m, n, board);
			if(j < n - 1)
				DFS(i, j + 1, m, n, board);
			if(j > 1)
				DFS(i, j - 1, m, n, board);
		}
	}

//-----------------------------------------------------------------------------
// Time Complexity: O()
// Actually failed for large cases...
	int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public void solve2(char[][] board){
		// Corner case: board length < 3 can return board directly
		if(board == null || board.length < 3 || board[0].length < 3){
			return;
		}

		// Step 1: build the parents tree 
		int m = board.length, n = board[0].length;
		int[] parents = new int[m * n + 1];
		parents[m * n] = m * n;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int idx = i * n + j;
				// let the boundary position points to m * n dummy node
				if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
					parents[idx] = m * n;
				}else{
					parents[idx] = idx;
				}
				
			}
		}
		
		// Step 2: 
		for(int i = 1; i < m-1; i++){
			for(int j = 1; j < n-1; j++){
				if(board[i][j] == 'O'){

					int idx = i * n + j;
					int curRoot = getRoot(parents, idx, m, n);
					//System.out.println("\nidx[" + i + "][" + j + "] = " + idx);
					//System.out.println("curRoot = " + curRoot);

					// Go through four directions
					for(int[] dir : directions){
						int x = i + dir[0];
						int y = j + dir[1];
							
						if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'){
							int neighborIdx = x * n + y;
							int neighborRoot = getRoot(parents, neighborIdx, m, n);
							//System.out.println("neighborIdx["+x+"]["+y+"] = " + neighborIdx + ", neighborRoot = " + neighborRoot);

							// If the neighborRoot points to the dummy node, set the neighborIdx and idx points to the dummy node 
							if(neighborRoot == m * n){
								parents[idx] = m * n;
								parents[neighborIdx] = m * n;
							// Else set the neighborRoot points to curRoot
							}else{
								if(neighborRoot != curRoot){
									parents[neighborRoot] = curRoot;
								}
							}
						}
					}
				}
				
			}
		}

		// Step 3: flip the 'O' in the middle of board into 'X'
		for(int i = 1; i < m - 1; i++){
			for(int j = 1; j < n - 1; j++){
				if(board[i][j] == 'O' && parents[i * n + j] != m * n){
					board[i][j] = 'X';
				}
			}
		}
	}

	private int getRoot(int[] parents, int idx, int m, int n){
		while(idx != parents[idx]){
			parents[idx] = parents[parents[idx]]; // path compression
			if(idx == m * n){
				break;
			}
			idx = parents[idx];
		}
		return idx;
	}


	public static void main(String[] args){
		char[][] board= {"OXXOX".toCharArray(), "XOOXO".toCharArray(), "XOXOX".toCharArray(), "OXOOO".toCharArray(), "XXOXO".toCharArray()};

		LC130 x = new LC130();
		x.solve2(board);

		for(int i = 0; i < board.length; i++){
			System.out.println(board[i]);
		}
	}
}