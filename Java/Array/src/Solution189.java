
public class Solution189 {

	/* 189. Rotate Array:
	 * Rotate an array of n elements to the right by k steps.
	 * 
	 * Input: [1, 2, 3, 4, 5, 6, 7], k = 3
	 * Output: [5, 6, 7, 1, 2, 3, 4]
	 * Complexity: Time O(n) Space O(1)
	 */
	public static void rotate(int[] nums, int k){
		
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		
		/* 
		int[] temp = new int[k];
		for (int i = 0; i < k; i++){
			temp[i] = nums[nums.length - k + i];
		}
		
		// Bug here!!!
		for (int i = nums.length - 1; i > nums.length - k - 2; i--){
			nums[i] = nums[i-k];
		}
		
		for (int i = 0; i < k; i++){
			nums[i] = temp[i];
		}
		*/
	}
	
	public static void reverse(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
