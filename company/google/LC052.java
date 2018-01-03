/*
52. N-Queens II

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

class LC052{
	// Time Complexity: O(2^N)
	// Runtime: 3ms, beats 70.98%
	public int totalNQueens(int n){
		if(n < 1){
			return 0;
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

		backtracking(queens, cols, diag45, diag135, 0, n);

		return count;
	}

	private int count = 0;

	
	/**    | | |                / / /             \\ \\ \\
  	  *    O O O               O O O               O O O
  	  *    | | |              / / / /             \\ \\ \\ \\
  	  *    O O O               O O O               O O O
  	  *    | | |              / / / /             \\ \\ \\ \\ 
  	  *    O O O               O O O               O O O
  	  *    | | |              / / /                 \\ \\ \\
  	  *   3 columns        5 45\xb0 diagonals     5 135\xb0 diagonals    (when n is 3)
    */
	private void backtracking(char[][] queens, boolean[] cols, boolean[] diag45, boolean[] diag135, int row, int n){
		if(row == n){
			count++;
			return;
		}

		for(int col = 0; col < n; col++){
			if(!cols[col] && !diag45[row + col] && !diag135[n - 1 + col - row]){
				cols[col] = diag45[row + col] = diag135[n - 1 + col - row] = true;
				queens[row][col] = 'Q';
				backtracking(queens, cols, diag45, diag135, row + 1, n);
				queens[row][col] = '.';
				cols[col] = diag45[row + col] = diag135[n - 1 + col - row] = false;
			}
		}
	}

	public static void main(String[] args){
		LC052 X = new LC052();
		int n = 4;
		System.out.println(X.totalNQueens(n));
	}
}