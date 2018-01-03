/*
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

import java.util.*;

class LC051{
	// Time Complexity: O(2^(N*N))
	// Runtime: 6ms, beats 85.81%
	public List<List<String>> solveNQueens(int n){
		List<List<String>> res = new LinkedList<>();
		if(n < 1){
			return res;
		}
		char[][] queens = new char[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				queens[i][j] = '.';
			}
		}
		backtracking(res, queens, 0, n);
		return res;
	}

	private void backtracking(List<List<String>> res, char[][] queens, int row,  int n){
		if(row == n){
			List<String> list = new LinkedList<>();
			for(int i = 0; i < n; i++){
				list.add(String.valueOf(queens[i]));
			}
			res.add(new LinkedList<String>(list));
			return;
		}
		for(int col = 0; col < n; col++){
			if(isValid(queens, row, col, n)){
				queens[row][col] = 'Q';
				backtracking(res, queens, row + 1,  n);
				queens[row][col] = '.';
			}
		}
	}

	private boolean isValid(char[][] queens, int row, int col, int n){
		// check each col
		for(int i = 0; i < row; i++){
			if(queens[i][col] == 'Q'){
				return false;
			}
		}
		// check each diag 45
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
			if(queens[i][j] == 'Q'){
				return false;
			}
		}
		// check each diag 135
		for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
			if(queens[i][j] == 'Q'){
				return false;
			}
		}
		return true;
	}

//-------------------------------------------------------------------------
	// Bit mask
	// Time Complexity: O(2^(N^N))
	public List<List<String>> solveNQueens2(int n){
		List<List<String>> res = new LinkedList<>();
		if(n < 1){
			return res;
		}
		char[][] queens = new char[n][n];
		boolean[] cols = new boolean[n];
		boolean[] diag45 = new boolean[2 * n - 1];
		boolean[] diag135 = new boolean[2 * n - 1];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				queens[i][j] = '.';
			}
		}

		backtracking2(res, queens, cols, diag45, diag135, 0, n);

		return res;
	}

	/**    | | |                / / /             \\ \\ \\
  	  *    O O O               O O O               O O O
  	  *    | | |              / / / /             \\ \\ \\ \\
  	  *    O O O               O O O               O O O
  	  *    | | |              / / / /             \\ \\ \\ \\ 
  	  *    O O O               O O O               O O O
  	  *    | | |              / / /                 \\ \\ \\
  	  *   3 columns        5 45\xb0 diagonals     5 135\xb0 diagonals    (when n is 3)
    */
	private void backtracking2(List<List<String>> res, char[][] queens, boolean[] cols, boolean[] diag45, boolean[] diag135, int row, int n){
		if(row == n){
			List<String> list = new LinkedList<>();
			for(int i = 0; i < n; i++){
				list.add(String.valueOf(queens[i]));
			}
			res.add(new LinkedList<String>(list));
			return;
		}

		for(int col = 0; col < n; col++){
			if(!cols[col] && !diag45[row + col] && !diag135[n - 1 + col - row]){
				cols[col] = diag45[row + col] = diag135[n - 1 + col - row] = true;
				queens[row][col] = 'Q';
				backtracking2(res, queens, cols, diag45, diag135, row + 1, n);
				queens[row][col] = '.';
				cols[col] = diag45[row + col] = diag135[n - 1 + col - row] = false;
			}
		}
	}

	public static void main(String[] args){
		LC051 x = new LC051();
		int n = 5;
		List<List<String>> res = x.solveNQueens2(n);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.println(res.get(i).get(j));
			System.out.println();
		}
		
	}
}