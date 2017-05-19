/*
54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */

import java.util.List;
import java.util.ArrayList;

public class LC054{

	// Time Complexity: O(N^2)
	// Runtime: 2ms, beats 89.85%
	public List<Integer> spiralOrder(int[][] matrix){

		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0){
			return res;
		}

		int rowStart = 0, rowEnd = matrix.length - 1;
		int colStart = 0, colEnd = matrix[0].length - 1;

		while(rowStart <= rowEnd && colStart <= colEnd){

			// Traverse row from left to right
			for(int j = colStart; j <= colEnd; j++){
				res.add(matrix[rowStart][j]);
			}
			rowStart++;

			// Traverse col from top to bottom
			for(int i = rowStart; i <= rowEnd; i++){
				res.add(matrix[i][colEnd]);
			}
			colEnd--;

			// Must add if(rowStart <= rowEnd) to prevent index out of bound
			if(rowStart <= rowEnd){
				// Traverse row from right to left
				for(int j = colEnd; j >= colStart; j--){
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			// Must add if(colStart <= colEnd) to prevent index out of bound
			if(colStart <= colEnd){
				// Traverse col from bottom to top
				for(int i = rowEnd; i >= rowStart; i--){
					res.add(matrix[i][colStart]);
				}
			}
			colStart++;
		}
		return res;
	}

	public static void main(String[] args){
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		LC054 x = new LC054();
		List<Integer> res = x.spiralOrder(matrix);
		for(int i = 0; i < res.size(); i++){
			System.out.print(res.get(i) + " ");
		}
	}
}