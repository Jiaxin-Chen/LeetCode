/*
52. N-Queens II

Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.
 */

import java.util.*;

public class LC052{
	// Time Complexity:...
	// Runtime: 3ms, beats 77.83%
	public int totalNQueens(int n){
		List<List<String>> solutions = new ArrayList<>();
		char[][] queens = new char[n][n];
		boolean[] cols = new boolean[n];
		boolean[] diag45 = new boolean[2 * n - 1];
		boolean[] diag135 = new boolean[2 * n - 1];

		for(int i = 0; i != n; ++i){
			for(int j = 0; j != n; ++j)
				queens[i][j] = '.';
		}

		backtracking(solutions, queens, 0, n, cols, diag45, diag135);
		return solutions.size();
	}

	private void backtracking(List<List<String>> solutions, char[][] queens, int row, int n, boolean[] cols, boolean[] diag45, boolean[] diag135){
		if(row == n){
			List<String> res = new ArrayList<>();
			for(int i = 0; i != n; ++i)
				res.add(String.valueOf(queens[i]));
			solutions.add(res);
		}else{
			for(int col = 0; col != n; ++col){
				if(!cols[col] && !diag45[row + col] && !diag135[n - 1 + row - col]){
					cols[col] = diag45[row + col] = diag135[n - 1 + row - col] = true;
					queens[row][col] = 'Q';
					backtracking(solutions, queens, row + 1, n, cols, diag45, diag135);
					queens[row][col] = '.';
					cols[col] = diag45[row + col] = diag135[n - 1 + row - col] = false;
				}

			}
		}
	}


	public static void main(String[] args){
		int n = 9;
		LC052 x = new LC052();
		System.out.println(x.totalNQueens(n));
	}
}