/*
485. Max Consecutive Ones

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    		 The maximum number of consecutive 1s is 3.

Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
*/

public class LC485{
	// Time Complexity: O(N)
	// Runtime: 11ms, beats 56.38%
	public int findMaxConsecutiveOnes(int[] nums){
		if(nums.length == 0)
			return 0;

		int maxLen = 0, maxCur = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 1)
				maxCur++;
			else
				maxCur = 0;
			maxLen = Math.max(maxLen, maxCur);
		}

		return maxLen;
	}

	public static void main(String[] args){
		int[] nums = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1};
		LC485 x = new LC485();
		int res = x.findMaxConsecutiveOnes(nums);
		System.out.println(res);
	}
}