/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example:
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

public class LC079{
	// Time Complexity: O(M * N)
	// Runtime: 8ms, beats 96.29%
	public boolean exist(char[][] board, String word){
		char[] w = word.toCharArray();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(isExist(board, w, i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean isExist(char[][] board, char[] word, int i, int j, int index){
		if(index == word.length)
			return true;
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		if(board[i][j] != word[index])
			return false;

		// Utilize bit mask board[i][j] ^= 256 to disable the char letter to indicate it's used once.
		board[i][j] ^= 256;
		boolean found = isExist(board, word, i + 1, j, index + 1) ||
						isExist(board, word, i - 1, j, index + 1) ||
						isExist(board, word, i, j + 1, index + 1) ||
						isExist(board, word, i, j - 1, index + 1);
		// Set board[i][j] ^= 256 to make it become a valid letter again.
		board[i][j] ^= 256; 

		return found;
	}


	public static void main(String[] args){
		char[][] board = {  {'A','B','C','E'},
  							{'S','F','C','S'},
  							{'A','D','E','E'}	};
  		String word = "ABFSADECSED";
  		LC079 x = new LC079();
  		boolean res = x.exist(board, word);
  		System.out.println(res);
  	}
}
