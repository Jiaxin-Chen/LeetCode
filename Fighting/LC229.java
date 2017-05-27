/*
229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.
 */

import java.util.*;

public class LC229{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 
	public List<Integer> majorityElement(int[] nums){
		int n = nums.length;
		List<Integer> res = new ArrayList<Integer>();
		if(n == 0)
			return res;
		int num1 = nums[0], num2 = nums[1], count1 = 0, count2 = 0;
		for(int i = 0; i < n; i++){
			if(nums[i] == num1){
				count1++;
			}else if(nums[i] == num2){
				count2++;
			}else if(count1 == 0){
				num1 = nums[i];
				count1 = 1;
			}else if(count2 == 0){
				num2 = nums[i];
				count2 = 1;
			}else{
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for(int i = 0; i < n; i++){
			if(nums[i] == num1)
				count1++;
			else if(nums[i] == num2)
				count2++;
		}

		if(count1 > n / 3)
			res.add(num1);
		if(count2 > n / 3)
			res.add(num2);

		return res;
	}

	public static void main(String[] args){
		int[] nums = {1,2};
		LC229 x = new LC229();
		List<Integer> res = x.majorityElement(nums);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}