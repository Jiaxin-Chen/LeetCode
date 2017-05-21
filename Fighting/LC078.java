/*
78. Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

import java.util.*;

public class LC078{

	// Runtime: 5ms, beats 3.58%
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length == 0){
			return res;
		}
		Arrays.sort(nums);
		backtrack(res, new ArrayList<Integer>(), nums, 0);
		return res;
	}

	private void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start){
		res.add(new ArrayList<Integer>(list));
		for(int i = start; i < nums.length; i++){
			list.add(nums[i]);
			backtrack(res, list, nums, i+1);
			list.remove(list.size() - 1);
		}
	}
}