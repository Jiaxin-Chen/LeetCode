/*
16. 3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:
	Given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
import java.util.Arrays;

public class LC016{

	// Time Complexity: O(N^2)
	// Runtime: 39ms, beat 4.17%, so slow!!!!!
	public int threeSumClosest(int[] nums, int target){
		
		if(nums == null || nums.length < 3){
			return 0;
		}
		int res = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			
			int left = i + 1, right = nums.length - 1;
			while(left < right){
				int sum = nums[i] + nums[left] + nums[right];
				if(Math.abs(sum - target) < Math.abs(res - target)){
					res = sum;
				}
				if(sum > target){
					right--;
				}else{
					left++;
				}
			}
		}
		return res;
	}

	// Optimized Version:
	// Time Complexity: O(N^2)
	// Runtime: 20ms, beat 88.78%
	public int threeSumClosest2(int[] nums, int target){
		if(nums == null || nums.length < 3){
			return 0;
		}
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[nums.length - 1];
		for(int i = 0; i < nums.length - 2; i++){
			// Skip the duplicate triplets results
			if(i == 0 || nums[i] != nums[i-1]){
				int left = i + 1, right = nums.length - 1;
				while(left < right){
					int sum = nums[i] + nums[left] + nums[right];
					if(sum > target){
						right--;
						// Skip the duplicate triplets results
						while(left < right && nums[right] == nums[right+1]){
							right--;
						}
					}else if(sum < target){
						left++;
						// Skip the duplicate triplets results
						while(left < right && nums[left] == nums[left-1]){
							left++;
						}
					}else{
						return sum;
					}

					if(Math.abs(sum - target) < Math.abs(res - target)){
						res = sum;
					}
				}
			}
		}
		return res;
	}



	public static void main(String[] args){
		int[] nums = {1, 1, 1, 0};
		int target = 100;

		LC016 x = new LC016();
		int res = x.threeSumClosest2(nums, target);
		System.out.println(res);
	}
}