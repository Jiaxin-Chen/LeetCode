/*
714. Best Time to Buy and Sell Stock with Transaction Fee

Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
*/

class LC714{
	//
	public int maxProfit(int[] prices, int fee){
		if(prices == null || prices.length <= 1){
			return 0;
		}
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];

		// 交易费在sell时支付
		buy[0] = -prices[0];
		for(int i = 1; i < n; i++){
			buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]); // 比较buy[i-1]和sell[i-1]-prices[i]，来决定是第i-1天买好，还是第i天买好
			sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee); // 比较sell[i-1]和buy[i]+prices[i]-fee，来决定是第i-1天卖好，还是第i天卖好，同时减去fee
		}
		return sell[n-1];
	}

	public int maxProfit2(int[] prices, int fee){
		if(prices == null || prices.length <= 1){
			return 0;
		}
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];

		// 交易费在buy时支付
		buy[0] = -prices[0] - fee;
		for(int i = 1; i < n; i++){
			buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i] - fee); // 比较buy[i-1]和sell[i-1]-prices[i]，来决定是第i-1天买好，还是第i天买好
			sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]); // 比较sell[i-1]和buy[i]+prices[i]-fee，来决定是第i-1天卖好，还是第i天卖好，同时减去fee
		}
		return sell[n-1];
	}

	public static void main(String[] args){
		LC714 x = new LC714();
		int[] prices = new int[]{1, 3, 2, 8, 4, 9};
		int fee = 2;

		System.out.println(x.maxProfit2(prices, fee));
	}
}