/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.
Note: The solution set must not contain duplicate quadruplets.

Example:
	Given array S = [1, 0, -1, 0, -2, 2], and target = 0.
	A solution set is:
	[
	  [-1,  0, 0, 1],
	  [-2, -1, 1, 2],
	  [-2,  0, 0, 2]
	]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC018{

	// Time Complexity: O(N^3)
	// Runtime: 60.84%, beat 60.84%
	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length < 4){
			return res;
		}

		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 3; i++){
			if(i > 0 && nums[i] == nums[i-1]){
				continue;
			}
			// Just utilize the same strategy as threeSum!!!!!
			for(int j = i + 1; j < nums.length - 2; j++){
				if(j > i+1 && nums[j] == nums[j-1]){
					continue;
				}
				int left = j + 1, right = nums.length - 1;
				while(left < right){
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if(sum == target){
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
						while(left < right && nums[left] == nums[left-1]){
							left++;
						}
						while(left < right && nums[right] == nums[right+1]){
							right--;
						}
					}else if(sum < target){
						left++;
					}else{
						right--;
					}
				}

			}
		}
		return res;

	}


	public static void main(String[] args){
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		LC018 x = new LC018();
		List<List<Integer>> res = x.fourSum(nums, target);

		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}