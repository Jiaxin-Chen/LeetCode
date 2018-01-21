/*
309. Best Time to Buy and Sell Stock with Cooldown

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/
import java.util.*;

class LC309{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 17ms, beats 19.48%
	public int maxProfit(int[] prices){
		if(prices == null || prices.length == 0){
			return 0;
		}

		int n = prices.length;

		int[] buy = new int[n];  // before day i what is the maxProfit for any sequence end with buy.
		int[] sell = new int[n]; // before day i what is the maxProfit for any sequence end with sell.
		int[] cool = new int[n]; // before day i what is the maxProfit for any sequence end with cooldown.

		/*
		(1) We have to `rest` before we `buy` and 
		(2) we have to `buy` before we `sell`
		*/

		//Arrays.fill(buy, Integer.MIN_VALUE);
		buy[0] = -prices[0];
		for(int i = 1; i < n; i++){
			buy[i] = Math.max(buy[i-1], cool[i-1] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i-1] + prices[i]);
			cool[i] = Math.max(cool[i-1], Math.max(sell[i-1], buy[i-1])); // Actually buy[i] <= cool[i] which means cool[i] = max(sell[i-1], cool[i-1]). That made sure [buy, cool, buy] is never occurred.
		}
		return sell[n-1];

	}

	//-----------------------------------------------------------------------------
	// Optimization: 
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 17ms, beats 19.48%
	public int maxProfit2(int[] prices){
		if(prices == null || prices.length <= 1){
			return 0;
		}

		int n = prices.length;

		//A further observation is that and cool[i] <= sell[i] is also true
		// Therefore we can have cool[i] = sell[i-1]
		int[] buy = new int[n];
		int[] sell = new int[n];

		buy[0] = -prices[0];
		buy[1] = prices[1] > prices[0] ? -prices[0] : -prices[1];
		sell[1] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;

		for(int i = 2; i < n; i++){
			buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
			sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
		}
		return sell[n-1];
	} 

	public static void main(String[] args){
		LC309 x = new LC309();
		int[] prices = new int[]{1, 2, 3, 0, 2};
		System.out.println(x.maxProfit2(prices));
	}
}