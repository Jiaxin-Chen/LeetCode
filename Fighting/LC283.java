/*
283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class LC283{
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 69.78%
	public void moveZeros(int[] nums){
		if(nums.length == 0)
			return;
		int index = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				nums[index++] = nums[i];
			}
		}

		while(index < nums.length){
			nums[index++] = 0;
		}
	}

	public static void main(String[] args){
		int[] nums = {3, 5, 0, 0, 3, 1 ,6};
		LC283 x = new LC283();
		x.moveZeros(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
}