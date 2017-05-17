/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.

Example:
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
*/

public class LC026{

	// Time Complexity: O(N)
	// Runtime: 19ms, beat 15.41%
	public int removeDuplicates(int[] nums){
		int len = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[len] != nums[i]){
				nums[++len] = nums[i];
			}
		}
		// Attention: it must be ++len rather than len++, otherwise the code will return len directly.
		return ++len;
	}

	public static void main(String[] args){
		int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 5};
		LC026 x = new LC026();
		int len = x.removeDuplicates(nums);
		System.out.println(len);
		for(int i = 0; i < len; i++){
			System.out.print(nums[i] + " ");
		}
	}
}