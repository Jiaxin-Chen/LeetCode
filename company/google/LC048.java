/*
48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
*/


class LC048{

	// key idea: first transpose(matrix[i][j] <-> matrix[j][i]), 
	// if clockwise, then vertical flip
	// if anti-clockwise, then horizontal flip

	// Time Complexity: O(N^2)
	// Runtime: 2ms, beats 51.78%
	public void rotate(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return;
		}

		int n = matrix.length;

		// transpose matrix[i][j] <-> matrix[j][i]
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}


		// clockwise: vertical flip
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n / 2; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n- j - 1] = tmp;
			}
		}


		// anti-clockwise: horizontal flip
		for(int j = 0; j < n; j++){
			for(int i = 0; i < n / 2; i++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = tmp;
			}
		}
	}

	public static void main(String[] args){
		LC048 x = new LC048();

		int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7},{15,14,12,16}};
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		x.rotate(matrix);

		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}