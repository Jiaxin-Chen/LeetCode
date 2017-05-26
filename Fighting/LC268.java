/*
268. Missing Number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

public class LC268{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 1ms, beats 45.84%
	public int missingNumber(int[] nums){
		if(nums.length == 0)
			return 0;

		int sum = nums.length;
		for(int i = 0; i < nums.length; i++){
			sum += i - nums[i];
		}
		return sum;
	}

	public static void main(String[] args){
		int[] nums = {2, 0, 1, 4, 5, 6};
		LC268 x = new LC268();
		int res = x.missingNumber(nums);
		System.out.println(res);
	}
}
