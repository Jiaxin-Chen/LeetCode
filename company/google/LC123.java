/*
123. Best Time to Buy and Sell Stock III

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

class LC123{
	// Time Complexity: O(N), Space Complexity: O(1)
	public int maxProfit(int[] prices){
		if(prices.length == 0){
			return 0;
		}

		int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		int sell1 = 0, sell2 = 0;

		for(int price : prices){
			buy1 = Math.max(buy1, -price);
			sell1 = Math.max(sell1, buy1 + price);
			buy2 = Math.max(buy2, sell1 -price);
			sell2 = Math.max(sell2, buy2 + price);
		}
		return sell2;
	}
}