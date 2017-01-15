import java.util.*;

public class Solution384 {
	private int[] nums;
	private Random random;
	
	public Solution384(int[] nums){
		this.nums = nums;
		random = new Random();
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle(){
		if(nums == null){
			return null;
		}
		int[] new_nums = nums.clone();
		for (int j = 1; j < new_nums.length; j++){
			int i = random.nextInt(j + 1);
			swap(new_nums, i, j);
		}
		return new_nums;
	}
	
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
