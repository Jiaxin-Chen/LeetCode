/*
85. Maximal Rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/

// Ref: https://leetcode.com/problems/maximal-rectangle/discuss/29054

import java.util.*;

class LC085{
	// Time Complexity: O(MN), Space Complexity: O(MN)
	// Runtime: 16ms, beats 71.32%
	public int maximalRectangle(char[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}

		int m = matrix.length, n = matrix[0].length;

		int[][] height = new int[m][n];  // means from top height[0][j] to heigh[i][j], how many '1' it has
		int[][] left = new int[m][n];    // means at current position, the left bould' idx of the rectangle with height[i], 0 means at this position, no rectangle
		int[][] right = new int[m][n];   // means the right bould index of this rectangle, 'n' means no rectangle

		for(int i = 0; i < m; i++){
			Arrays.fill(right[i], n);
		}

		for(int i = 0; i < m; i++){
			int curLeftIdx = 0, curRightIdx = n;

			for(int j = 0; j < n; j++){
				if(matrix[i][j] == '1'){
					if(i == 0){
						height[0][j] = 1;
					}else{
						height[i][j] = height[i-1][j] + 1;
					}
				}
			}

			for(int j = 0; j < n; j++){
				if(matrix[i][j] == '1'){
					if(i == 0){
						left[0][j] = curLeftIdx;
					}else{
						left[i][j] = Math.max(left[i-1][j], curLeftIdx);
					}
				}else{
					curLeftIdx = j + 1;
				}
			}

			for(int j = n - 1; j >= 0; j--){
				if(matrix[i][j] == '1'){
					if(i == 0){
						right[0][j] = curRightIdx;
					}else{
						right[i][j] = Math.min(right[i-1][j], curRightIdx);
					}
				}else{
					curRightIdx = j;
				}
			}
		}

		int maxArea = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				//System.out.print("height[" + i + "][" + j + "] = " + height[i][j]);
				//System.out.print(", left[" + i + "][" + j + "] = " + left[i][j]);
				//System.out.println(", right[" + i + "][" + j + "] = " + right[i][j]);
				maxArea = Math.max(maxArea, (right[i][j] - left[i][j]) * height[i][j]);
			}
		}
		return maxArea;
	}

	//-------------------------------------------------------------------------------
	// Optimization: 
	// Time Complexity: O(MN), Space Complexity: O(N)
	// Runtime: 11ms, beats 97.94%
	public int maximalRectangle2(char[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}

		int m = matrix.length, n = matrix[0].length;
		int maxArea = 0;

		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		
		Arrays.fill(right, n);

		for(int i = 0; i < m; i++){
			int curLeftIdx = 0, curRightIdx = n;

			for(int j = 0; j < n; j++){
				if(matrix[i][j] == '1'){
					height[j]++;
				}else{
					height[j] = 0;
				}
			}

			for(int j = 0; j < n; j++){
				if(matrix[i][j] == '1'){
					left[j] = Math.max(left[j], curLeftIdx);
				}else{
					left[j] = 0; // we need update left[j] = 0 if current matrix[i][j] = '0'
					curLeftIdx = j + 1;
				}
			}

			for(int j = n - 1; j >= 0; j--){
				if(matrix[i][j] == '1'){
					right[j] = Math.min(right[j], curRightIdx);
				}else{
					right[j] = n; // we need update right[j] = n if current matrix[i][j] = '0'
					curRightIdx = j;
				}
			}

			for(int j = 0; j < n; j++){
				//System.out.print("height[" + j + "] = " + height[j]);
				//System.out.print(", left[" + j + "] = " + left[j]);
				//System.out.println(", right[" + j + "] = " + right[j]);
				maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
			}
		}
		return maxArea;
	}

	public static void main(String[] args){
		LC085 x = new LC085();
		//char[][] matrix = new char[][]{"0001000".toCharArray(), "0011100".toCharArray(), "0111110".toCharArray()};
		char[][] matrix = new char[][]{"10111".toCharArray(), "01010".toCharArray(), "11011".toCharArray(), "11011".toCharArray(), "01111".toCharArray()};
		System.out.println(x.maximalRectangle2(matrix));
	}
}