/*
256. Paint House

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
 */

#include<iostream>
#include<vector>
//#include<math.h>

using namespace std;

class LC256{
public:
	// Time Complexity: O(N)
	// Runtime: 6ms, beats 15.64%
	int minCost(vector<vector<int> >& costs){
		if(costs.size() == 0)
			return 0;

		int n = costs.size();
		for(int i = 0; i < n - 1; i++){
			costs[i+1][0] += min(costs[i][1], costs[i][2]);
			costs[i+1][1] += min(costs[i][0], costs[i][2]);
			costs[i+1][2] += min(costs[i][0], costs[i][1]);
		}

		return min(min(costs[n-1][0], costs[n-1][1]), costs[n-1][2]);
	}
};

int main(){
	LC256 *x = new LC256();
	vector<vector<int> > costs;
	vector<int> house = {1, 2, 3};
	costs.push_back(house);
	house = {4, 2, 3};
	costs.push_back(house);
	house = {1, 4, 2};
	costs.push_back(house);

	cout << x->minCost(costs) << endl;

	return 0;
}