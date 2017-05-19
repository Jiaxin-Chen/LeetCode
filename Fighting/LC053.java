/*
53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

Example:
Given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class LC053{
	public int maxSubArray(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}

		int res = nums[0], tmpMax = nums[0];
		for(int i = 1; i < nums.length; i++){
			tmpMax = Math.max(tmpMax + nums[i], nums[i]);
			res = Math.max(tmpMax, res);
		}
		return res;
	}

	public static void main(String[] args){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		LC053 x = new LC053();
		int res = x.maxSubArray(nums);
		System.out.println(res);
	}
}