/*
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

import java.util.*;

class LC047{
	// Time Complexity: O(NlogN)
	// Runtime: 10ms, beats 31.30%
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new LinkedList<>();
		if(nums.length == 0 || nums == null){
			return res;
		}
		boolean[] used = new boolean[nums.length];

		// Necessary!!! Sort the array “int[] nums” to make sure we can skip the same value.
		Arrays.sort(nums);

		permutations(res, new LinkedList<Integer>(), nums, used);
		return res;
	}

	private void permutations(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used){
		if(list.size() == nums.length){
			res.add(new LinkedList<>(list));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			/*
			Another explanation for why both
			1. if(i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) continue; and
			2. if(i > 0 && nums[i] == nums[i - 1] && use[i - 1]) continue;
			work is given below:
			The problem for Permutation II is that different orders of duplicates should only be considered as one permutation. 
			In other words, you should make sure that when these duplicates are selected, there has to be one fixed order.
			Now take a look at code 1 and 2.
			Code 1 makes sure when duplicates are selected, the order is ascending (index from small to large). 
			However, code 2 means the descending order.
			*/
			if(used[i] || (i > 0 && nums[i] == nums[i-1] && used[i-1])){
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			permutations(res, list, nums, used);
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}


	public static void main(String[] args){
		LC047 x = new LC047();
		int[] nums = new int[]{3, 3, 0, 3};
		System.out.println(x.permuteUnique(nums));
	}
}