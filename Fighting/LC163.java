/*
163. Missing Ranges

Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], 
return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
return ["2", "4->49", "51->74", "76->99"].
 */

import java.util.*;

public class LC163{
	public List<String> findMissingRanges(int[] nums, int lower, int upper){
		List<String> res = new LinkedList<String>();

		if(nums.length == 0){
		 	res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
		 	return res;
		}

		StringBuilder sb = new StringBuilder();
		int start = lower;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] < start)
				continue;
			if(nums[i] == start){
				start++;
				continue;
			}
			res.add(getRange(start, nums[i] - 1));
			start = nums[i] + 1;
		}

		if(start <= upper)
			res.add(getRange(start, upper));
		return res;
	}

	private String getRange(int start, int end){
		return (start == end) ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(end);
	}

	public static void main(String[] args){
		LC163 x = new LC163();
		int[] nums = {0, 1, 3, 50, 75};
		int lower = 1, upper = 99;
		List<String> res = x.findMissingRanges(nums, lower, upper);

		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
}