
public class Solution238 {
	/* 238. Product of Array Except Self:
	 * Given an array of n integers where n > 1, nums, return an array output such that output[i] 
	 * is equal to the product of all the elements of nums except nums[i].
	 * 
	 * Input: [1, 2, 3, 4]
	 * Output: [24, 12, 8, 16]
	 * Complexity: Time O(N)
	 */
	
	public static int[] productExceptSelf(int[] nums){
		if (nums == null){
			return null;
		}
		
		int[] res = new int[nums.length];
		res[0] = 1;
		
		for (int i = 0; i < nums.length - 1; i++){
			res[i+1] = res[i] * nums[i];
		}
		
		int tmp = 1;
		for (int i = nums.length - 1; i >= 0; i--){
			res[i] *= tmp;
			tmp *= nums[i];
		}
		return res;
	}
}
