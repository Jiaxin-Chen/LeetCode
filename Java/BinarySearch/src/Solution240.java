
public class Solution240 {
	/*
	 * 240. Search a 2D Matrix II:
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	 * Integers in each row are sorted in ascending from left to right.
	 * Integers in each column are sorted in ascending from top to bottom.
	 */
	
	// Time O(m + n)
	public boolean searchMatrix(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0){
			return false;
		}
		
		int row = 0, col = matrix[0].length - 1;

		while(col >= 0 && row < matrix.length){
			if(matrix[row][col] == target){
				return true;
			}else if(matrix[row][col] < target){
				row++;
			}else if(matrix[row][col] > target){
				col--;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{
			 {1,   4,  7, 11, 15},
			 {2,   5,  8, 12, 19},
			 {3,   6,  9, 16, 22},
			 {10, 13, 14, 17, 24},
			 {18, 21, 23, 26, 30}};
		
		int target = 5;
		Solution240 res = new Solution240();
		System.out.println(res.searchMatrix(matrix, target));
	}
}
