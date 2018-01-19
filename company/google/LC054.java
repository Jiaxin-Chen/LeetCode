/*
54. Spiral Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

import java.util.*;
class LC054{
	// Time Complexity: O(MN)
	// Runtime: 3ms, beats 8.18%
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> res = new LinkedList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return res;
		}

		int rowStart = 0, rowEnd = matrix.length - 1;
		int colStart = 0, colEnd = matrix[0].length - 1;

		while(rowStart <= rowEnd && colStart <= colEnd){
			// traverse top
			for(int j = colStart; j <= colEnd; j++){
				res.add(matrix[rowStart][j]);
			}
			rowStart++;

			// traverse right
			for(int i = rowStart; i <= rowEnd; i++){
				res.add(matrix[i][colEnd]);
			}
			colEnd--;

			// corner case: [[2, 3]], avoid the duplicates if the row = 1 or col = 1
			if(rowStart > rowEnd || colStart > colEnd){
				break;
			}

			// traverse bottom
			for(int j = colEnd; j >= colStart; j--){
				res.add(matrix[rowEnd][j]);
			}
			rowEnd--;

			// traverse left
			for(int i = rowEnd; i >= rowStart; i--){
				res.add(matrix[i][colStart]);
			}
			colStart++;
		}
		return res;
	}

	public static void main(String[] args){
		LC054 x = new LC054();
		//int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = new int[][]{{2, 3}};
		System.out.println(x.spiralOrder(matrix));
	}
}