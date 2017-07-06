/*
198. House Robber

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected and 
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class LC198{
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 40.29%
	public int rob(int[] nums){
		int max1 = 0, max2 = 0;

		for(int i = 0; i < nums.length; i++){
			if(i % 2 == 0)
				max1 = Math.max(max1 + nums[i], max2);
			else
				max2 = Math.max(max1, max2 + nums[i]);
			System.out.println("max1 = " + max1 + ", max2 = " + max2);
		}
		return Math.max(max1, max2);
	}
}