/*
80. Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/

public class LC080{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 37.61%
	public int removeDuplicates(int[] nums){
		if(nums.length < 3)
			return nums.length;

		int count = 2;
		for(int i = 2; i < nums.length; i++){
			if(nums[i] != nums[count - 2])
				nums[count++] = nums[i];
		}
		return count;
	}

	public static void main(String[] args){
		int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 6, 6, 6};
		LC080 x = new LC080();
		int count = x.removeDuplicates(nums);
		System.out.println(count);
	}
}