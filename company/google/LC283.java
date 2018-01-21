/*
283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

class LC283{
	// Time Complexity :O(N), Space Complexity :O(1)
	// Runtime: 2ms, beats 80.62%
	public void moveZeros(int[] nums){
		if(nums == null || nums.length == 0){
			return;
		}

		int idx = 0;

		// Shift non-zero values as far forward as possible
		for(int num : nums){
			if(num != 0){
				nums[idx++] = num;
			}
		}
		// set the remain as zeros
		while(idx < nums.length){
			nums[idx++] = 0;
		}
	}

	public static void main(String[] args){
		LC283 x = new LC283();
		int[] nums = {0, 1, 0, 3, 12};
		x.moveZeros(nums);

		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
}