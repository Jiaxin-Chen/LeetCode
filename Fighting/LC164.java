/*
164. Maximum Gap

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Try to solve it in linear time/space.
Return 0 if the array contains less than 2 elements.
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */

public class LC164{
	// Time Complexity: O(N)
	// Runtime: 5ms, beats 66.84%
	public int maximumGap(int[] nums){
		if(nums.length == 0)
			return 0;
		int len = nums.length;
		int[] bucketMax = new int[len - 1];
		int[] bucketMin = new int[len - 1];
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; 

		for(int num : nums){
			max = Math.max(max, num);
			min = Math.min(min, num);
		}

		for(int i = 0; i < len - 1; i++){
			bucketMax[i] = Integer.MIN_VALUE;
			bucketMin[i] = Integer.MAX_VALUE;
		}

		int gap = (int)Math.ceil((double)(max - min) / (len - 1));
		for(int num : nums){
			// Handle the corner case to avoid index out of boundary.
			if(num == min || num == max)
				continue;
			
			int idx = (num - min) / gap;
			bucketMax[idx] = Math.max(num, bucketMax[idx]);
			bucketMin[idx] = Math.min(num, bucketMin[idx]);
		}

		int maxGap = Integer.MIN_VALUE;
		int prev = min;
		for(int i = 0; i < len - 1; i++){
			if(bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE)
				continue;
			maxGap = Math.max(maxGap, bucketMin[i] - prev);
			prev = bucketMax[i];
		}
		maxGap = Math.max(maxGap, max - prev);
		return maxGap;
	}
}