/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Example:
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class LC042{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 21ms, beats 77.36%
	public int trap(int[] height){
		if(height == null){
			return 0;
		}

		int left = 0, right = height.length - 1;
		int res = 0;
		int maxLeft = 0, maxRight = 0;
		while(left <= right){
			if(height[left] < height[right]){
				if(height[left] >= maxLeft){
					maxLeft = height[left];
				}else{
					res += maxLeft - height[left];
				}
				left++;
			}else{
				if(height[right] >= maxRight){
					maxRight = height[right];
				}else{
					res += maxRight - height[right];
				}
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args){
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		LC042 x = new LC042();
		int res = x.trap(height);
		System.out.println(res);
	}
}