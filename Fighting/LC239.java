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

public class LC239{

	// Time Complexity: O(N)
	// Runtime: 22ms, beats 74.29%
	public int[] maxSlidingWindow(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return new int[0];

		Deque<Integer> queue = new ArrayDeque<>();
		int[] res = new int[nums.length - k + 1];
		int idx = 0;
		for(int i = 0; i < nums.length; i++){
			// remove numbers out of range k
			while(!queue.isEmpty() && queue.peek() < i - k + 1)
				queue.poll();

			// remove smaller numbers in k range
			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
				queue.pollLast();

			queue.offer(i);
			if(i >= k - 1)
				res[idx++] = nums[queue.peek()];
		}
		return res;
	}


	// Time Complexity: O(N)
	// Runtime: 8ms, beats 95.24%
	public int[] maxSlidingWindow2(int[] nums, int k){
		if(nums == null || nums.length == 0)
			return new int[0];

		final int[] slidingMax = new int[nums.length - k + 1];
		final int[] leftMax = new int[nums.length];
		final int[] rightMax = new int[nums.length];
		leftMax[0] = nums[0];
		rightMax[nums.length - 1] = nums[nums.length - 1];

		for(int i = 1; i < nums.length; i++){
			leftMax[i] = (i % k == 0) ? nums[i] : Math.max(leftMax[i-1], nums[i]);

			final int j = nums.length-i-1;
			rightMax[j] = (j % k == 0) ? nums[j] : Math.max(rightMax[j+1], nums[j]);
		}

		for(int i = 0; i < leftMax.length; i++)
			System.out.println(leftMax[i]);
		System.out.println("************");
		for(int i = 0; i < rightMax.length; i++)
			System.out.println(rightMax[i]);
		System.out.println("************");

		for(int i = 0, j = 0; i + k<= nums.length; i++){
			slidingMax[j++] = Math.max(leftMax[i], rightMax[i + k - 1]);
		}
		return slidingMax;
	}

	public static void main(String[] args){
		LC239 x = new LC239();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;

		int[] res = x.maxSlidingWindow(nums, k);
		for(int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}
}