/*
62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
*/

public class LC062{
	// Genuis Ref: https://discuss.leetcode.com/topic/15265/0ms-5-lines-dp-solution-in-c-with-explanations
	// Time Complexity: O(N^N)
	// Runtime: 0ms, beats 81.45%
	public int uniquePaths(int m, int n){
		if(m > n){
			return uniquePaths(n, m);
		}

		int[] cur = new int[m];
		for(int i = 0; i < m; i++){
			cur[i] = 1;
		}

		for(int j = 1; j < n; j++){
			for(int i = 1; i < m; i++){
				cur[i] += cur[i-1];
			}
		}
		return cur[m-1];
	}

	public static void main(String[] args){
		int m = 3, n = 7;
		LC062 x = new LC062();
		int res = x.uniquePaths(m, n);
		System.out.println(res);
	}
}