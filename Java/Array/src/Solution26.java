
public class Solution26 {
	/* 26. Remove Duplicates from Sorted Array:
	   Given a sorted array, remove the duplicates in place such that 
	   each element appear only once and return the new length. 
	   It doesn't matter what you leave beyond the new length.
	   
	   Input: A = [1, 1, 2]
	   Output: return length = 2 (A = [1, 2])
	   Complexity: Time O(n), Space O(1)
	*/
	public static int removeDuplicates(int[] nums){
		if (nums.length == 0)
			return 0;
		
		int index = 0;
		for (int i = 0; i < nums.length; i++){
			if (nums[i] != nums[index])
				nums[++index] = nums[i];
		}
		return ++index;
		/*
		 * int index = 1;
		 * for (int i = 1; i < nums.length; i++){
		 *     if (nums[i] != nums[index - 1];
		 *         nums[index++] = nums[i];
		 * }
		 * return index;
		 */
	}
	
}
