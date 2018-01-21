/*
289. Game of Life
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
1. Could you solve it in-place? Remember that the board needs to be updated at the same time: 
You cannot update some cells first and then use their updated values to update other cells.
2. In this question, we represent the board using a 2D array. 
In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. 
How would you address these problems?
*/

/*
To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 

In the beginning, every cell is either 00 or 01.
Notice that 1st state is independent of 2nd state.
Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
Let's count # of neighbors from 1st state and set 2nd state bit.
Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
In the end, delete every cell's 1st state by doing >> 1.
For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
Transition 00 -> 10: when board == 0 and lives == 3.
*/

class LC289{
	// Time Complexity: O(MN), Space Complexity: O(1)
	// Runtime: 1ms, beats 12.31%
	public void gameOfLife(int[][] board){
		if(board == null || board.length == 0 || board[0].length == 0){
			return;
		}

		int m = board.length, n = board[0].length;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				int liveNum = getLiveNum(board, i, j);
				if(board[i][j] == 0 && liveNum == 3){
					// we cannot set the board[i][j] = 1 directly because we need update all the values at the same time
					board[i][j] = 2;   
				}else if(board[i][j] == 1 && (liveNum == 2 || liveNum == 3)){
					board[i][j] = 3;
				}
			}
		}

		// update the next state at the same time
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				board[i][j] >>= 1;
			}
		}
	}

	private int getLiveNum(int[][] board, int row, int col){
		int liveNum = 0;
		int m = board.length, n = board[0].length;

		for(int i = Math.max(0, row - 1); i <= Math.min(m - 1, row + 1); i++){
			for(int j = Math.max(0, col - 1); j <= Math.min(n - 1, col + 1); j++){

				// get the current state
				liveNum += board[i][j] & 1;
			}
		}
		liveNum -= board[row][col] & 1;
		return liveNum;
	}


	//-------------------------------------------------------------------------
	// Follow up:
	// If it's an infinite board, we can represent the board as a set of live cell cordinates
	 private Set<Coord> gameOfLife(Set<Coord> live) {
        Map<Coord,Integer> neighbours = new HashMap<>();
        for (Coord cell : live) {
            for (int i = cell.i-1; i<cell.i+2; i++) {
                for (int j = cell.j-1; j<cell.j+2; j++) {
                    if (i==cell.i && j==cell.j) continue;
                    Coord c = new Coord(i,j);
                    if (neighbours.containsKey(c)) {
                        neighbours.put(c, neighbours.get(c) + 1);
                    } else {
                        neighbours.put(c, 1);
                    }
                }
            }
        }
        Set<Coord> newLive = new HashSet<>();
        for (Map.Entry<Coord,Integer> cell : neighbours.entrySet())  {
            if (cell.getValue() == 3 || cell.getValue() == 2 && live.contains(cell.getKey())) {
                newLive.add(cell.getKey());
            }
        }
        return newLive;
    }

	// The Coord is:
    private static class Coord {
        int i;
        int j;
        private Coord(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public boolean equals(Object o) {
            return o instanceof Coord && ((Coord)o).i == i && ((Coord)o).j == j;
        }
        public int hashCode() {
            int hashCode = 1;
            hashCode = 31 * hashCode + i;
            hashCode = 31 * hashCode + j;
            return hashCode;
        }
    }
 //The wrapper:
    public void gameOfLife(int[][] board) {
        Set<Coord> live = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == 1) {
                    live.add(new Coord(i,j));
                }
            }
        };
        live = gameOfLife(live);
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                board[i][j] = live.contains(new Coord(i,j))?1:0;
            }
        };
        
    }

	

}