
public class Solution136 {
	/*
	 * 136. Single Number:
	 * Given an array of integers, every element appears twice except for one. Find that single one.
	 * Complexity: Time O(N), Space O(1)
	 */
	
	public int singleNumber(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			res ^= nums[i];
		}
		
		return res;
	}
	
	
	public static void main(String[] args){
		int[] nums = {222, 111, 222, 3, 12, 111, 3};
		Solution136 res = new Solution136();
		System.out.println(res.singleNumber(nums));
	}
}
