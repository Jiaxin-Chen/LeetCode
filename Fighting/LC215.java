/*
215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

import java.util.*;

public class LC215{
	// Time Complexity: O(NlogN), Space Complexity: O(1)
	// Runtime: 4ms, beats 81.20%
	public int findKthLargest(int[] nums, int k){
		Arrays.sort(nums);
		return nums[nums.length - k];
	}


	// Time Complexity: O(N)
	// Runtime: 67ms, beats 11.07%
	public int findKthLargest2(int[] nums, int k){
		int start = 0, end = nums.length - 1;
		while(true){
			int pos = partition(nums, start, end);
			if(pos == k - 1)
				return nums[pos];
			if(pos > k - 1)
				end = pos - 1;
			else
				start = pos + 1;
		}
	}

	private int partition(int[] nums, int start, int end){
		int pivot = nums[start];
		int left = start + 1, right = end;
		while(left <= right){
			if(nums[left] < pivot && nums[right] > pivot)
				swap(nums, left++, right--);
			if(nums[left] >= pivot)
				left++;
			if(nums[right] <= pivot)
				right--;
		}
		swap(nums, start, right);
		return right;
	}

	private void swap(int[] nums, int left, int right){
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}

	public static void main(String[] args){
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;
		LC215 x = new LC215();
		int res = x.findKthLargest2(nums, k);
		System.out.println(res);
	}
}