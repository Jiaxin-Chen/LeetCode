/*
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
import java.util.*;

class LC040{
	// Time Complexity: O(2 ^ N)
	// Runtime: 25ms, beats 38.71%
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<>();
        if(candidates == null || candidates.length == 0 || target < 0){
        	return res;
        }
        Arrays.sort(candidates);
        backtracking(res, new LinkedList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int[] candidates, int remain, int pos){
    	if(remain < 0){
    		return;
    	}
    	if(remain == 0){
    		res.add(new LinkedList<Integer>(list));
    		return;
    	}

    	for(int i = pos; i < candidates.length; i++){
    		// avoid duplicates
    		if(i > pos && candidates[i] == candidates[i-1]){
    			continue;
    		}
    		list.add(candidates[i]);
    		backtracking(res, list, candidates, remain - candidates[i], i + 1);
    		list.remove(list.size() - 1);
    	}
    }

    public static void main(String[] args){
    	int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
    	int target = 8;
    	LC040 x= new LC040();
    	System.out.println(x.combinationSum2(candidates, target));
    }
}