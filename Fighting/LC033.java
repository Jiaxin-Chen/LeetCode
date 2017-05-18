/*
33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */

public class LC033{

	// Time Complexity: O(logN)
	// Runtime: 16ms, beat 38.91%
	public int search(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}

		// Find the index of pivot, when left == right
		int left = 0, right = nums.length - 1;
		while(left < right){
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[right]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		int pivot = left; 

		left = 0;
		right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			// Find the realMid of the rotated array
			int realMid = (mid + pivot) % nums.length;
			if(nums[realMid] == target){
				return realMid;
			}else if(nums[realMid] > target){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}

	/*
	Explanation: 
	Let's say nums looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
	Because it's not fully sorted, we can't do normal binary search. But here comes the trick:
	If target is let's say 14, then we adjust nums to this, where "inf" means infinity:
	[12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]
	If target is let's say 7, then we adjust nums to this:
	[-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

	And then we can simply do ordinary binary search.
	Of course we don't actually adjust the whole array but instead adjust only on the fly only the elements we look at. 
	And the adjustment is done by comparing both the target and the actual element against nums[0].
	 */
	
	// Time Complexity: O(logN)
	// Runtime: 15ms, beats 55.98%
	public int search2(int[] nums, int target){
		if(nums.length == 0 || nums == null){
			return -1;
		}

		int left = 0, right = nums.length - 1, num;
		while(left <= right){
			int mid = left + (right - left) / 2;
			// If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid].
			if((nums[0] > nums[mid]) == (nums[0] > target)){
				num = nums[mid];
			}else{
				num = nums[0] > target ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			if(num < target){
				left = mid + 1;
			}else if(num > target){
				right = mid - 1;
			}else{
				return mid;
			}
		}

		return -1;
	}


	public static void main(String[] args){
		int[] nums = {5, 1, 3};
		int target = 5;

		LC033 x = new LC033();
		int index = x.search2(nums, target);
		System.out.println(index);
	}
}