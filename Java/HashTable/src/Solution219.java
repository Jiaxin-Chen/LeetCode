import java.util.*;

public class Solution219 {
	/*
	 * 219. Contains Duplicate II:
	 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
	 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
	 */
	
	// Runtime 15ms, Time O(N)
	public boolean containsNearbyDuplicate(int[] nums, int k){
		if(nums == null){
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(i > k){
				set.remove(nums[i - k - 1]);
			}
			if(!set.add(nums[i])){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] nums = {122, 32, 43, 122, 2};
		int k = 3;
		Solution219 res = new Solution219();
		System.out.println(res.containsNearbyDuplicate(nums, k));
	}
}
