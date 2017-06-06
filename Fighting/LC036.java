/*
36. Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class LC036{
	// Time Complexity: O(N^2)
	// Runtime: 29ms, beats 90.86%
	public boolean isValidSudoku(char[][] board){
		int len = board.length;
		boolean[][] rows = new boolean[len][len];
		boolean[][] cols = new boolean[len][len];
		boolean[][] cube = new boolean[len][len];

		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				if(board[i][j] != '.'){
					int idx = board[i][j] - '0' - 1;
					int k = i / 3 * 3 + j / 3;
					if(rows[i][idx] || cols[j][idx] || cube[k][idx])
						return false;
					rows[i][idx] = cols[j][idx] = cube[k][idx] = true;
				}
			}
		}
		return true;
	}

	// Time Complexity: O(N^2)
	// Runtime: 38ms, beats 35.15%
	public boolean isValidSudoku2(char[][] board) {
    	for(int i = 0; i<9; i++){
        	HashSet<Character> rows = new HashSet<Character>();
       	 	HashSet<Character> columns = new HashSet<Character>();
        	HashSet<Character> cube = new HashSet<Character>();
        	for (int j = 0; j < 9;j++){
         	   if(board[i][j]!='.' && !rows.add(board[i][j]))
          	    	return false;
            	if(board[j][i]!='.' && !columns.add(board[j][i]))
             	   return false;
           		int RowIndex = 3*(i/3);
            	int ColIndex = 3*(i%3);
            	if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                	return false;
        	}
    	}
    	return true;
	}

	public static void main(String[] args){
		char[][] board = {{".87654321"}, {"2........"}, {"3........"},
						  {"4........"}, {"5........"}, {"6........"},
						  {"7........"}, {"8........"}, {"9........"}};
		LC036 x= new LC036();
		System.out.println(x.isValidSudoku(board));
	}
}