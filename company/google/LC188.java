/*
188. Best Time to Buy and Sell Stock IV

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

import java.util.*;

class LC188{
	// Time Complexity: O(Nk), Space complexity: O(K)
	// TLE
	public int maxProfit(int k, int[] prices){
		if(prices.length == 0){
			return 0;
		}

		int[] buy = new int[k + 1];
		int[] sell = new int[k + 1];
		Arrays.fill(buy, Integer.MIN_VALUE);

		for(int price : prices){
			for(int j = 1; j <= k; j++){
				buy[j] = Math.max(buy[j], sell[j-1] - price);
				sell[j] = Math.max(sell[j], buy[j] + price);
			}
		}
		return sell[k];
	}
}