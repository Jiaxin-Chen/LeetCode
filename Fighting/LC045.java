/*
45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.

Example:
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 */

public class LC045{
	/* The main idea is based on Greedy Algorithm:
	   Let's say the range of the current jump is [curBegin, curEnd], 
	   curMax is the farthest point that all points in [curBegin, curEnd] can reach. 
	   Once the current point reaches curEnd, then trigger another jump, 
	   and set the new curEnd with curMax, then keep the above steps.
	 */
	// Time Complexity: O(N)
	// Runtime: 14ms, beats 15.27%
	public int jump(int[] nums){

		int curMax = 0, curEnd = 0, res = 0;
		for(int i = 0; i < nums.length - 1; i++){
			curMax = Math.max(nums[i] + i, curMax);
			if(i == curEnd){
				res++;
				curEnd = curMax;
			}
		}
		return res;
	}

	public static void main(String[] args){
		int[] nums = {2, 3, 1, 1, 4};
		LC045 x = new LC045();
		int res = x.jump(nums);
		System.out.println(res);
	}
}