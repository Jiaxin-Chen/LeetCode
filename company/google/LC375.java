/*
375. Guess Number Higher or Lower II

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
*/

class LC375{
	// Time Complexity: O(MN), because each dp[i][j] will be computed once
	// Runtime: 15ms, beats 44.05%
	public int getMoneyAmount(int n){

		/*
		dp[j]，代表着如果我们在区间 [i , j] 内进行查找，所需要的最少 cost 来保证找到结果

	    如果以 top-down recursion 的方式分析这个问题，可以发现对于区间 [i, j] ，猜测 i <= k <= j 我们可能出现以下三种结果：
        1. k 就是答案，此时子问题的额外 cost = 0 ，当前位置总 cost  = k + 0;
        2. k 过大，此时我们的有效区间缩小为 [i , k - 1] 当前操作总 cost  = k + dp[k - 1];
        3. k 过小，此时我们的有效区间缩小为 [k + 1 , j] 当前操作总 cost  = k + dp[k + 1][j];
        */
		int[][] dp = new int[n+1][n+1];
		return helper(dp, 1, n);
	}

	private int helper(int[][] dp, int start, int end){
		if(start >= end){
			return 0;
		}
		if(dp[start][end] != 0){
			return dp[start][end];
		}

		int minCost = Integer.MAX_VALUE;
		for(int k = start; k <= end; k++){
			// max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
			int cur = k + Math.max(helper(dp, k + 1, end), helper(dp, start, k - 1));
			// min makes sure that you are minimizing your cost.
			minCost = Math.min(minCost, cur);
		}
		dp[start][end] = minCost;
		return minCost;
	}

	public static void main(String[] args){
		LC375 x = new LC375();
		int n = 10;
		System.out.println(x.getMoneyAmount(n));
	}
}