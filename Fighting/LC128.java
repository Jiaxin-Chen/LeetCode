/*
128. Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
 */

import java.util.*;

public class LC128{
	// Time Complexity: O(N)
	// Runtime: 28ms, beats 5.34%
	public int longestConsecutive(int[] nums){
		if(nums.length == 0)
			return 0;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums){
			if(map.containsKey(num)){
				continue;
			}else{
				int left = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
				int right = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
				System.out.println(left + " " + right);
				int sum = left + right + 1;
				map.put(num, sum);

				res = Math.max(res, sum);

				map.put(num - left, sum);
				map.put(num + right, sum);
			}
		}

		return res;
	}

	public static void main(String[] args){
		int[] nums = {100, 4, 200, 1, 3, 2};
		LC128 x = new LC128();
		int res = x.longestConsecutive(nums);
		System.out.println(res);
	}
}