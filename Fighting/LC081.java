/*
81. Search in Rotated Sorted Array II

Follow up for "33. Search in Rotated Sorted Array" (Time Complexity: O(logN))
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Write a function to determine if a given target is in the array.
The array may contain duplicates.
*/

public class LC081{
	// Time Complexity: O(logN)
	// Runtime: 1ms, beats 24.25%
	public boolean search(int[] nums, int target){
		if(nums.length == 0)
			return false;

		int left = 0, right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target)
				return true;
			if(nums[left] == nums[mid] && nums[mid] == nums[right]){
				left++;
				right--;
			}
			// else if here!!!!! Otherwise the outofbound exception happened!!!
			// The first half is in order, the pivot is in the second half
			else if(nums[left] <= nums[mid]){
				if(nums[left] <= target && target < nums[mid]){
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}
			// The pivot is in the first half, the second half is in order!
			else{
				if(nums[mid] < target && target <= nums[right]){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			}
		}

		return false;
	}

	public static void main(String[] args){
		int[] nums = {2, 2, 2, 0, 2, 2};
		int target = 0;
		LC081 x = new LC081();
		boolean found = x.search(nums, target);
		System.out.println(found);
	}
}