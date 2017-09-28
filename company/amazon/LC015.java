/*
15. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.*;

public class LC015{

	// Time Complexity: O(N^2)
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		if(nums.length < 2)
			return res;

		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {

			// DONN'T MISS IT!
			// Skip the duplicate triplets results
			if(i > 0 && nums[i] == nums[i - 1])
				continue;

			int left = i + 1, right = nums.length - 1;
			int sum = 0 - nums[i];

			while(left < right) {
				if(nums[left] + nums[right] == sum) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;

					// Skip the duplicate triplets results
					while(left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while(left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				}

				else if(nums[left] + nums[right] < sum) {
					left++;
					// Skip the duplicate triplets results
					while(left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				}

				else if(nums[left] + nums[right] > sum) {
					right--;
					// Skip the duplicate triplets results
					while(left < right && nums[right] == nums[right + 1]) {
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
			System.out.println(res.get(i));
		}
	}
}