
public class Solution81 {
	/* 81. Search in Rotated Sorted Array II:
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Write a function to determine if a given target 
	 * is in the array. The array may contain duplicates.
	 * 
	 * Input: [3, 3, 1, 2, 3], target = 2
	 * Output: true
	 * Complexity: Time O(logN)
	 */
	
	public static boolean search(int[] nums, int target){
		if (nums == null || nums.length == 0)
			return false;
		
		int start = 0, end = nums.length - 1;
		while (start <= end){
			int mid = (start + end) / 2;
			if(target == nums[mid])
				return true;
			
			// left: unsorted, right: sorted
			if (nums[mid] < nums[end] || nums[mid] < nums[start]){
				if (target > nums[mid] && target <= nums[end]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
			// left: sorted, right: unsorted
			else if (nums[mid] > nums[end] || nums[mid] > nums[start]) {
				if (target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			// nums[start] == nums[mid] == nums[end]
			else {
				end--; //start++;
			}
		}
		return false;
	}
}
