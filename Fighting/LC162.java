/*
162. Find Peak Element

A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.

Example:
In array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */

public class LC162{
	// Time Complexity: O(logN)
	// Runtime: 2ms, beats 2.55%
	public int findPeakElement(int[] nums){
		if(nums.length < 2){
			return 0;
		}

		int left = 0, right = nums.length - 1;
		while(left < right){
			int mid1 = left + (right - left) / 2;
			int mid2 = mid1 + 1;
			if(nums[mid1] < nums[mid2]){
				left = mid2;
			}else{
				right = mid1;
			}
		}
		return left;
	}

	public static void main(String[] args){
		int[] nums = {1, 2, 3, 1};
		LC162 x = new LC162();
		int res = x.findPeakElement(nums);
		System.out.println(res);
	}
}