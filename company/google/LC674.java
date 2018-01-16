/*
674. Longest Continuous Increasing Subsequence

Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
*/

class LC674{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 6ms, beats 17.9%
	public int findLengthOfLCIS(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = 1;
		int maxLen = 1;

		for(int i = 1; i < n; i++){
			dp[i] = (nums[i] > nums[i-1]) ? dp[i-1] + 1 : 1;
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}

//--------------------------------------------------------
	// Optimization 1: 
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 7ms, beats 6.62%
	public int findLengthOfLCIS2(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		int n = nums.length;
		int curLen = 1;
		int maxLen = 1;

		for(int i = 1; i < n; i++){
			curLen = (nums[i] > nums[i-1]) ? curLen + 1 : 1;
			maxLen = Math.max(maxLen, curLen);
		}
		return maxLen;
	}

//--------------------------------------------------------------
/* Follow up: 
 Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. 
(The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
Example
Given a matrix:
[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25
Challenge
O(nm) time and memory.
*/

	// 记忆化搜索
	// Time Complexity: O(MN), Space Complexity: O(MN)
	public int findLengthOfLCIS3(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;

		int[][] dp = new int[m][n];     // dp[i][j] indicates the longest length in the point [i, j]
		int[][] visited = new int[m][n]; // 0: unvisited, 1: visiting, 2: visited
		int maxLen = 1;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				dp[i][j] = dfs(dp, visited, matrix, i, j);
				maxLen = Math.max(maxLen, dp[i][j]);
			}
		}
		return maxLen;
	}

	private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	private int dfs(int[][] dp, int[][] visited, int[][] matrix, int i, int j){
		// 这一步限制让遍历过的 [i, j] 不再遍历，保证时间复杂度 O(MN)
		if(visited[i][j] != 0){
			return dp[i][j];
		}

		visited[i][j] = 1; // visiting
		int curLen = 1;

		for(int[] dir : directions){
			int x = i + dir[0];
			int y = j + dir[1];

			// we need visited[x][y] != 1 to 避免访问正在遍历的数组，以防环的形成
			// Attention: NOT visited[x][y] == 0, because we also need the dp[x][y] when visit[x][y] = 2 for the curLen
			if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && visited[x][y] != 1){
				if(matrix[x][y] > matrix[i][j]){
					 // 往四个方向搜索，只选取curlen最大的那个方向的length作为dp[i][j]
					curLen = Math.max(curLen, dfs(dp, visited, matrix, x, y) + 1);
				}
			}
		}
		dp[i][j] = curLen;
		visited[i][j] = 2; // visited
		return curLen;
	}




	public static void main(String[] args){
		LC674 x = new LC674();
		int[] nums = new int[]{1,3,5,4,7};
		int[][] matrix = new int[][]{{1 ,2 ,3 ,4 ,5}, {16,17,24,23,6}, {15,18,25,22,7}, {14,19,20,21,8}, {13,12,11,10,9}};
		//System.out.println(x.findLengthOfLCIS2(nums));
		System.out.println(x.findLengthOfLCIS3(matrix));
	}
}