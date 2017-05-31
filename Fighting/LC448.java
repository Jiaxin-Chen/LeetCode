/*
448. Find All Numbers Disappeared in an Array

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
Input: [4,3,2,7,8,2,3,1]
Output: [5,6]
*/

import java.util.*;

public class LC448{
	// Time Complexity: O(N)
	// Runtime: 21ms, beats 28.39%
	public List<Integer> findDisappearedNumbers(int[] nums){
		List<Integer> res = new LinkedList<Integer>();
		if(nums.length == 0)
			return res;

		for(int i = 0; i < nums.length; i++){
			int index = Math.abs(nums[i]) - 1;
			if(nums[index] > 0)
				nums[index] = -nums[index];
		}

		for(int i = 0; i < nums.length; i++){
			if(nums[i] > 0)
				res.add(i + 1);
		}
		return res;
	}

	public static void main(String[] args){
		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		LC448 x = new LC448();
		List<Integer> res = x.findDisappearedNumbers(nums);
		for(int i = 0; i < res.size(); i++){
			System.out.print(res.get(i) + " ");
		}
	}
}