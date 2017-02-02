import java.util.Arrays;

public class Solution164 {
	/* 164. Maximum Gap
	 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
	 * Try to solve it in linear time/space.
	 */
	
	
	/* Runtime: 3ms
	 * Complexity: Time O(N), Space O(N)
	 */	
	public int maximumGap1(int[] nums){
		if(nums.length <= 1){
			return 0;
		}
		
		// Obtain the max and min value of the nums
		int min = nums[0], max = nums[0];
		for(int i = 1; i < nums.length; i++){
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		// Obtain the possible gap, use average gap to reduce scanning times
		int gap = (max - min) / (nums.length - 1);
		if(min == max){
			gap++;
		}
		int length = (max - min) / gap + 1;
		int[] bucketsMax = new int[length];
		int[] bucketsMin = new int[length];
		
		// Put numbers into buckets, we only need the max and min number for each gap interval
		for(int i = 0; i < nums.length; i++){
			int idx = (nums[i] - min) / gap;
			if(nums[i] > bucketsMax[idx]){
				bucketsMax[idx] = nums[i];
			}
			if(bucketsMin[idx] == 0 || nums[i] < bucketsMin[idx]){
				bucketsMin[idx] = nums[i];
			}
		}
		
		// Scan the buckets to find the max gap
		int maxGap = 0;
		for(int i = 0; i < length; i++){
			if(maxGap < bucketsMin[i] - min){
				maxGap = bucketsMin[i] - min;
			}
			if(bucketsMax[i] != 0){
				min = bucketsMax[i];
			}
		}
		return maxGap;
	}
	
	
	public int maximumGap2(int[] nums){
		if(nums.length <= 1){
			return 0;
		}
		
		// Obtain the max and min value of the nums
		int min = nums[0], max = nums[0];
		for(int i = 1; i < nums.length; i++){
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		
		// Obtain the possible gap, use average gap to reduce scanning times
		int gap = (max - min) / (nums.length - 1);
		if(min == max){
			gap++;
		}
		int length = (max - min) / gap + 1;
		int[] bucketsMax = new int[length];
		int[] bucketsMin = new int[length];
		
		// Put numbers into buckets
		for(int i = 0; i < nums.length; i++){
			int idx = (nums[i] - min) / gap;
			bucketsMax[idx] = (nums[i] > bucketsMax[idx]) ? nums[i] : bucketsMax[idx];
			bucketsMin[idx] = (nums[i] < bucketsMin[idx] || bucketsMin[idx] == 0) ? nums[i] : bucketsMin[idx];
		}
		
		// Scan the buckets to find the max gap
		int maxGap = 0, cur = min;
		for(int i = 0; i < length; i++){
			int curGap = bucketsMin[i] - cur;
            maxGap = (maxGap < curGap) ? curGap : maxGap;
            cur = (bucketsMax[i] != 0) ? bucketsMax[i] : cur;
		}
		
		return maxGap;
	}
	
	
	/*
	 * Runtime 4ms
	 * Complexity: Time O(NlogN), Space O(N)
	 */
	public int maximumGap3(int[] nums){
		Arrays.sort(nums);
		int[] gaps = new int[nums.length - 1];
		for(int i = 0; i < gaps.length; i++){
			gaps[i] = nums[i + 1] - nums[i];
		}
		
		int gapMax = Integer.MIN_VALUE;
		for(int i = 0; i < gaps.length; i++){
			gapMax = Math.max(gapMax, gaps[i]);
		}
		return gapMax;
	}
	
	
	public static void main(String[] args){
		Solution164 res = new Solution164();
		int[] nums = {100, 3, 2, 1};
		System.out.println(res.maximumGap1(nums));
	}
}
