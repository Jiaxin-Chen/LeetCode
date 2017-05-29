/*
289. Game of Life

According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? 
Remember that the board needs to be updated at the same time: 
You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. 
In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. 
How would you address these problems?
*/

public class LC289{
	/* 
		In the beginning, every cell is either 00 or 01.
		Notice that 1st state is independent of 2nd state.
		Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
		Let's count # of neighbors from 1st state and set 2nd state bit.
		Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
		In the end, delete every cell's 1st state by doing >> 1.
	*/

	// Time Complexity: O(N^2)
	// Runtime: 1ms, beats 12.00%
	public void gameOfLife(int[][] board){
		if(board.length == 0)
			return;

		int m = board.length, n = board[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int lives = getLiveNeighbors(board, m, n, i, j);

				if(board[i][j] == 1 && (lives == 2 || lives == 3))
					// Make the 2nd bit 1: 01 ---> 11
					board[i][j] = 3;

				if(board[i][j] == 0 && lives == 3)
					// Make the 2nd bit 1: 00 ---> 10
					board[i][j] = 2;
			}
		}

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				// Get the next state
				board[i][j] >>= 1;
			}
		}
	}

	private int getLiveNeighbors(int[][] board, int m, int n, int i, int j){
		int live = 0;
		for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++){
			for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++){
				// Get the current state
				live += board[x][y] & 1;
			}
		}
		live -= board[i][j] & 1;
		return live;
	}

	public static void main(String[] args){
		int[][] board = {{0, 0, 1, 1, 0}, {1, 0, 1, 1, 0}, {1, 1, 0, 0, 0}};
		LC289 x = new LC289();
		x.gameOfLife(board);

	}
}