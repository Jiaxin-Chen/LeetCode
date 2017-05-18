/*
34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example:
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */

public class LC034{

	// Time Complexity: O(logN)
	// Runtime: 9ms, beats 28.55%
	public int[] searchRange(int[] nums, int target){
		int[] res= {-1, -1};

		if(nums == null || nums.length == 0){
			return res;
		}

		// For left part
		int left = 0, right = nums.length - 1;
		while(left < right){
			int mid = left + (right - left) / 2;
			if(nums[mid] < target){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		// Corner case
		if(nums[left] != target){
			return res;
		}else{
			res[0] = left;
		}
		
		// For right part
		right = nums.length - 1;
		while(left < right){
			int mid = (left + right + 1) / 2;
			if(nums[mid] > target){
				right = mid - 1;
			}else{
				left = mid;
			}
		}
		res[1] = right;

		return res;
	}

	public static void main(String[] args){
		int[] nums = { 5, 7, 7, 8, 8, 10};
		int target = 8;

		LC034 x = new LC034();
		int[] res = x.searchRange(nums, target);
		System.out.println(res[0] + " " + res[1]);
	}
}