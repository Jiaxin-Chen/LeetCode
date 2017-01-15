
public class Solution209 {
	/* 209. Minimum Size Subarray Sum:
	 * Given an array of n positive integers and a positive integer s, find the minimal length of a 
	 * contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	 * 
	 * Input: [2, 3, 1, 2, 4, 3], s = 7
	 * Output: 2 (subArray = [4, 3])
	 */
	
	/* Complexity: Time O(N) */
	public static int minSubArrayLen(int s, int[] nums){
		if (nums == null || s == 0){
			return 0;
		}
		
		int sum = 0, j = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++){
			sum += nums[i];
			
			while (sum >= s){
				min = Math.min(min, i - j + 1);
				sum -= nums[j++];
			}
		}
		
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	
	
	/* Complexity: Time O(NlogN) Binary Search*/
	public static int minSubArrayLen2(int s, int[] nums){
		if (nums == null || s == 0){
			return 0;
		}
		
		// Attention: The start and end condition boundary please!
		int start = 1, end = nums.length , min = 0;
		while (start <= end){
			int mid = (start + end) / 2;
			if (subArrayExist(mid, s, nums)){
				end = mid - 1;
				min = mid;
			}else{
				start = mid + 1;
			}
		}
		return min;
	}
	
	private static boolean subArrayExist(int mid, int s, int[] nums){
		int sum = 0;
		for (int i = 0; i < nums.length; i++){
			// Remove the element from the head to add new contiguous element
			if (i >= mid){
				sum -= nums[i - mid];
			}
			sum += nums[i];
			if (sum >= s){
				return true;
			}
		}
		return false;
	}
}
