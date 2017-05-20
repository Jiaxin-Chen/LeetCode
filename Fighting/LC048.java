/*
48. Rotate Image

You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

Example:
[					[					[
	[1, 2, 3]			[7, 8, 9]			[7, 4, 1]
	[4, 5, 6]	->		[4, 5, 6]	->		[8, 5, 2]
	[7, 8, 9]			[1, 2, 3]			[9, 6, 3]
]					]					]
*/

public class LC048{

	//Time Complexity: O(N^2)
	//Runtime: 3ms, beats 22.75%
	public void rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length == 1){
			return;
		}

		int n = matrix.length;
		int m = n / 2;
		int tmp;

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				tmp = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][j];
				matrix[n-i-1][j] = tmp;
			}
		}

		
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				if(i == j){
					continue;
				}
				tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}

	public static void main(String[] args){
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int len = matrix.length;
		LC048 x = new LC048();
		x.rotate(matrix);
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}