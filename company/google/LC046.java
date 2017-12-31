/*
46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

import java.util.*;

class LC046{
	// Time Complexity: O(N)
	// Runtime: 11ms, beats 7.70%
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new LinkedList<>();
		if(nums == null || nums.length == 0){
			return res;
		}
		permutation(res, new LinkedList<Integer>(), nums);
		return res;
	}

	private void permutation(List<List<Integer>> res, List<Integer> list, int[] nums){
		if(list.size() == nums.length){
			res.add(new LinkedList<>(list));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			// avoid duplicates
			if(list.contains(nums[i])){
				continue;
			}
			list.add(nums[i]);
			permutation(res, list, nums);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args){
		LC046 x = new LC046();
		int[] nums = new int[]{1, 2, 3};
		System.out.println(x.permute(nums));
	}
}