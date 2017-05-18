/*
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example:
Given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC040{
	// Runtime: 28ms, beats 40.27%
	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> res = new ArrayList<>();
		if(candidates == null || candidates.length == 0){
			return res;
		}
		Arrays.sort(candidates);
		backtracking(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
	}

	private void backtracking(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int remain, int start){
		if(remain < 0){
			return;
		}else if(remain == 0){
			res.add(new ArrayList<Integer>(list));
		}else{
			for(int i = start; i < candidates.length; i++){
				// Skip duplicates
				if(i > start && candidates[i] == candidates[i-1]){
					continue;
				}
				list.add(candidates[i]);
				backtracking(res, list, candidates, remain - candidates[i], i+1); // we cannot use the same element
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args){
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;

		LC040 x = new LC040();
		List<List<Integer>> res = x.combinationSum2(candidates, target);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}