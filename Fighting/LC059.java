/*
59. Spiral Matrix II

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
Given n = 3, you should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

public class LC059{

	// Time Complexity: O(N^2)
	// Runtime: 2ms, beats 67.31%
	public int[][] generateMatrix(int n){

		int[][] matrix = new int[n][n];
		if(n == 0){
			return matrix;
		}

		int rowStart = 0, rowEnd = n - 1;
		int colStart = 0, colEnd = n - 1;
		int num = 1;

		while(rowStart <= rowEnd && colStart <= colEnd){
			// Traverse row from left to right
			for(int j = colStart; j <= colEnd; j++){
				matrix[rowStart][j] = num;
				num++;
			}
			rowStart++;

			// Traverse col from top to bottom
			for(int i = rowStart; i <= rowEnd; i++){
				matrix[i][colEnd] = num;
				num++;
			}
			colEnd--;

			// Traverse row from right to left
			for(int j = colEnd; j >= colStart; j--){
				matrix[rowEnd][j] = num;
				num++;
			}
			rowEnd--;

			// Traverse col from bottom to top
			for(int i = rowEnd; i >= rowStart; i--){
				matrix[i][colStart] = num;
				num++;
			}
			colStart++;
		}
		return matrix;
	}

	public static void main(String[] args){
		int n = 0;
		LC059 x = new LC059();

		int[][] matrix = x.generateMatrix(n);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}