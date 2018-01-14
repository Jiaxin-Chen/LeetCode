/*
213. House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

class LC213{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 0ms, beats 44.36%
	public int rob(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		// Divide the problem into two cases and get the maximal from them, and process them just as House Robber I
		return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
	}

	private int rob(int[] nums, int start, int end){
		int[] dp = new int[nums.length];
		// Case 1: rob house from 0 to n - 2, just the same as House Robber I
		if(start == 0){
			dp[0] = nums[0];
			dp[1] = Math.max(nums[0], nums[1]);
		// Case 2: rob house from 1 to n - 1, so we have dp[0] = 0 here
		}else{
			dp[1] = nums[1];
		}
		for(int i = 2; i < end; i++){
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
		}
		return dp[end - 1];
	}
//--------------------------------------------------------------------------------
	// Optimization: Because dp[i] only depends on the dp[i-2] and dp[i-1], we can utilize two variables to 
	// record the dp[i-2] and dp[i-1] to reduce the space complexity into O(1)
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 1ms, beats 5.53%
	public int rob2(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		// Divide the problem into two cases and get the maximal from them, and process them just as House Robber I
		return Math.max(rob2(nums, 0, nums.length - 1), rob2(nums, 1, nums.length));
	}

	private int rob2(int[] nums, int start, int end){
		int pre = 0, cur = 0, next = 0;
		if(start == 0){
			pre = nums[0];
			cur = Math.max(nums[0], nums[1]);
		}else{
			cur = nums[1];
		}
		for(int i = 2; i < end; i++){
			next = Math.max(cur, pre + nums[i]);
			pre = cur;
			cur = next;
		}
		return cur;
	}

	public static void main(String[] args){
		int[] nums = new int[]{3, 8, 4, 2, 6};
		LC213 x = new LC213();
		System.out.println(x.rob2(nums));
	}
}
