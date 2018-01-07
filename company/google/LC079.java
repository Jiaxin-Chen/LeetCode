/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

class LC079{
	// Time Complexity: O(mn), Space complexity: O(N)
	// Runtime: 16ms, beats 61.87%
	public boolean exist(char[][] board, String word){
		if(board == null || board.length == 0 || board[0].length == 0){
			return false;
		}
		boolean[][] used = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(dfs(board, word, used, i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}

	// Time Complexity: O(4^k)
	private boolean dfs(char[][] board, String word, boolean[][] used, int i, int j, int idx){
		if(idx == word.length()){
			return true;
		}
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || word.charAt(idx) != board[i][j]){
			return false;
		}
		used[i][j] = true;
		boolean isExist = dfs(board, word, used, i + 1, j, idx + 1) ||
						  dfs(board, word, used, i - 1, j, idx + 1) ||
						  dfs(board, word, used, i, j + 1, idx + 1) ||
						  dfs(board, word, used, i, j - 1, idx + 1);
		used[i][j] = false;

		return isExist;
	}

//---------------------------------------------------------------------------------------------------------------
	// Space Optimization:
	// Time Complexity: O(MN 4^k), Space complexity: O(1)
	// Runtime: 16ms, beats 61.87%
	public boolean exist2(char[][] board, String word){
		if(board == null || board.length == 0 || board[0].length == 0){
			return false;
		}
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(dfs2(board, word, i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs2(char[][] board, String word, int i, int j, int idx){
		if(idx == word.length()){
			return true;
		}
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(idx) != board[i][j]){
			return false;
		}

		// Perform a bitwise OR assignment to mark the current cell as visited.
        // The bitwise OR of any character will not be the letter which is
        // currently being looked for.
		board[i][j] ^= 256;
		boolean isExist = dfs2(board, word, i + 1, j, idx + 1) ||
						  dfs2(board, word, i - 1, j, idx + 1) ||
						  dfs2(board, word, i, j + 1, idx + 1) ||
						  dfs2(board, word, i, j - 1, idx + 1);
		// Perform a bitwise OR assignment to revert the visited cells to the
        // letter they held previously.  OR(OR(X)) = X
		board[i][j] ^= 256;

		return isExist;
	}

	public static void main(String[] args){
		LC079 x = new LC079();
		char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCCED";
		System.out.println(x.exist2(board, word));
	}
}