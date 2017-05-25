/*
85. Maximal Rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:
Given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/

public class LC085{
	// Time Complexity: O(N^2)
	// Runtime: 15ms, beats 69.15%
	public int maximalRectangle(int[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}

		int m = matrix.length, n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];
		for(int i = 0; i < n; i++){
			right[i] = n;
		}

		int maxArea = 0;

		for(int i = 0; i < m; i++){
			int curLeft = 0, curRight = n;
			//height counts the number of successive '1's above (plus the current one).
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 1){
					height[j]++;
				}else{
					height[j] = 0;
				}
			}

			//The value of left & right means the boundaries of the rectangle 
			// which contains the current point with a height of value height.
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 1){
					left[j] = Math.max(left[j], curLeft);
				}else{
					left[j] = 0;
					curLeft = j + 1;
				}
			}

			for(int j = n - 1; j >= 0; j--){
				if(matrix[i][j] == 1){
					right[j] = Math.min(right[j], curRight);
				}else{
					right[j] = n;
					curRight = j;
				}
			}

			for(int j = 0; j < n; j++){
				maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
			}
		}
		return maxArea;
	}

	public static void main(String[] args){
		int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
		LC085 x = new LC085();
		int maxArea = x.maximalRectangle(matrix);
		System.out.println(maxArea);
	}
}