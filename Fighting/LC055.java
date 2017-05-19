/*
55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
 */

public class LC055{

	// Time Complexity: O(N)
	// Runtime: 7ms, beats 92.61%
	// Utilize backwards method!!!
	public boolean canJump(int[] nums){
		int index = nums.length - 1;
		for(int i = nums.length - 2; i >= 0; i--){
			if(nums[i] + i >= index){
				index = i;
			}
		}

		return (index <= 0);
	}

	public boolean canJump2(int[] nums){
		int max = 0;
		for(int i = 0; i < nums.length && i < max; i++){
			max = Math.max(nums[i] + i, max);
		}
		return (i == nums.length);
	}

	public static void main(String[] args){
		int[] nums = {2, 0};
		LC055 x = new LC055();
		boolean res = x.canJump(nums);
		System.out.println(res);
	}

}