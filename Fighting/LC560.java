/*
560. Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

import java.util.*;

public class LC560{
	// Time Complexity: O(N)
	// Runtime: 42ms, beats 84.81%
	public int subarraySum(int[] nums, int k){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int sum = 0, count = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			if(map.containsKey(sum - k)){
				count += map.get(sum - k);
			}
			if(map.containsKey(sum)){
				map.put(sum, map.get(sum) + 1); // There may be some negative numbers.
			}else{
				map.put(sum, 1);
			}
		}

		return count;
	}

	public static void main(String[] args){
		int[] nums = {1, 1, 1, 1, 3, 2, 1};
		int k = 3;
		LC560 x = new LC560();
		int res = x.subarraySum(nums, k);
		System.out.println(res);
	}
}