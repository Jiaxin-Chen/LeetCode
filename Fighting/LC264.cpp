/*
264. Ugly Number II

Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */

#include<iostream>
#include<vector>
#include<math.h>

using namespace std;

class LC264{
public:
	// Time Complexity: O(n)
	// Runtime: 9ms, beats 23.65%
	int nthUglyNumber(int n){
		if(n == 1)
			return 1;
		vector<int> dp(n);
		dp[0] = 1;
		int n2 = 0, n3 = 0, n5 = 0;

		for(int i = 1; i < n; i++){
			dp[i] = min(dp[n2] * 2, min(dp[n3] * 3, dp[n5] * 5));
			if(dp[i] == dp[n2] * 2)
				n2++;
			if(dp[i] == dp[n3] * 3)
				n3++;
			if(dp[i] == dp[n5] * 5)
				n5++;
		}
		return dp[n-1];

	}

	// Time Limit Exceed....
	int nthUglyNumber2(int n){
		if(n == 1)
			return 1;

		int idx = 1;
		while(n > 0){

			int num = idx;
			for(int i = 2; i < 6; i++){
				while(num % i == 0)
					num /= i;
			}
			if(num == 1)
				n--;
			idx++;
			//cout << "idx = " << idx << ", n = " << n <<endl;
		}
		return --idx;
	}

};

int main(){
	LC264 *x = new LC264();
	int n = 440;
	cout << x->nthUglyNumber(n) << endl;
	return 0;
}
