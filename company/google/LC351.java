/*
351. Android Unlock Patterns

Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.
*/

class LC351{
	// Time Complexity: O()???
	// O(3 * sigma(i = m to n) ((8!) / (9 - i)!)), but not very precise. Starting from 5, we have 8 choices. 
	// After we choose one number as our next step, suppose 3, we have 7 choices remaining. 
	// Then we have 6 remaining, we keep this procedure until we reach step i. The search tree is of size (8!) / (9 - i)!
	// Runtime: 14ms, beats 50.00%
	public int numberOfPatterns(int m, int n){

		// Step 1: Skip array represents number to skip between two pairs
		int skip[][] = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

		// Step 2: DFS search each length from m to n
		int res = 0;
		boolean[] used = new boolean[10];
		for(int i = m; i <= n; i++){
			res += dfs(skip, used, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
			res += dfs(skip, used, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
			res += dfs(skip, used, 5, i - 1);     // 5
		}
		return res;
	}

	private int dfs(int[][] skip, boolean[] used, int num, int remain){
		if(remain < 0){
			return 0;
		}
		if(remain == 0){
			return 1;
		}
		used[num] = true;
		int res = 0;

		// If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
		for(int i = 1; i <= 9; i++){
			if(!used[i] && (skip[num][i] == 0 || used[skip[num][i]])){
				res += dfs(skip, used, i, remain - 1);
			}
		}
		used[num] = false;
		return res;
	}

	public static void main(String[] args){
		LC351 x = new LC351();
		int m = 2, n = 3;
		System.out.println(x.numberOfPatterns(m, n));
	}
}