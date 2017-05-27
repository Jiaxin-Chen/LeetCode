/*
209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.

Example: 
Given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class LC209{
	public int minSubArrayLen(int s, int[] nums){
		if(nums.length == 0)
			return 0;

		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		while(j < nums.length){
			sum += nums[j++];
			while(sum >= s){
				min = Math.min(min, j - i);
				sum -= nums[i++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args){
		int[] nums = {2, 3, 1, 2, 4, 3};
		int s = 7;
		LC209 x = new LC209();
		int res = x.minSubArrayLen(s, nums);
		System.out.println(res);
	}
}