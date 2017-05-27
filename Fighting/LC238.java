/*
238. Product of Array Except Self

Given an array of n integers where n > 1, nums, 
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class LC238{
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 13.75%
	public int[] productExceptSelf(int[] nums){
		if(nums.length == 0){
			return null;
		}

		int[] res = new int[nums.length];
		res[0] = 1;
		for(int i = 0; i < nums.length - 1; i++){
			res[i + 1] = res[i] * nums[i];
		}

		int tmp = 1;
		for(int i = nums.length - 1; i >= 0; i--){
			res[i] *= tmp;
			tmp *= nums[i];
		}
		return res;
	}

	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4};
		LC238 x = new LC238();
		int[] res = x.productExceptSelf(nums);
		for(int i : res){
			System.out.print(i + " ");
		}
	}
}