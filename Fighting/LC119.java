/*
119. Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

import java.util.*;

public class LC119{
	public List<Integer> getRow(int rowIndex){
		List<Integer> row = new ArrayList<Integer>();
		if(rowIndex == 0){
			return row;
		}

		for(int i = 0; i < rowIndex; i++){
			row.add(0, 1);
			for(int j = 1; j < row.size() - 1; j++)
				row.set(j, row.get(j) + row.get(j+1));
		}
		return row;
	}

	public static void main(String[] args){
		int rowIndex = 5; 
		LC119 x = new LC119();
		List<Integer> row = x.getRow(rowIndex);
		for(int i = 0; i < row.size(); i++){
			System.out.print(row.get(i) + " ");
		}
	}
}