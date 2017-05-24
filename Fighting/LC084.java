/*
84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */

public class LC084{
	// Time Complexity: O(N)
	// Runtime: 5ms, beats 93.73%
	public int largestRectangleArea(int[] heights){
		if(heights.length == 0)
			return 0;

		int[] left = new int[heights.length];
		int[] right = new int[heights.length];
		left[0] = -1; // left[0] must set to -1, because we need guarantee the loop idx >= 0 in line 26
		right[heights.length - 1] = heights.length;

		for(int i = 1; i < heights.length; i++){
			int idx = i - 1;
			while(idx >= 0 && heights[idx] >= heights[i])
				idx = left[idx];
			left[i] = idx;
		}

		for(int i = heights.length - 1; i >= 0; i--){
			int idx = i + 1;
			while(idx < heights.length && heights[idx] >= heights[i])
				idx = right[idx];
			right[i] = idx;
		}

		int maxArea = 0;
		for(int i = 0; i < heights.length; i++){
			maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
		}

		return maxArea;
	}

	public static void main(String[] args){
		int[] heights = {2,1,5,6,2,3};
		LC084 x = new LC084();
		int maxArea = x.largestRectangleArea(heights);
		System.out.println(maxArea);
	}
}