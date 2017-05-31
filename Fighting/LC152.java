/*
152. Maximum Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example:
Given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */

public class LC152{
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 55.70%
	public int maxProduct(int[] nums){
		if(nums.length == 0)
			return 0;

		int maxPre = nums[0], minPre = nums[0];
		int maxRes = nums[0];
		int maxCur = 0, minCur = 0;

		for(int i = 1; i < nums.length; i++){
			int tmp1 = maxPre * nums[i], tmp2 =  minPre * nums[i];
			maxCur = Math.max(Math.max(tmp1, tmp2), nums[i]);
			minCur = Math.min(Math.min(tmp1, tmp2), nums[i]);
			maxRes = Math.max(maxCur, maxRes);
			maxPre = maxCur;
			minPre = minCur;
		}
		return maxRes;
	}


	// Time Complexity: O(N)
	// Runtime: 4ms, beats 15.74%
	// I don't know why it's slower...
	public int maxProduct2(int[] nums){
		if(nums.length == 0)
			return 0;

		int maxCur = nums[0], minCur = nums[0];
		int maxRes = nums[0];

		for(int i = 1; i < nums.length; i++){
			int tmp1 = maxCur * nums[i], tmp2 =  minCur * nums[i];
			maxCur = Math.max(Math.max(tmp1, tmp2), nums[i]);
			minCur = Math.min(Math.min(tmp1, tmp2), nums[i]);
			maxRes = Math.max(maxCur, maxRes);
		}
		return maxRes;
	}


	public static void main(String[] args){
		int[] nums = {-4, -3, -2};
		LC152 x = new LC152();
		int res = x.maxProduct2(nums);
		System.out.println(res);
	}
}