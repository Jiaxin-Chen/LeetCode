/*
15. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.

Example:
	Given array S = [-1, 0, 1, 2, -1, -4],
	A solution set is:
	[
  		[-1, 0, 1],
  		[-1, -1, 2]
	]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC015{

	// Time Complexity: O(NlogN)
	// Runtime: 85ms, beat 70.23%
	public List<List<Integer>> threeSum(int[] nums){

		// It's better to declare res first
		// Because if nums == null || nums.length <= 2, we should return res rather than null!!!
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length <= 2){
			return res;
		}

		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){

			// DONN'T MISS IT!
			// Skip the duplicate triplets results
			if(i > 0 && nums[i] == nums[i-1]){
				continue;
			}

			int left = i + 1, right = nums.length - 1;
			int sum = 0 - nums[i];
			while(left < right){
				if(nums[left] + nums[right] == sum){
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					// Skip the duplicate triplets results
					while(left < right && nums[left] == nums[left-1]){
						left++;
					}
					while(left < right && nums[right] == nums[right+1]){
						right--;
					}
				}else if(nums[left] + nums[right] < sum){
					left++;
				}else{
					right--;
				}

			}
		}
		return res;
	}


	// Worse Version:
	// Time Complexity: O(N^2)
	// Runtime: 107ms, beat 28.49%
	public List<List<Integer>> threeSum2(int[] nums){

		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length <= 2){
			return res;
		}

		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){

			// DONN'T MISS IT!
			// Skip the duplicate triplets results
			if(i > 0 && nums[i] == nums[i-1]){
				continue;
			}

			int left = i + 1, right = nums.length - 1;
			int sum = 0 - nums[i];
			while(left < right){
				if(nums[left] + nums[right] == sum){
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					// Skip the duplicate triplets results
					while(left < right && nums[left] == nums[left-1]){
						left++;
					}
					while(left < right && nums[right] == nums[right+1]){
						right--;
					}
				}else if(nums[left] + nums[right] < sum){
					left++;
					// Try to optimize to skip the duplicate triplets results, but maybe add too many loops and conditions...
					while(left < right && nums[left] == nums[left-1]){
						left++;
					}
				}else{
					right--;
					// Try to optimize to skip the duplicate triplets results, , but maybe add too many loops and conditions...
					while(left < right && nums[right] == nums[right+1]){
						right--;
					}
				}

			}
		}
		return res;
	}


	public static void main(String[] args){
		int[] nums = {-1, 0, 1, 2, -1, -4};
		LC015 x = new LC015();
		List<List<Integer>> res = x.threeSum(nums);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < 3; j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}