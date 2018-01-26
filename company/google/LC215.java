/*
215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

import java.util.*;

class LC215{
	// Sort
	// Time Complexity: O(nlogn), Space Complexity :O(1)
	public int findKthLargest(int[] nums, int k){
		if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
			return 0;
		}
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

//-----------------------------------------------------------------------------
	// Min heap
	// Time Complexity: O(NlogN), Space Complexity: O(k)
	public int findKthLargest2(int[] nums, int k){
		if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
			return 0;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < nums.length; i++){
			queue.offer(nums[i]);
		}

		// 当最小堆只剩下k个element的时候，queue.peek()就是kth-largest element
		while(queue.size() > k){
			queue.poll();
		}
		return queue.peek();
	}

//----------------------------------------------------------------------------
	// Optimization: Quick Select
	// Time Complexity: O(N)
	public int findKthLargest3(int[] nums, int k){
		if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
			return 0;
		}
		// because the quick select algorighm is for the k-th smallest element, so we need parse the (nums.length - k)
		return select(nums, 0, nums.length - 1, nums.length - k);
	}

	private int select(int[] nums, int left, int right, int k){
		if(left == right){
			return nums[left];
		}
		// find the pivot
		int pivotIdx = partition(nums, left, right);

		if(pivotIdx == k){
			return nums[pivotIdx];
		}
		if(pivotIdx < k){
			return select(nums, pivotIdx + 1, right, k);
		}
		if(pivotIdx > k){
			return select(nums, left, pivotIdx - 1, k);
		}
		return 0;
	}

	// 将比pivot小的元素放到pivot左边，比pivot大的放到pivot右边
	private int partition(int[] nums, int left, int right){

		// pivot的选取决定了partition所得结果的效率，可以选择left pointer，更好的选择是在left和right范围内随机生成一个；
		// Method 1: just left pivotIdx
		int pivotIdx = left;

		// Method 2: 随机选择, better
		Random rand = new Random();
		pivotIdx = rand.nextInt((right - left) + 1) + left;

		// init pivot
		int pivotVal = nums[pivotIdx];

		swap(nums, pivotIdx, right);

		// first idx that nums[storeIdx] > pivotVal
		int storeIdx = left;

		for(int i = left; i < right; i++){
			if(nums[i] < pivotVal){
				swap(nums, i, storeIdx);
				storeIdx++;
			}
		}

		// Recover pivot to array
		swap(nums, storeIdx, right);
		return storeIdx;
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args){
		LC215 x = new LC215();
		//int[] nums = {21, 3, 34, 5, 13, 8, 2, 55, 1, 19};
		int[] nums = {2, 1};
		int k = 2;
		System.out.println(x.findKthLargest3(nums, k));
	}
}