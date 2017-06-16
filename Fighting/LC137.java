/*
137. Single Number II
Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class LC137{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 75.52%
	public int singleNumber(int[] nums){
		if(nums.length == 0)
			return 0;

		int ones = 0, twos = 0; 
		for(int i = 0; i < nums.length; i++){
			ones = (ones ^ nums[i]) & ~twos;
			twos = (twos ^ nums[i]) & ~ones;
		}
		return ones;
	}

	public static void main(String[] args){
		int[] nums = {3, 2, 1, 1, 3, 6, 2};
		LC137 x = new LC137();
		System.out.println(x.singleNumber(nums));
	}
}