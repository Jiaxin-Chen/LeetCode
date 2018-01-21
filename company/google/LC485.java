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

class LC485{
	// Time Complexity: O(N)
	// Runtime: 10ms, beats 43.43%
	 public int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0;
        int idx = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                maxNum = Math.max(maxNum, i - idx);
            }else{
                idx = i;  // update the new idx if nums[i] = 0
            }
        }
        return maxNum;
    }

    public static void main(String[] args){
    	LC485 x = new LC485();
    	int[] nums = {1, 1, 0, 1, 1, 1};
    	System.out.println(x.findMaxConsecutiveOnes(nums));
    }
}