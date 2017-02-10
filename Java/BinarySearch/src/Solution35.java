
public class Solution35 {
	/*
	 * 35. Search Insert Position:
	 * Given a sorted array and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * You may assume no duplicates in the array.
	 * 
	 * Input: [1,3,5,6], 5 → Output: 2
	 * 		  [1,3,5,6], 2 → Output: 1
	 * 		  [1,3,5,6], 7 → Output: 4
	 * 		  [1,3,5,6], 0 → Output: 0
	 */
	
	public int searchInsert(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int start = 0, end = nums.length;
		while(start < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] == target || start == end){
				return mid;
			}else if(nums[mid] < target){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return end;
	}
	

	
	public static void main(String[] args){
		int[] nums = {1, 3, 5, 6};
		int target = 7;
		Solution35 res = new Solution35();
		System.out.println(res.searchInsert(nums, target));
	}
}
