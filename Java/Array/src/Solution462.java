import java.util.Arrays;

public class Solution462 {
	/* 462. Minimum Moves to Equal Array Elements II:
	 * Given a non-empty integer array, find the minimum number of moves required to make all 
	 * array elements equal, where a move is incrementing a selected element by 1 or decrementing 
	 * a selected element by 1. You may assume the array's length is at most 10,000.
	 * 
	 * Input: [1, 2, 3]
	 * Output: 2
	 * Explanation: Only two moves are needed, [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
	 */
	
	public static int minMoves2(int[] nums){
		
		
		Arrays.sort(nums);
	
		int i = 0, j = nums.length - 1, result = 0;
		while(i < j){
			result += nums[j--] - nums[i++]; 
		}
		return result;
		
		/*
		 * Clear Version:
		Arrays.sort(nums);		
		int i = 0, j = nums.length - 1;
		int result = 0, mid = nums.length - 1;
		while(i < j){
			result += nums[j--] - nums[mid];
			result += nums[mid] - nums[i++];
		}
		return result;
		*/
		
		/*
		Arrays.sort(nums);
        int res = 0, mid = nums.length/2;
        for(int i = 0; i < nums.length; i++){
            res += i > mid ? nums[i] - nums[mid] : nums[mid] - nums[i];
        }
        return res;
        */
	}
}
