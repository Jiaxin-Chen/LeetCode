import java.util.*;

public class Solution442 {
	/* 442. Find All Duplicates in an Array:
	 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice 
	 * and others appear once. Find all the elements that appear twice in this array.
	 * 
	 * Input: [4, 3, 2, 7, 8, 2, 3, 1]
	 * Output: [2, 3]
	 * Complexity: Time O(N), Space O(1)
	 */
	
	public static List<Integer> findDuplicates(int[] nums){
		List<Integer> result = new ArrayList<>();
		
		// DO NOT miss it!!!
		if (nums == null){ 
			return result;
		}
		
		/*
		for (int i = 0; i < nums.length; i++){
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0){
				result.add(Math.abs(nums[index]));
			}else{
				nums[index] = -nums[index];
			}
		}*/
		for (int i = 0; i < nums.length; i++){
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0){
				result.add(index + 1);
			}else{
				nums[index] = -nums[index];
			}
		}
		
		for (int i = 0; i < nums.length; i++){
			nums[i] = Math.abs(nums[i]);
		}
		
		return result;
	}
}
