/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class LC035{

	// Time Complexity: O(N)
	// Runtime: 7ms, beat 14.12%
	public int searchInsert(int[] nums, int target){	
		if(nums == null || nums.length == 0 || target < nums[0]){
			return 0;
		}
		for(int i = 0; i < nums.length; i++){
			if(nums[i] >= target){
				return i;
			}
		}
		return nums.length;
	}

	// Binary Search
	// Time Complexity: O(logN)
	// Runtime: 6ms, beat 31.86%
	public int searchInsert2(int[] nums, int target){
		if(nums == null || nums.length == 0 || target < nums[0]){
			return 0;
		}

		int left = 0, right = nums.length;
		while(left < right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] < target){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		return right;
	}


	public static void main(String[] args){
		int[] nums = {1, 3, 5, 6};
		int target = 2;
		LC035 x = new LC035();
		int res = x.searchInsert2(nums, target);
		System.out.println(res);
	}
}