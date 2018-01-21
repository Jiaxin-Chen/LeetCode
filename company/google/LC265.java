/*
265. Paint House II

There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
*/

class LC265{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 21.58%
	public int minCostII(int[][] costs){
		if(costs == null || costs.length == 0 || costs[0].length == 0){
			return 0;
		}
		int n = costs.length, k = costs[0].length;
		int minIdx1 = -1; // minIdx1 is the index of the 1st-smallest cost till previous house
		int minIdx2 = -1; // minIdx2 is the index of the 2nd-smallest cost till previous house

		for(int i = 0; i < n; i++){
			int preIdx1 = minIdx1, preIdx2 = minIdx2;
			minIdx1 = -1;
			minIdx2 = -1;

			for(int j = 0; j < k; j++){
				// current color j is different to last min1
				if(j != preIdx1){
					costs[i][j] += preIdx1 < 0 ? 0 : costs[i-1][preIdx1];
				// otherwise we need add the last min2 cost to the current costs[i][j]
				}else{
					costs[i][j] += preIdx2 < 0 ? 0 : costs[i-1][preIdx2];
				}

				// find the indices of 1st and 2nd smallest cost of painting current house i
				if(minIdx1 < 0 || costs[i][j] < costs[i][minIdx1]){
					minIdx2 = minIdx1;
					minIdx1 = j;
				}else if(minIdx2 < 0 || costs[i][j] < costs[i][minIdx2]){
					minIdx2 = j;
				}
			}
		}
		return costs[n-1][minIdx1];
	}
}