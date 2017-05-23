/*
120. Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

public class LC120{
	// Time Complexity: O(N^2), Space Complexity: O(N)
	// Runtime: 11ms, beats 41.37%
	// From bottom to up!!!!!
	public int minimumTotal(List<List<Integer>> triangle){
		if(triangle.size() == 0)
			return 0;

		int rowNum = triangle.size();
		List<Integer> minPath = triangle.get(rowNum - 1);
		for(int row = rowNum - 2; row >= 0; row--){
			for(int i = 0; i <= row; i++){
				minPath.set(i, Math.min(minPath.get(i), minPath.get(i+1)) + triangle.get(row).get(i));
			}
		}
		return minPath.get(0);
	}
}