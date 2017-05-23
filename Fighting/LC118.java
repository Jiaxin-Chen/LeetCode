/*
118. Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

import java.util.List;
import java.util.ArrayList;

public class LC118{
	// Time Complexity: O(N^2)
	// Runtime: 1ms, beats 32.30%
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> res = new ArrayList<>();
		if(numRows == 0)
			return res;

		List<Integer> row = new ArrayList<Integer>();
		for(int i = 0; i < numRows; i++){
			row.add(0, 1);
			for(int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j+1));
			res.add(new ArrayList<Integer>(row));
		}
		return res;
	}

	public static void main(String[] args){
		int numRows = 5;
		LC118 x = new LC118();
		List<List<Integer>> res = x.generate(numRows);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}