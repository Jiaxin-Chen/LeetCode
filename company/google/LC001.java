/*
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.*;

class LC001{
	// Time Complexity: O(N^2)
	// Runtime: 136ms, beats 2.44%
	public int[] twoSum(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return new int[0];
		}

		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums.length; j++){
				if(i != j && nums[i] + nums[j] == target){
					return new int[]{i, j};
				}
			}
		}
		return new int[0];
	}

//---------------------------------------------------------
	// Optimization:
	// Time Complexity: O(N)
	// Runtime: 10ms, beats 52.18%
	public int[] twoSum2(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}

		for(int i = 0; i < nums.length; i++){
			int component = target - nums[i];

			// map.get(component) != i can avoid the duplicate case 4 + 4 = 8(target)
			if(map.containsKey(component) && map.get(component) != i){
				return new int[]{i, map.get(component)};
			}
		}
		return new int[0];
	}

//-----------------------------------------------------------
	// Optimization:
	// Time Complexity: O(N)
	// Runtime: 7ms, beats 89.14%
	public int[] twoSum3(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();

		// Just one iteration
		for(int i = 0; i < nums.length; i++){
			int component = target - nums[i];

			// map.get(component) != i can avoid the duplicate case 4 + 4 = 8(target)
			if(map.containsKey(component) && map.get(component) != i){
				return new int[]{i, map.get(component)};
			}

			map.put(nums[i], i);
		}
		return new int[0];
	}

	public static void main(String[] args){
		LC001 x = new LC001();
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] res = x.twoSum3(nums, target);
		System.out.println(res[0] + ", " + res[1]);
	}
}
