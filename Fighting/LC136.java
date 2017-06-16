/*
136. Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

import java.util.*;

public class LC136{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 41.36%
	public int singleNumber(int[] nums){
		if(nums.length == 0)
			return 0;

		int res = 0;

		// As long as the element appears twice, the res will turn back to 0 due to ^ operation.
		for(int i = 0; i < nums.length; i++)
			res ^= nums[i];

		return res;
	}

	public static void main(String[] args){
		int[] nums = {3, 2, 1, 1, 3, 6, 2};
		LC136 x= new LC136();
		System.out.println(x.singleNumber(nums));
	}
}