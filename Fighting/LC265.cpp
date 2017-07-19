/*
265. Paint House II

There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; 
costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
 */

#include<iostream>
#include<vector>

using namespace std;

class LC265{
public:
	// Time Compelxity: O(KN), Space Complexity: O(1)
	// Runtime: 9ms, beats 54.90%
	int minCostII(vector<vector<int> >& costs){
		if(costs.size() == 0)
			return 0;

		int n = costs.size(), k = costs[0].size();
		// minIdx1 is the index of the 1st-smallest cost till previous house
		// minIdx2 is the index of the 2nd-smallest cost till previous house
		int minIdx1 = -1, minIdx2 = -1;

		for(int i = 0; i < n; i++){
			int prev1 = minIdx1, prev2 = minIdx2;
			minIdx1 = -1, minIdx2 = -1;

			for(int j = 0; j < k; j++){
				if(j != prev1)
					// current color j != previous house color
					costs[i][j] += prev1 < 0 ? 0 : costs[i-1][prev1];
				else
					costs[i][j] += prev2 < 0 ? 0 : costs[i-1][prev2];

				if(minIdx1 < 0 || costs[i][j] < costs[i][minIdx1]){
					minIdx2 = minIdx1;
					minIdx1 = j;
				}
				else if(minIdx2 < 0 || costs[i][j] < costs[i][minIdx2]){
					minIdx2 = j;
				}
			}
		}
		return costs[n-1][minIdx1];
	}
};

int main(){
	LC265 x;
	vector<vector<int> > costs;
	vector<int> colors = {1, 5, 3, 9};
	costs.push_back(colors);
	colors = {3, 7, 2, 1};
	costs.push_back(colors);
	colors = {2, 4, 6, 8};
	costs.push_back(colors);

	cout << x.minCostII2(costs) << endl;

	return 0;
}