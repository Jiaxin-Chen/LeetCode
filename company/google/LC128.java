/*
128. Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

import java.util.*;

class LC128 {
	// Time Complexity: O(N)
	public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {

        	// If contains num, just pass to avoid duplicates
        	if (!map.containsKey(num)) {
        		// left and right to locate the other end of the sequences to the left and right of n respectively
        		// if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
        		int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
        		int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
        		int sum = left + right + 1;

        		map.put(num, sum);
        		res = Math.max(res, sum);

        		// extend the length to the boundary(s)
        		map.put(num - left, sum);
        		map.put(num + right, sum);
        	} 
        }
        return res;
    }

    public static void main(String[] args) {
    	LC128 obj = new LC128();
    	int[] nums = new int[]{100, 4, 200, 1, 3, 2};
    	System.out.println(obj.longestConsecutive(nums));
    }
}