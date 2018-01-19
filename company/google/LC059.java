/*
59. Spiral Matrix II

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class LC059{
	// Time Complexity: O(MN)
	// Runtime: 3ms, beats 7.66%
	public int[][] generateMatrix(int n){
		if(n < 1){
			return new int[0][0];
		}

		int[][] matrix = new int[n][n];

		int rowStart = 0, rowEnd = n - 1;
		int colStart = 0, colEnd = n - 1;

		int num = 1;

		while(rowStart <= rowEnd && colStart <= colEnd){
			// traverse top
			for(int j = colStart; j <= colEnd; j++){
				matrix[rowStart][j] = num++;
			}
			rowStart++;

			// traverse left
			for(int i = rowStart; i <= rowEnd; i++){
				matrix[i][colEnd] = num++;
			}
			colEnd--;

			// traverse bottom
			for(int j = colEnd; j >= colStart; j--){
				matrix[rowEnd][j] = num++;
			}
			rowEnd--;

			// traverse left
			for(int i = rowEnd; i >= rowStart; i--){
				matrix[i][colStart] = num++;
			}
			colStart++;
		}
		return matrix;
	}



	public static void main(String[] args){
		LC059 x= new LC059();
		int n = 3;
		int[][] matrix = x.generateMatrix(n);
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}