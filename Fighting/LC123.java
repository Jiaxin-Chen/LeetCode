/*
123. Best Time to Buy and Sell Stock III

Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class LC123{
	// Time Complexity： O(NK), Space Complexity: O(K)
	// Runtime: 6ms, beats 23.39%
	public int maxProfit(int[] prices){
		if(prices.length < 2)
			return 0;
		// k transactions
		int k = 2;

		// Buy-sell II case, unlimited transactions
		if(k >= prices.length / 2){
			int maxProfit = 0;
			for(int i = 1; i < prices.length; i++){
				if(prices[i] > prices[i-1])
					maxProfit += prices[i] - prices[i-1];
			}
			return maxProfit;
		}
		// Use DP approach but only O(k) space
		int[] f = new int[k + 1]; // max profit up to day i (included) with at most k transactions (global optimal objective)
		int[] g = new int[k + 1]; // max profit up to day i (included) with at most k transactions AND we sell at day i
		for(int i = 1; i < prices.length; i++){
			int diff = prices[i] - prices[i-1];
			int tmp = f[0];
			for(int j = 1; j <= k; j++){
				g[j] = Math.max(g[j], tmp) + diff;
				tmp = f[j];
				f[j] = Math.max(f[j], g[j]);
			}
		}
	
		return f[k];
	}

	public static void main(String[] args){
		int[] prices = {1, 2};
		LC123 x = new LC123();
		int res = x.maxProfit(prices);
		System.out.println(res);
	}
}