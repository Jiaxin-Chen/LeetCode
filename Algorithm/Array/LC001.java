/*
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public class LC001 {

	// Time Complexity: O(N), Only one iteration
	// Space Complexity: O(N)
	public int[] twoSum1()(int[] nums, int target) {
		int[] res = new int[2];
		if (nums.length <= 1)
			return res;

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			
			int complement = target - nums[i];

			if(map.containsKey(complement) && map.get(complement) != i)
				return new int{i, map.get(complement)};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}


	// Time Complexity: O(N), Space Complexity: O(N)
	public int[] twoSum2(int[] nums, int target) {
		int[] res = new int[2];
		if (nums.length <= 1)
			return res;

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if(map.containsKey(complement) && map.get(complement) != i)
				return new int{i, map.get(complement)};
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// Time Complexity: O(N^2), Space Complexity: O(1)
	public int[] twoSum2(int[] nums, int target) {
		int[] res = new int[2];
		if (nums.length <= 1)
			return res;
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
				}
			}
		}
		return res;
	}


	public static void main(String[] args){
		LC001 x = new LC001();
		int[] nums = {3, 3};
		int target = 6;

		int[] res = x.twoSum1(nums, target);
		System.out.println(res[0] + " " + res[1]);
	}
}