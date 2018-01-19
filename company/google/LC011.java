/*
11. Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

class LC011{
	// Two pointer
	// Time Complexity: O(N)
	// Runtime: 10ms, beats 43.17%
	public int maxArea(int[] height){
		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while(left < right){
			// we need update maxArea first, for the corner case: [1, 1]
			maxArea = Math.max(maxArea, Math.min(height[right], height[left]) * (right - left));

			// just gurantee update the smaller height is enough
			if(height[left] <= height[right]){
				left++;
			}else{
				right--;
			}
		}
		return maxArea;
	}

	// Fail.. We cannot use the LC042 traping water to solve this problem
	// For example: for the case [2, 3, 10, 5, 7, 8, 9], when left = 2 and right = 6, 
	// it will update to right = 5 for the next loop, which means it won't reach to the maxArea min(10, 9)*(6 - 2) = 36
	public int maxArea2(int[] height){
		int left = 0, right = height.length - 1;
		int maxLeftHeight = height[left], maxRightHeight = height[right];
		int maxLeftIdx = left, maxRightIdx = right;
		int maxArea = 0;

		while(left < right){
			
			if(height[left] <= height[right]){
				if(height[left] > maxLeftHeight){
					maxLeftHeight = height[left];
					maxLeftIdx = left;
				}
				left++;
			}
			else{
				if(height[right] > maxRightHeight){
					maxRightHeight = height[right];
					maxRightIdx = right;
				}
				right--;
			}
			maxArea = Math.max(maxArea, Math.min(maxRightHeight, maxLeftHeight) * (maxRightIdx - maxLeftIdx));
			System.out.println("left = " + left + ", maxLeftIdx = " + maxLeftIdx + ", maxLeftHeight = " + maxLeftHeight);	
			System.out.println("right = " + right + ", maxRightIdx = " + maxRightIdx + ", maxRightHeight = " + maxRightHeight);		
			
		}
		return maxArea;
	}

	

	public static void main(String[] args){
		LC011 x = new LC011();

		int[] height = new int[]{2, 3, 10, 5, 7, 8, 9};
		System.out.println(x.maxArea(height));
	}
}