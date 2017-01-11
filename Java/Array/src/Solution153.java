
public class Solution153 {
	/* 153. Find Minimum in Rotated Sorted Array:
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
	 * 
	 * Input: [4, 5, 6, 7, 0, 1, 2]
	 * Output: 0
	 */
	
	public static int findMin(int[] nums){
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1)
			return nums[0];
		
		int start = 0, end = nums.length - 1;
		while(start < end){
			int mid = (start + end) / 2;
			if (nums[mid] < nums[end]){
				end = mid;
			}else{
				start = mid + 1;
			}
		}
		return nums[start];
			
	}
}
