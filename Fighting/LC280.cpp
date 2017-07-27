/*
280. Wiggle Sort

Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */

/*
Solution:
The final sorted nums needs to satisfy two conditions:
1) If i is odd, then nums[i] >= nums[i - 1];
2) If i is even, then nums[i] <= nums[i - 1].
 */

#include<iostream>
#include<vector>

using namespace std;

class LC280{
public:
	// Time Complexity: O(n)
	// Runtime: 49ms, beats 22.71%
	void wiggleSort(vector<int>& nums){
		int n = nums.size();
		for(int i = 1; i < n; i++){
			if(((i & 1) && (nums[i] < nums[i-1])) || (!(i & 1) && (nums[i] > nums[i-1])))
				swap(nums, i);
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
	LC280 *x = new LC280();
	vector<int> nums = {3, 5, 2, 1, 6, 4};
	x->wiggleSort(nums);
	for(int i = 0; i < nums.size(); i++)
		cout << nums[i] << " ";
	return 0;
}