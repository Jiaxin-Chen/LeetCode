/*
152. Maximum Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

class LC152{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 4ms, beats 11.47%
	public int maxProduct(int[] nums){
		if(nums == null || nums.length == 0){;
			return 0;
		}

		int[] localMin = new int[nums.length];  // localMin[i]：一定包含nums[i]的前i个元素之和最小值，属于局部最优
		int[] localMax = new int[nums.length];  // localMax[i]：一定包含nums[i]的前i个元素之和最大值，属于局部最优
		int maxRes = nums[0];

		localMin[0] = nums[0];
		localMax[0] = nums[0];

		for(int i = 1; i < nums.length; i++){
			// if localMax[i-1] > 0 and nums[i] < 0, then localMax[i-1] * nums[i] should be the localMin[i]
			localMin[i] = Math.min(nums[i], Math.min(localMin[i - 1] * nums[i], localMax[i - 1] * nums[i]));  
			// if localMin[i-1] < 0 and nums[i] < 0, then localMin[i-1] * nums[i] should be the localMax[i]
			localMax[i] = Math.max(nums[i], Math.max(localMin[i - 1] * nums[i], localMax[i - 1] * nums[i])); 
			maxRes = Math.max(maxRes, Math.max(localMin[i], localMax[i]));
		}
		return maxRes;
	}

	//----------------------------------------------------------------------------------------------------
	// Optimization: Space Complexity
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 4ms, beats 11.47%
	public int maxProduct2(int[] nums){
		if(nums == null || nums.length == 0){;
			return 0;
		}

		int preMin = nums[0];
		int preMax = nums[0];
		int maxRes = nums[0];

		for(int i = 1; i < nums.length; i++){
			int curMin = Math.min(nums[i], Math.min(preMin * nums[i], preMax * nums[i]));
			int curMax = Math.max(nums[i], Math.max(preMin * nums[i], preMax * nums[i]));
			maxRes = Math.max(maxRes, Math.max(curMin, curMax));
			preMin = curMin;
			preMax = curMax;
		}
		return maxRes;
	}

	public static void main(String[] args){
		LC152 x = new LC152();
		int[] nums = {2, 3, -2, 4};
		System.out.println(x.maxProduct2(nums));
	}
}