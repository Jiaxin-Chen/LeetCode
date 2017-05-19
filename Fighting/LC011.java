/*
11. Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: 
You may not slant the container and n is at least 2.
 */

public class LC011{

	// Time Complexity: O(N)
	// Runtime: 11ms, beats 34.91%
	public int maxArea(int[] height){
		int left = 0, right = height.length - 1;
		int res = 0;

		while(left < right){
			res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
			if(height[left] < height[right]){
				left++;
			}else{
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args){
		int[] height = {3, 6, 1, 8, 9, 4};
		LC011 x = new LC011();
		int res = x.maxArea(height);
		System.out.println(res);
	}
}