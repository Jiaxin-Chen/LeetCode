/*
239. Sliding Window Maximum

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

import java.util.*;

class LC239{

	// Time Complexity: O(N)
	// Runtime: 30ms, beats 28.29%
	public int[] maxSlidingWindow(int[] nums, int k){
		if(nums == null || nums.length == 0){
			return new int[0];
		}

		int[] res = new int[nums.length - k + 1];

		// store the idx of the maximum in k ranges
		Deque<Integer> deque = new LinkedList<>();

		for(int i = 0; i < nums.length; i++){
			// remove the number out of the range k
			if(!deque.isEmpty() && deque.peek() < i - k + 1){
				deque.poll();
			}

			// remove the idx of smaller number in k ranges
			while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
				deque.pollLast();
			}


			deque.offer(i);

			if(i - k + 1 >= 0){
				res[i - k + 1] = nums[deque.peek()];
			}
		}
		return res;
	}

	public static void main(String[] args){
		LC239 x = new LC239();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = x.maxSlidingWindow(nums, k);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i] + " ");
		}
	}
}