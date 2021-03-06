/*
153. Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
You may assume no duplicate exists in the array.
*/

public class LC153{
	// Time Complexity: O(logN)
	// Runtime: 1ms, beats 4.43%
	public int findMin(int[] nums){
		if(nums.length == 0){
			return -1;
		}

		int left = 0, right = nums.length - 1;
		while(left < right){
			int mid = left + (right - left) / 2;
			//System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
			if(nums[mid] > nums[right]){
				left = mid + 1;
			}else{
				/* Cannot be (right = mid - 1) here, 
				   because in the case nums[mid] <= nums[right], the mid maybe the pivot,
				   we can only set right = mid.*/
				right = mid; 
			}
		}
		return nums[left];
	}

	public static void main(String[] args){
		int[] nums = {4, 5, 6 ,7, 0, 1, 3};
		LC153 x = new LC153();
		int res = x.findMin(nums);
		System.out.println(res);
	}
}