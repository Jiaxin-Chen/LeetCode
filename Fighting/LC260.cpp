/*
260. Single Number III

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.

For example:
Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

#include<iostream>
#include<vector>

using namespace std;

class LC260{
public:
	// Time Complexity: O(n), Space Complexity: O(1)
	// Runtime: 13ms, beats 64.83%
	vector<int> singleNumber(vector<int>& nums){
		
		vector<int> res = {0, 0};
		int diff = 0;
		// Get the XOR of the two numbers we need to find
		for(int num : nums)
			diff ^= num;
		// Get its last set bit
		diff &= -diff;

		for(int num : nums){
			// The bit is not set
			if((num & diff) == 0)
				res[0] ^= num;
			// The bit is set
			else
				res[1] ^= num;
		}
		return res;
	}
};

int main(){
	LC260 x;
	vector<int> nums = {1, 2, 1, 3, 2, 5};
	vector<int> res = x.singleNumber(nums);
	for(int i : res)
		cout << i << endl;

	return 0;
}