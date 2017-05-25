/*
169. Majority Element

Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

import java.util.*;

public class LC169{
	public int majorityElement1(int[] nums){
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	// Time Complexity: O(N)
	// Runtime: 40ms, beats 10.32%
	public int majorityElement2(int[] nums){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i]) + 1);
			}else{
				map.put(nums[i], 1);
			}

			if(map.get(nums[i]) > nums.length / 2){
				return nums[i];
			}

		}
		return 0;
	}

	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 3ms, beats 46.89%
	// Moore voting algorithm
	public int majorityElement3(int[] nums) {
        int count = 0, res = 0;
        
        for(int num : nums){
            if(count == 0)
                res = num;
            if(num == res)
                count++;
            else
                count--;
        }
        return res;
    }

	public static void main(String[] args){
		int[] nums = {2, 2, 2, 4, 5, 6, 2, 2, 2};
		LC169 x = new LC169();
		int res = x.majorityElement2(nums);
		System.out.println(res);
	}
}