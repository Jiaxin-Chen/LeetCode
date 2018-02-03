/*
188. Best Time to Buy and Sell Stock IV

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

import java.util.*;

class LC188{
    public int maxProfit(int k, int[] prices){
        if(prices.length == 0){
            return 0;
        }

        int[][] buy = new int[n][k];
        int[][] sell = new int[n][k];
        //Arrays.fill(buy[0], Integer.MIN_VALUE);
        Arrays.fill(buy[0][0], -prices[0]);

        for(int i = 1; i < prices; i++){
            for(int j = 0; j < k; j++){
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j-1] - prices[i]);
                sell[i][j] = Math.max(sell[i-1][j], buy[i][j] + prices[i]);
            }
        }
        return sell[n-1][k-1];
    }




	// Time Complexity: O(Nk), Space complexity: O(K)
	// TLE
	public int maxProfit2(int k, int[] prices){
		if(prices.length == 0){
			return 0;
		}

		int[] buy = new int[k + 1];
		int[] sell = new int[k + 1];
		Arrays.fill(buy, Integer.MIN_VALUE);

        if(k >= prices.length / 2){
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

		for(int price : prices){
			for(int j = 1; j <= k; j++){
				buy[j] = Math.max(buy[j], sell[j-1] - price);
				sell[j] = Math.max(sell[j], buy[j] + price);
			}
		}
		return sell[k];
	}


	// Time Complexity: O(NK), Space Complexity: O(NK)
	public int maxProfit3(int k, int[] prices){
		// write your code here
        if (k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int n = prices.length;
        int[][] mustsell = new int[n + 1][k + 1];   // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[n + 1][k + 1];  // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
        
        mustsell[0][0] = globalbest[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            mustsell[0][i] = globalbest[0][i] = 0;
        }
        
        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            mustsell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustsell[i][j] = Math.max(globalbest[(i - 1)][j - 1] + gainorlose,
                                            mustsell[(i - 1)][j] + gainorlose);
                globalbest[i][j] = Math.max(globalbest[(i - 1)][j], mustsell[i ][j]);
            }
        }
        return globalbest[(n - 1)][k];
	}
}