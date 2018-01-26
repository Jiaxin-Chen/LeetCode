/*
238. Product of Array Except Self

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

class LC238{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 2ms, beats 23.71%
	public int[] productExceptSelf(int[] nums){
		if(nums == null || nums.length == 0){
			return new int[0];
		}

		int[] res = new int[nums.length];
		int tmp = 1; // Use tmp to store temporary multiply result by two directions.

		// store the product in the left part of the nums[i]
		for(int i = 0; i < nums.length; i++){
			res[i] = tmp;
			tmp *= nums[i];
		}

		// store the product in the right part of the nums[i]
		tmp = 1;
		for(int i = nums.length - 1; i >= 0; i--){
			res[i] *= tmp;
			tmp *= nums[i];
		}
		return res;
	}

	public static void main(String[] args){
		LC238 x = new LC238();
		int[] nums = new int[]{1, 2, 3, 4};
		int[] res = x.productExceptSelf(nums);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i] + " ");
		}
	}
}