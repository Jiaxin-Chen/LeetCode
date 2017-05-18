/*
27. Remove Element

Given an array and a value, remove all instances of that value in place and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
	Given input array nums = [3,2,2,3], val = 3
	Your function should return length = 2, with the first two elements of nums being 2, that's nums = {2, 2, 3, 3}
*/

public class LC027{

	// Time Complexity: O(N)
	// Runtime: 10ms, beat 45.20%
	public int removeElement(int[] nums, int val){

		int len = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[len++] = nums[i];
			}
		}
		return len;

	}

	public static void main(String[] args){
		int[] nums = {3, 2, 2, 3};
		int val = 3;

		LC027 x = new LC027();
		int res = x.removeElement(nums, val);
		System.out.println(res);
	}
}
