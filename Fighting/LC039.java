/*
39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example:
Given candidate set [2, 3, 6, 7] and target 7, 
[
  [7],
  [2, 2, 3]
]
*/

import java.util.List;
import java.util.ArrayList;

public class LC039{

	// Runtime: 23ms, beats 61.71%
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<>();
		if(candidates == null || candidates.length == 0){
			return res;
		}
		//Arrays.sort(candidates);
		backtracking(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> list, int[] candidates, int remain, int start){
		if(remain < 0){
			return;
		}
		// find one right list if remain == 0
		else if(remain == 0){
			res.add(new ArrayList<>(list));
		}else{
			for(int i = start; i < candidates.length; i++){
				list.add(candidates[i]);
				backtracking(res, list, candidates, remain - candidates[i], i);
				list.remove(list.size() - 1); // remove the useless element in list
			}
		}
	}

	public static void main(String[] args){
		int[] candidates = {2, 3, 6, 7};
		int target = 7;

		LC039 x = new LC039();
		List<List<Integer>> res = x.combinationSum(candidates, target);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}