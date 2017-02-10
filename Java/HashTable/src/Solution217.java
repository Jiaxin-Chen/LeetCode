import java.util.*;

public class Solution217 {
	/*
	 * 217. Contains Duplicate:
	 * Given an array of integers, find if the array contains any duplicates. 
	 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
	 */
	
	
	// Primitive version: Runtime 20ms, Time O(N)
	public boolean containDuplicates(int[] nums){
		if(nums == null){
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int num : nums){
			if(!set.contains(num)){
				set.add(num);
			}else{
				return true;
			}
		}
		return false;
	}
	
	// More concise and faster version: Runtime 14ms, Time O(N)
	public boolean containDuplicates2(int[] nums){
		if(nums == null){
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int num : nums){
			if(!set.add(num)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		int[] nums = {122, 32, 43, 122, 2};
		Solution217 res = new Solution217();
		System.out.println(res.containDuplicates(nums));
	}
}
