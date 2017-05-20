/*
75. Sort Colors

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, 
then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/

public class LC075{
	public void sortColors(int[] nums){
		if(nums.length == 0){
			return;
		}
		/* 
		Because the loop is from 0 to A.length-1, that is, small to large, left to right. 
		In this way, if some swapping steps in (A[i]==0) break the order , it will be solved in the next i. 
		But if some swapping steps in (A[i]==2) break the order, it will not be solved ,as the i has passed. */ 
		int zero = 0, second = nums.length - 1;
		for(int i = 0; i <= second; i++){
			// Handle the corner case when nums[0] = 1
			while(nums[i] == 2 && i < second){
				swap(nums, i, second--);
			}
			while(nums[i] == 0 && i > zero){
				swap(nums, i, zero++);
			}
		}
	}

	// Time Complexity: O(N^2)
	// Runtime: 0ms, beats 63.24%
	public void sortColors2(int[] nums){
		int zero = 0, second = nums.length - 1;
		for(int i = nums.length - 1; i >= zero; i--){
			while(nums[i] == 0 && i > zero){
				swap(nums, i, zero++);
			}
			while(nums[i] == 2 && i < second){
				swap(nums, i, second--);
			}
		}
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args){
		int[] nums = {1, 2, 0};
		LC075 x = new LC075();
		x.sortColors2(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
}
