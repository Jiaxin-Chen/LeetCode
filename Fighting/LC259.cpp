/*
259. 3Sum Smaller

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
that satisfy the condition nums[i] + nums[j] + nums[k] < target.
For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]

Follow up:
Could you solve it in O(n2) runtime?
 */

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class LC259{
public:
	int threeSumSmaller(vector<int>& nums, int target){
		int count = 0, len = nums.size();
		sort(nums.begin(), nums.end());

		for(int i = 0; i < len - 2; i++){
			int left = i + 1, right = len - 1;
			while(left < right){
				if(nums[i] + nums[left] + nums[right] < target){
					count += right - left; // all the right in (left, right] can satisfy
					left++;
				}else{
					right--;
				}
			}
		}
		return count;
	}
};

int main(){
	LC259 *x = new LC259();
	vector<int> nums = {-2, 0, 1, 3};
	int target = 2;
	cout << x->threeSumSmaller(nums, target) << endl;

	return 0;
}