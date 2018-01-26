/*
34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

class LC034{
	// Binary search
	// Time Complexity: O(logN)
	// Runtime: 7ms, beats 58.86%
	public int[] searchRange(int[] nums, int target){

		int[] res = new int[]{-1, -1};

		if(nums == null || nums.length == 0){
			return res;
		}

		int left = 0, right = nums.length - 1;

		// Loop will terminate since mid < right, and left or right will shrink by at least 1.
        // Proof by contradiction that mid < right: if mid==right, then left==right and loop would have been terminated.
		
		// binary search for the left index
		while(left < right){
			int mid = left + (right - left) / 2;
			if(target > nums[mid]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		res[0] = (nums[left] == target) ? left : -1;


		// Binary search for the right index
		right = nums.length - 1;
		while(left < right){

			// mid should be (left + right) / 2 + 1, because we hope to find the next index from the right side
			int mid = left + (right - left) / 2 + 1;
			if(target < nums[mid]){
				right = mid - 1;
			}else{
				left = mid;
			}
		}
		res[1] = (nums[right] == target) ? right : -1;

		return res;
	}

	public static void main(String[] args){
		LC034 x = new LC034();
		int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] res = x.searchRange(nums, target);
		System.out.println(res[0] + ", " + res[1]);
	}
}