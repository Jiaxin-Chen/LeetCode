
public class Solution152 {
	/* 152. Maximum Product Subarray:
	 * Find the contiguous subarray within an array (containing at least one number) 
	 * which has the largest product.
	 * 
	 * Input: [2, 3, -2, 4]
	 * Output: 6 ([2, 3])
	 */
	
	public static int maxProduct(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int min = nums[0], max = nums[0], product = nums[0];
		for(int i = 1; i < nums.length; i++){
			int tmp = max;
			/* We need compare among max * nums[i], min * nums[i] as well as nums[i], 
			 * since this is product, a negative * negative could be positive.
			 */
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
			product = (max > product) ? max : product;
		}
		return product;
	}
}
