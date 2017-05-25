/*
217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/

import java.util.Set;
import java.util.HashSet;

public class LC217{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 26ms, beats 11.98%
	public boolean containsDuplicate(int[] nums){
		if(nums.length == 0){
			return false;
		}

		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args){
		int[] nums = {2, 3, 5, 6, 7, 9, 1, 2};
		LC217 x = new LC217();
		boolean res = x.containsDuplicate(nums);
		System.out.println(res);
	}
}