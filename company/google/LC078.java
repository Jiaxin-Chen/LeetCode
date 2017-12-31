/*
78. Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

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

class LC078{
	// Time Complexity: O(NlogN)
	// Runtime: 6ms, beats 4.12%
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new LinkedList<>();
		if(nums == null || nums.length == 0){
			return res;
		}
		backtracking(res, new LinkedList<Integer>(), nums, 0);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
		res.add(new LinkedList<>(list));

		for(int i = pos; i < nums.length; i++){
			list.add(nums[i]);
			backtracking(res, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

	// bit manipuliation, ref: https://leetcode.com/problems/subsets/discuss/27288
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 29.29%
	public List<List<Integer>> subsets2(int[] nums){
		Arrays.sort(nums);
		int totalNumber = 1 << nums.length;
		List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
		for (int i=0; i<totalNumber; i++) {
			List<Integer> set = new LinkedList<Integer>();

			for (int j = 0; j < nums.length; j++) {
				if ((i & (1 << j)) != 0) {
					set.add(nums[j]);
				}
			}
			collection.add(set);
		}
		return collection;
	}

	public static void main(String[] args){
		int[] nums = new int[]{3, 2, 1};
		LC078 x = new LC078();
		System.out.println(x.subsets2(nums));
	}
}