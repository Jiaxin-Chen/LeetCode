/*
378. Kth Smallest Element in a Sorted Matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

import java.util.*;

class LC378{
	// Binary Search
	// Time Complexity: O(mnlog(mn))
	public int kthSmallest(int[][] matrix, int k) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m-1][n-1];

        // range [low, high]
        while(low < high){
        	int mid = low + (high - low) / 2;
        	int count = 0, j = n - 1;
        	for(int i = 0; i < m; i++){
        		while(j >= 0 && matrix[i][j] > mid){
        			j--;
        		}
        		count += j + 1;
        	}
        	// we cannot return mid if count == k, because maybe mid doesn't exist
        	// we can only narrow the range and return low
        	if(count < k){
        		low = mid + 1;
        	}else{
        		high = mid;
        	}
        }
        return low;
	}

//-------------------------------------------------------------------------------------
	// Optimization: heap, similar ways in LC373
	// Time Complexity: O(NlogN + klogk)
	// Runtime: 104ms, beats 7.83%
	public int kthSmallest2(int[][] matrix, int k){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (matrix[a[0]][a[1]] - matrix[b[0]][b[1]]));

        for(int j = 0; j < n && j < k; j++){ //Runtime: 104ms -> 97ms, Time Complexity: O(NlogN + klogk) -> O(klogk)
        //for(int j = 0; j < n; j++){
        	queue.offer(new int[]{0, j});
        }
        k--;
        while(k-- > 0 && !queue.isEmpty()){
        	int[] cur = queue.poll();
        	if(cur[0] == m - 1){
        		continue;
        	}
        	queue.offer(new int[]{cur[0] + 1, cur[1]});
        }
        int[] res = queue.poll();
        return matrix[res[0]][res[1]];
	}


	public static void main(String[] args){
		LC378 obj = new LC378();
		int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
		int k = 8;
		System.out.println(obj.kthSmallest2(matrix, k));
	}
}