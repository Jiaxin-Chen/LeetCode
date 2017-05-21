/*
90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

import java.util.*;

public class LC090{
	// Runtime 3ms, beats 34.27%
	public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            backtrack(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}