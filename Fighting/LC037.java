/*
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
 */

public class LC037{
	// Time Complexity: O(9^N)
	// Runtime: 25ms, beats 68.13%
	public void solveSudoku(char[][] board){
		if(board == null || board.length == 0)
			return;
		int len = board.length;
		backtracking(board, len);
	}

	private boolean backtracking(char[][] board, int len){
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(board[i][j] == '.'){
					for(char ch = '1'; ch <= '9'; ch++){
						if(isValidSudoku(board, i, j, len, ch)){
							board[i][j] = ch;
						
						if(backtracking(board, len))
							return true;
						else
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidSudoku(char[][] board, int row, int col, int len, char ch){
		for(int i = 0; i < len; i++){
			if(board[i][col] != '.' && board[i][col] == ch)
				return false;
			if(board[row][i] != '.' && board[row][i] == ch)
				return false;
			int cubeRow = row / 3 * 3 + i / 3;
			int cubeCol = col / 3 * 3 + i % 3;
			if(board[cubeRow][cubeCol] != '.' && board[cubeRow][cubeCol] == ch)
				return false;
		}
		return true;
	}
}