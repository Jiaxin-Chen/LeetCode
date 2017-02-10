
public class Solution74 {
	/*
	 * 74. Search a 2D Matrix:
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	 * Integers in each row are sorted from left to right.
	 * The first integer of each row is greater than the last integer of the previous row.
	 * 
	 * Input: [
	 * 			 [1,   3,  5,  7],
	 * 			 [10, 11, 16, 20],
	 * 			 [23, 30, 34, 50]
	 * 								]
	 * 	target = 3
	 * Output: true
	 */
	
	// Time O(logM + logN)
	public boolean searchMatrix(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0){
			return false;
		}
		
		int row = matrix.length, col = matrix[0].length;
		int start = 0, end = row * col - 1, mid = 0;
		while(start <= end){
			mid = start + (end - start) / 2;
			if(matrix[mid / col][mid % col] == target){
				return true;
			}else if(matrix[mid / col][mid % col] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{{1, 2}};
			/*
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 24, 50}};*/
		int target = 2;
		
		Solution74 res = new Solution74();
		System.out.println(res.searchMatrix(matrix, target));
	}
}
