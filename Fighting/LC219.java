/*
219. Contains Duplicate II

Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the absolute difference between i and j is at most k.
*/

import java.util.*;

public class LC219{
	// Time Complexity: O(N)
	// Runtime: 23ms, beats 19.70%
	public boolean containsNearbyDuplicate(int[] nums, int k){
		if(nums.length < 2){
			return false;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				if(i - map.get(nums[i]) <= k){
					return true;
				} 
			}
			// Must always update the index of nums[i], for case nums = {1, 0, 1, 1}, k = 1;
			map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args){
		int[] nums = {1, 0, 1, 1};
		int k = 1;
		LC219 x = new LC219();
		System.out.println(x.containsNearbyDuplicate(nums, k));
	}
}

