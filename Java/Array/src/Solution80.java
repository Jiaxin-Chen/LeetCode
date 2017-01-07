
public class Solution80 {
	/* 80. Remove Duplicates from Sorted Array II:
	   Given a sorted array, remove the duplicates in place such that 
	   each element appear at most twice and return the new length. 
	   It doesn't matter what you leave beyond the new length.
	   
	   Input: A = [1, 1, 1, 2, 2, 3]
	   Output: return length = 5 (A = [1, 1, 2, 2, 3])
	   Complexity: Time O(n), Space O(1)
	*/
	public static int removeDuplicates2(int[] nums){
		if (nums.length <= 2)
			return nums.length;
		
		int index = 2;
		for (int i = 2; i < nums.length; i++){
			if (nums[i] != nums[index - 2])
				nums[index++] = nums[i];
		}
		return index;
	}
}
