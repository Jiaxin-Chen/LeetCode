/*
174. Dungeon Game

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. 
Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 
if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2(K)  -3	3
 -5	  -10	1
 10	   30  -5(P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */

public class LC174{
	// Time Complexity: O(mn)
	// Runtime: 3ms, beats 66.82%
	public int calculateMinimumHP(int[][] dungeon){
		int M = dungeon.length, N = dungeon[0].length;
		int[][] dp = new int[M+1][N+1];

		for(int i = 0; i <= M; i++){
			for(int j = 0; j <= N; j++)
				dp[i][j] = Integer.MAX_VALUE;
		}

		dp[M][N - 1] = 1;
		dp[M - 1][N] = 1;

		for(int i = M - 1; i >=0; i--){
			for(int j = N - 1; j >= 0; j--){
				int cur = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
				dp[i][j] = cur <= 0 ? 1 : cur;
				System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args){
		int[][] dungeon = {
							{-2, -3, 3}, 
							{-5, -10, 1},
							{10, 30, -5}
						  };

		LC174 x = new LC174();
		System.out.println(x.calculateMinimumHP(dungeon));
	}
}