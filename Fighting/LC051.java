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

public class LC051{
	// TLE..... when n = 9
	public List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<>();
		char[][] queens = new char[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				queens[i][j] = '.';
		backtracking(res, queens, 0, n);
		return res;
	}

	private void backtracking(List<List<String>> res, char[][] queens, int row, int n){
		if(row == n){
			List<String> solution = new ArrayList<>();
			for(int i = 0; i < n; i++){
				solution.add(String.valueOf(queens[i]));
			}
			res.add(solution);
		}else{
			for(int col = 0; col < n; col++){
				if(isValid(queens, row, col, n)){
					queens[row][col] = 'Q';
					backtracking(res, queens, row + 1, n);
					queens[row][col] = '.';
				}
			}
		}
	}

	private boolean isValid(char[][] queens, int row, int col, int n){
		//check if the column had a queen before.
		for(int i = 0; i < row; i++){
			if(queens[i][col] == 'Q')
				return false;
		}
		//check if the 45° diagonal had a queen before.
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
			if(queens[i][j] == 'Q')
				return false;
		}
		//check if the 135° diagonal had a queen before.
		for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
			if(queens[i][j] == 'Q')
				return false;
		}
		return true;
	}

	// TLE still...
	public List<List<String>> solveNQueens2(int n){
		List<List<String>> res = new ArrayList<>();
		char[][] queens = new char[n][n];
		boolean[] cols = new boolean[n];
		boolean[] diag45 = new boolean[2 * n - 1];
		boolean[] diag135 = new boolean[2 * n - 1];

		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				queens[i][j] = '.';
		backtracking(res, queens, 0, n, cols, diag45, diag135);
		return res;
	}

	private void backtracking(List<List<String>> res, char[][] queens, int row, int n, boolean[] cols, boolean[] diag45, boolean[] diag135){
		if(row == n){
			List<String> solution = new ArrayList<>();
			for(int i = 0; i < n; i++){
				solution.add(String.valueOf(queens[i]));
			}
			res.add(solution);
		}else{
			for(int col = 0; col < n; col++){
				if(!cols[col] && !diag45[row+col] && !diag135[n-1+col-row]){
					cols[col] = diag45[row+col] = diag135[n-1+col-row] = true;
					queens[row][col] = 'Q';
					backtracking(res, queens, row + 1, n, cols, diag45, diag135);
					queens[row][col] = '.';
					cols[col] = diag45[row+col] = diag135[n-1+col-row] = false;
				}
			}
		}
	}

	// Just change i++ to ++i and i < n to i != n, then pass the case n = 9.....
	// Time Complexity...
	// Runtime: 4ms, beats 97.06%
	public List<List<String>> solveNQueens2(int n){
		List<List<String>> res = new ArrayList<>();
		char[][] queens = new char[n][n];
		boolean[] cols = new boolean[n];
		boolean[] diag45 = new boolean[2 * n - 1];
		boolean[] diag135 = new boolean[2 * n - 1];

		for(int i = 0; i != n; ++i)
			for(int j = 0; j != n; ++j)
				queens[i][j] = '.';
		backtracking(res, queens, 0, n, cols, diag45, diag135);
		return res;
	}

	private void backtracking(List<List<String>> res, char[][] queens, int row, int n, boolean[] cols, boolean[] diag45, boolean[] diag135){
		if(row == n){
			List<String> solution = new ArrayList<>();
			for(int i = 0; i != n; ++i){
				solution.add(String.valueOf(queens[i]));
			}
			res.add(solution);
		}else{
				for(int col = 0; col != n; ++col){
				if(!cols[col] && !diag45[row+col] && !diag135[n-1+col-row]){
					cols[col] = diag45[row+col] = diag135[n-1+col-row] = true;
					queens[row][col] = 'Q';
					backtracking(res, queens, row + 1, n, cols, diag45, diag135);
					queens[row][col] = '.';
					cols[col] = diag45[row+col] = diag135[n-1+col-row] = false;
				}
			}
		}
	}

	public static void main(String[] args){
		int n = 9;
		LC051 x = new LC051();
		List<List<String>> res = x.solveNQueens2(n);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < n; j++)
				System.out.println(res.get(i).get(j));
			System.out.println();
		}
	}









}