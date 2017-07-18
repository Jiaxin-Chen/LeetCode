/*
254. Factor Combinations

Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
 */

#include<iostream>
#include<vector>

using namespace std;

class LC254{
	// Time Complexity: O(NlogN)
	// Runtime: 219ms, beats12.34%
public:
	vector<vector<int> > getFactors(int n){
		vector<vector<int> > res;
		if(n <= 1)
			return res;
		vector<int> factors;
		backtracking(res, factors, 2, n);
		res.pop_back(); // remove the last single factor
		return res;
	}

private:
	void backtracking(vector<vector<int> >& res, vector<int>& factors, int start, int remain){
		if(remain < 1)
			return;
		if(remain == 1)
			res.push_back(factors);
		else{
			for(int i = start; i <= remain; i++){
				if(remain % i == 0){
					factors.push_back(i);
					backtracking(res, factors, i, remain / i);
					factors.pop_back();
				}

			}
		}
	}
};

int main(){
	LC254 x;
	int n = 34;
	vector<vector<int> > res = x.getFactors(n);
	for(int i = 0; i < res.size(); i++){
		for(int j = 0; j < res[i].size(); j++)
			cout << res[i][j] << " ";
		cout << endl;
	}
	return 0;
}