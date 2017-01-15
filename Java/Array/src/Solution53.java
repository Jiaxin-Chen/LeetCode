
public class Solution53 {
	/* 53. Maximum Subarray:
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	 * 
	 * Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
	 * Output: 6 ([4, -1, 2, 1])
	 */
	
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0){
			return 0;
		}
		
		int sum = 0, max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			/*
			if (sum < 0){
				sum = nums[i];
			}else{
				sum += nums[i];
			}
			
			if (sum > max){
				max = sum;
			}
			*/
			
			// Clearer version
			sum += nums[i];
			max = Math.max(sum, max);
			sum = (sum < 0) ? 0 : sum;
		}
		return max;
	}
	
}
