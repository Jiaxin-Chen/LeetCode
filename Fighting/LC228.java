/*
228. Summary Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

Example:
Given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

import java.util.*;

public class LC228{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 5.46%
	public List<String> summaryRanges(int[] nums){
		List<String> res = new ArrayList<String>();
		if(nums.length == 0)
			return res;
		if(nums.length == 1){
			res.add(Integer.toString(nums[0]));
			return res;
		}

		for(int i = 0; i < nums.length; i++){
			int left = nums[i];
			// Attention: i+1 < nums.length must go first to guarantee the java.lang.ArrayIndexOutOfBoundsException 
			while(i+1 < nums.length && nums[i] + 1 == nums[i+1]){
				i++;
			}
			if(left != nums[i]){
				res.add(Integer.toString(left) + "->" + Integer.toString(nums[i]));
			}else{
				res.add(Integer.toString(left));
			}
		}

		return res;
	}

	public static void main(String[] args){
		int[] nums = {0, 1, 2, 4, 5, 7};
		LC228 x = new LC228();
		List<String> res = x.summaryRanges(nums);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}