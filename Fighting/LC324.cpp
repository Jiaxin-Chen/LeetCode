/*
324. Wiggle Sort II

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class LC324{
public:
	// Time Complexity: O(n)
	// Runtime: 49ms, beats 22.71%
	void wiggleSort(vector<int>& nums){
		vector<int> sorted(nums);
		sort(sorted.begin(), sorted.end());

		int n = nums.size();

		for(int i = n - 1, j = 0, k = i / 2 + 1; i >= 0; --i){
			nums[i] = sorted[(i & 1) ? k++ : j++];
		}
	}

private:
	void swap(vector<int>& nums, int i){
		int tmp = nums[i];
		nums[i] = nums[i-1];
		nums[i-1] = tmp;
	}
};

int main(){
	LC324 *x = new LC324();
	vector<int> nums = {1,2,2,1,2,1,1,1,1,2,2,2};
	x->wiggleSort(nums);
	for(int i = 0; i < nums.size(); i++)
		cout << nums[i] << " ";
	return 0;
}