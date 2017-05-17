import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* 
Given an array of integers, return indices of the two numbers such that 
they add up to a specific target. You may assume that each input would 
have exactly one solution, and you may not use the same element twice.

Example:
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
*/

public class LC001 {

	// My version:
	// Time Complexity: O(N^2)
	// Runtime: 57ms, beat 10.27%
	public int[] twoSum(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return null;
		}

		int[] res = new int[2];

		for(int i = 0; i < nums.length; i++){
			for(int j = i + 1; j < nums.length; j++){
				if(nums[i] + nums[j] == target){
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return null;
	}


	// Optimized Version:
	// Time Complexity: O(NlogN), because it takes logN time to find element and insert key.
	// Runtime: 10ms, beat 43.55%
	public int[] twoSum2(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return null;
		}

		int[] res = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		return res;
		/*
		int[] result = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < numbers.length; i++) {
        	if (map.containsKey(target - numbers[i])) {
            	result[1] = i + 1;
            	result[0] = map.get(target - numbers[i]);
            	return result;
        	}
        	map.put(numbers[i], i + 1);
    	}
    	return result;
    	*/
	}


	public static void main(String[] args){
		int[] nums = {2, 7, 11, 15};
		int target = 22;

		LC001 x = new LC001();
		int res[] = x.twoSum2(nums, target);

		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}

	}
}
