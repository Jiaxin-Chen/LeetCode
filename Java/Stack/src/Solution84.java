import java.util.*;

public class Solution84 {
	/* 84. Largest Rectangle in Histogram:
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
	 * find the area of largest rectangle in the histogram.
	 * 
	 * Input: [2, 1, 5, 6, 2, 3]
	 * Output: 10
	 */
	
	public int largestRectangleArea(int[] heights){
		if(heights == null || heights.length == 0){
			return 0;
		}
		
		
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		
		for(int i = 0; i <= heights.length; i++){
			int heightBound = (i == heights.length) ? 0 : heights[i];
			
			while(!stack.isEmpty()){
				int h = heights[stack.peek()];
				
				// Calculate the area for the ascending slope
				if(h < heightBound){
					break;
				}
				stack.pop();
				
				int idxBound = stack.isEmpty() ? -1 : stack.peek();
				maxArea = Math.max(maxArea, h * ((i - 1) - idxBound));
			}		
			stack.push(i);
		}
		return maxArea;
	}
	
	public static void main(String[] args){
		int[] heights = {1, 1};
		Solution84 res = new Solution84();
		System.out.println(res.largestRectangleArea(heights));
	}
}
