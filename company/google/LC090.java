/*
90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

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
class LC090{
	// Time Complexity: O(NlogN)
	// Runtime: 8ms, beats 12.94%
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
        if(nums == null || nums.length == 0){
        	return res;
        }
        Arrays.sort(nums);

        backtracking(res, new LinkedList<Integer>(), nums, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
    	res.add(new LinkedList<Integer>(list));
    	for(int i = pos; i < nums.length; i++){
    		// that's why we need sort nums first
    		if(i > pos && nums[i] == nums[i - 1]){
    			continue;
    		}
    		list.add(nums[i]);
    		backtracking(res, list, nums, i + 1);
    		list.remove(list.size() -  1);
    	}
    }

    public static void main(String[] args){
    	int[] nums = new int[]{2, 1, 2};
    	LC090 x = new LC090();
    	System.out.println(x.subsetsWithDup(nums));
    }
}