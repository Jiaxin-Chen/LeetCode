/*
73. Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class LC073{
	// Time Complexity: O(N^2), Space Complexity: O(1)
	// Runtime: 2ms, beats 30.82%
	public void setZeroes(int[][] matrix){
		if(matrix.length == 0){
			return;
		}

		int row = matrix.length, col = matrix[0].length;
		boolean firstRow = false, firstCol = false;

		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j] == 0){
					if(i == 0){
						firstRow = true;
					}
					if(j == 0){
						firstCol = true;
					}
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for(int i = 1; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == 0){
					matrix[i][j] = 0;
				}
			}
			
		}
		
		if(firstCol == true){
			for(int i = 1; i < row; i++){
				matrix[i][0] = 0;
			}
		}
		if(firstRow == true){
			for(int j = 1; j < col; j++){
				matrix[0][j] = 0;
			}
		}
	}

	public static void main(String[] args){
		int[][] matrix = {{1, 1, 3, 4}, {0, 3, 1, 1}, {1, 1, 6, 0}};
		LC073 x =  new LC073();
		x.setZeroes(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}