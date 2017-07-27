/*
279. Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, 
given n = 12, return 3 because 12 = 4 + 4 + 4; 
given n = 13, return 2 because 13 = 4 + 9.
*/

#include<iostream>
#include<vector>

using namespace std;

class LC279{
public:
	// Time Complexity: O(N^2)
	// Runtime: 119ms, beats 21.22%
	int numSquares(int n){
		if(n <= 0)
			return 0;

		vector<int> count(n + 1, INT_MAX);
		count[0] = 0;

		for(int i = 1; i <= n; i++){
			for(int j = 1; j * j <= i; j++){
				count[i] = min(count[i], count[i - j*j] + 1);
			}
		}
		return count.back();
	}
};

int main(){
	LC279 *x = new LC279();
	int n = 19;
	cout << x->numSquares(n) << endl;
	return 0;
}
