/*
122. Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).
*/

class LC122{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 2ms, beats 10.16%
	public int maxProfit(int[] prices){
		if(prices.length == 0){
			return 0;
		}

		int maxPro = 0;

		for(int i = 1; i < prices.length; i++){
			maxPro += Math.max(0, prices[i] - prices[i-1]);
		}
		return maxPro;
	}
}