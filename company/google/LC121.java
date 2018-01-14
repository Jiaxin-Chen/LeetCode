/*
121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/

class LC121{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 2ms, beats 37.52%
	public int maxProfit(int[] prices){
		if(prices.length == 0){
			return 0;
		}

		int buy = Integer.MIN_VALUE, sell = 0;

		for(int price : prices){
			buy = Math.max(buy, -price); // -price can help us buy the lowest stock
			sell = Math.max(sell, price + buy); // in case that the stock keep decreasing, then we just have sell = 0
		}
		return sell;
	}

	public static void main(String[] args){
		int[] prices = {7, 1, 5, 3, 6, 4};
		LC121 x = new LC121();
		System.out.println(x.maxProfit(prices));
	}
}