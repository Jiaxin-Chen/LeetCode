/*
41. First Missing Positive

Given an unsorted integer array, find the first missing positive integer.

Example:
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class LC041{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 12ms, beats 77.64%
	public int firstMissingPositive(int[] nums){
		if(nums.length == 0)
			return 1;

		for(int i = 0; i < nums.length; i++){
			while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
				swap(nums, nums[i] - 1, i);
			}
		}

		for(int i = 0; i < nums.length; i++){
			if(nums[i] != i + 1){
				return i + 1;
			}
		}

		return nums.length + 1;
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args){
		int[] nums = {2,1};
		LC041 x = new LC041();
		int res = x.firstMissingPositive(nums);
		System.out.println(res);
	}
}