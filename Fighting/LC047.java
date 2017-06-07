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

public class LC047{
	// Time Complexity: O(N^2)
	// Runtime: 8ms, beats 72.63%
	public List<List<Integer>> permuteUnique(int[] nums){		
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length == 0)
			return res;
		Arrays.sort(nums);
		backtracking(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visit){
		
		if(list.size() == nums.length){
			res.add(new ArrayList<Integer>(list));
		}else{
			for(int i = 0; i < nums.length; i++){
				if(visit[i] || (i > 0 && nums[i - 1] == nums[i] && !visit[i-1]))
					continue;
				list.add(nums[i]);
				visit[i] = true;
				backtracking(res, list, nums, visit);
				list.remove(list.size() - 1);
				visit[i] = false;
			}	
		}
	}

	public static void main(String[] args){
		LC047 x = new LC047();
		int[] nums = {3, 0, 3, 3};
		List<List<Integer>> res = x.permuteUnique(nums);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + " ");
			System.out.println();
		}
	}
}