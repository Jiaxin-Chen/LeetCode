/*
419. Battleships in a Board

Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's,
 empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. 
In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.

Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
*/

class LC419 {
	// Time Complexity: O(MN), Space Complexity: O(1)
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return 0;
        }

        int count = 0;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                // because battleships are made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column),
                // and N is the any size, which means the continuous horizontal or vertical lines must be together.
                // Besides, no adjacent battleships allowed.
                if(i > 0 && board[i-1][j] == 'X'){
                    continue;
                }
                if(j > 0 && board[i][j-1] == 'X'){
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}