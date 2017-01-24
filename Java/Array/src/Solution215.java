

public class Solution215 {
	/* 215. Kth Largest Element in an Array：
	 * Find the kth largest element in an unsorted array. Note that it is the kth largest element 
	 * in the sorted order, not the kth distinct element.
	 * 
	 * Input: [3, 2, 1, 5, 6, 4], k = 2
	 * Output: 5
	 */
	  
	public static int findKthLargest(int[] nums, int k){
		
		/* Time : O(NlogN), Space:O(1)
		Arrays.sort(nums);		
		return nums[nums.length - k];
		*/
		
		// Quick Select
		if (nums == null || nums.length == 0)
			return Integer.MAX_VALUE;
		
		return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}
	 
	public static int findKthLargest(int[] nums, int start, int end, int k){
		if (start > end)
			return Integer.MAX_VALUE;
		
		int pivot = nums[end];
		int left = start;
		for (int i = start; i < end; i++){
			if (nums[i] <= pivot)
				swap(nums, left++, i);
		}
		swap(nums, left, end);
		
		if (left == k)
			return nums[left];
		
		else if (left < k)
			return findKthLargest(nums, left + 1, end, k);
		else
			return findKthLargest(nums, start, left - 1, k);
	}
	
	public static void swap(int[] nums, int i, int j){
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
}
