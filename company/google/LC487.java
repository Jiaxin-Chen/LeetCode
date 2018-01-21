/*
487. Max Consecutive Ones II

Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    		After flipping, the maximum number of consecutive 1s is 4.

Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

Follow up:
What if the input numbers come in one by one as an infinite stream? 
In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. 
Could you solve it efficiently?
*/

import java.util.*;

class LC487{
	// Generalize the flip number into K
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 14ms, beats 20.70%
	public int findMaxConsecutiveOnes(int[] nums){
		int maxNum = 0;
		int left = 0;
		int k = 1;
		int zeroNum = 0;

		// the range [left, right] contains at most k zeros
		for(int right = 0; right < nums.length; right++){
			if(nums[right] == 0){
				zeroNum++;
			}

			while(zeroNum > k){
				if(nums[left++] == 0){
					zeroNum--;
				}
			}

			maxNum = Math.max(maxNum, right - left + 1);
		}
		return maxNum;
	}

	//----------------------------------------------------------------
	// Follow up:
	// Time Complexity: O(N), Space Complexity: O(k)

	public int findMaxConsecutiveOnes2(int[] nums){
		Queue<Integer> queue = new LinkedList<>();

		int maxNum = 0, left = 0;
		int k = 1;

		// the range [left, right] contains at most k zeros, 
		// so that we know where to move left next when the window contains more than k zero. 
		// If the input stream is infinite, then the output could be extremely large because there could be super long consecutive ones. 
		// In that case we can use BigInteger for all indexes. For simplicity, here we will use int
		for(int right = 0; right < nums.length; right++){
			if(nums[right] == 0){
				queue.offer(right);
			}
			if(queue.size() > k){
				left = queue.poll() + 1;
			}
			maxNum = Math.max(maxNum, right - left + 1);
		}
		return maxNum;
	}

	public static void main(String[] args){
		LC487 x = new LC487();
		int[] nums = new int[]{1, 0, 0, 1, 1, 0};
		System.out.println(x.findMaxConsecutiveOnes2(nums));
	}
}