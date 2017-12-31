/*
39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
import java.util.*;

class LC039{
	// Time Complexity: O(N^2)
	// Runtime: 20ms, beats 25.64%
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<>();
        if(candidates == null || candidates.length == 0 || target < 0){
        	return res;
        }
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
    		list.add(candidates[i]);
    		// the pos is still i, beacuse we can reuse the number
    		backtracking(res, list, candidates, remain - candidates[i], i);
    		list.remove(list.size() - 1);
    	}
    }

    public static void main(String[] args){
    	int[] candidates = new int[]{2, 3, 6, 7};
    	int target = 7;
    	LC039 x= new LC039();
    	System.out.println(x.combinationSum(candidates, target));
    }
}