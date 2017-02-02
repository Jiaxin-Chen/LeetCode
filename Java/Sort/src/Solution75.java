
public class Solution75 {
	/*
	 * 75. Sort Colors
	 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
	 * with the colors in the order red, white and blue.
	 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	 */
	
	public void sortColors(int[] nums){
		int second = nums.length - 1, zero = 0;
		for(int i = 0; i <= second; i++){
			while(nums[i] == 2 && i < second){
				swap(nums, i, second--);
			}
			while(nums[i] == 0 && i > zero){
				swap(nums, i, zero++);
			}
		}
	}
	
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	public static void main(String[] args){
		int[] nums = {0, 1, 2, 2, 2, 0, 1, 1};
		Solution75 res = new Solution75();
		res.sortColors(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
}
