/*
53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

class LC053{
	// Difference from House Robber is House Robber should start from the pos = 0, but this can be start from any pos
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 17ms, beats 17.68%
	public int maxSubArray(int[] nums){
		if(nums == null || nums.length == 0){;
			return 0;
		}

		int[] local = new int[nums.length];  // local[i]：一定包含nums[i]的前i个元素之和最大值，属于局部最优
		int[] global = new int[nums.length]; // global[i]: 前i个元素之和最大值，不一定包含nums[i]，属于全剧最优

		local[0] = nums[0];
		global[0] = nums[0];

		for(int i = 1; i < nums.length; i++){
			local[i] = Math.max(local[i - 1] + nums[i], nums[i]);  // if local[i-1] < 0, then should have nums[i] > local[i-1] + nums[i]
			global[i] = Math.max(global[i - 1], local[i]);
		}
		return global[nums.length - 1];
	}

//-----------------------------------------------------------------------------------
	// Optimization: Utilize curSum to indicates local[i]
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 14ms, beats 85.18%
	public int maxSubArray(int[] nums){
		if(nums == null || nums.length == 0){;
			return 0;
		}
		int curSum = nums[0]; // curSum can indicates local[i];
		int[] global = new int[nums.length];

		global[0] = nums[0];

		for(int i = 1; i < nums.length; i++){
			curSum = Math.max(curSum + nums[i], nums[i]);
			global[i] = Math.max(curSum, global[i-1]);
		}
		return global[nums.length - 1];
	}	

//-----------------------------------------------------------------------------------
	// Optimization: Utilize curSum to indicate local[i], maxSum to indicate global[i]
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 17ms, beats 17.68%
	public int maxSubArray(int[] nums){
		if(nums == null || nums.length == 0){;
			return 0;
		}
		int curSum = nums[0];
		int maxSum = nums[0];

		for(int i = 1; i < nums.length; i++){
			curSum = Math.max(curSum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}	

	public static void main(String[] args){
		LC053 x = new LC053();

		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(x.maxSubArray(nums));
	}
}