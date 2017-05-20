/*
74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example:
Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class LC074{
	// Time Complexity: O(logN)
	// Runtime: 1ms, beats 5.76%
	public boolean searchMatrix(int[][] matrix, int target){
		if(matrix.length == 0){
			return false;
		}

		int m = matrix.length, n = matrix[0].length;
		int start = 0, end = n * m - 1;
		while(start <= end){
			int mid = start + (end - start) / 2;
			int row = mid / n, col = mid % n;
			if(matrix[row][col] == target){
				return true;
			}else if(matrix[row][col] < target){
				start = mid + 1;
			}else{
				/* For case matrix = [[1]], target = 0, 
				 * if we set end = mid, it will lead to the infinite loop. */
				end = mid - 1; 
			}
		}
		return false;
	}




	public static void main(String[] args){
		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		LC074 x = new LC074();
		boolean res = x.searchMatrix(matrix, 3);
		System.out.println(res);
	}
}