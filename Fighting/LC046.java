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

public class LC046{
	// Time Complexity:
	// Runtime: 8ms, beats 37.11%
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length == 0)
			return res;
		backtracking(res, new ArrayList<Integer>(), nums);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums){
		if(list.size() == nums.length){
			res.add(new ArrayList<>(list));
		}else{
			for(int i = 0; i < nums.length; i++){
				if(list.contains(nums[i]))
					continue;
				list.add(nums[i]);
				backtracking(res, list, nums);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args){
		LC046 x = new LC046();
		int[] nums = {1, 2, 3};
		List<List<Integer>> res = x.permute(nums);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + " ");
			System.out.println();
		}
	}
}