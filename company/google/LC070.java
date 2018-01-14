/*
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

class LC070{
	// Fibonacci
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 4ms, beats 8.11%
	public int climbStairs(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2; i <= n; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}

//--------------------------------------------------------
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 4ms, beats 8.11%
	public int climbStairs2(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		int preStep1 = 2, preStep2 = 1;
		int curSteps = 0;

		for(int i = 2; i < n; i++){
			curSteps = preStep1 + preStep2;
			preStep2 = preStep1;
			preStep1 = curSteps;
		}
		return curSteps;
	}

	public static void main(String[] args){
		int n = 4;
		LC070 x = new LC070();
		System.out.println(x.climbStairs2(4));
	}
}