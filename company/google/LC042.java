/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/

class LC042{
	// Two pointer:  instead of calculating area by height*width, we can think it in a cumulative way. 
	// In other words, sum water amount of each bin(width=1).
	
	// Time Complexity: O(N), Space complexity: O(1)
	// Runtime: 21ms, beats 51.05%
	public int trap(int[] height){
		if(height.length <= 2){
			return 0;
		}

		int left = 0, right = height.length - 1;
		int maxLeftHeight = 0, maxRightHeight = 0;
		int area = 0;

		while(left < right){
			if(height[left] <= height[right]){
				if(height[left] < maxLeftHeight){
					area += maxLeftHeight - height[left];
				}else{
					maxLeftHeight = height[left];
				}
				left++;
			}
			else{
				if(height[right] < maxRightHeight){
					area += maxRightHeight - height[right];
				}else{
					maxRightHeight = height[right];
				}
				right--;
			}
		}
		return area;
	}

	public static void main(String[] args){
		LC042 x = new LC042();
		int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(x.trap(height));
	}
}
