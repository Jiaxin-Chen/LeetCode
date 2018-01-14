/*
198. House Robber

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them 
is that adjacent houses have security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

class LC198{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 0ms, beats 22.33%
	public int rob(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		if(nums.length < 2){
			return nums[0];
		}
		// dp[i] indicates the maximum money obtained until the i-th house was stolen
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(dp[0], nums[1]);

		for(int i = 2; i < n; i++){
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[n-1];
	}

	// Optimization: Because dp[i] only depends on the dp[i-2] and dp[i-1], we can utilize two variables to 
	// record the dp[i-2] and dp[i-1] to reduce the space complexity into O(1)
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 0ms, beats 22.33%
	public int rob2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		if(nums.length < 2){
			return nums[0];
		}
		int pre = nums[0];
		int cur = Math.max(nums[0], nums[1]);
		int next = 0;
		for(int i = 2; i < nums.length; i++){
			next = Math.max(pre + nums[i], cur);
			pre = cur;
			cur = next;
		}
		return cur;
	}

	public static void main(String[] args){
		int[] nums = new int[]{3, 8, 4, 2, 1};
		LC198 x = new LC198();
		System.out.println(x.rob2(nums));
	}
}
