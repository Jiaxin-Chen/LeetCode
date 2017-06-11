/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

import java.util.*;

public class LC077{
	// Time Complexity: O(N)
	// Runtime: 40ms, beats 35.39%
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<>();
		backtracking(res, new ArrayList<>(), 1, n, k);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> list, int start, int n, int k){
		if(k == 0){
			res.add(new ArrayList<>(list));
		}else{
			for(int i = start; i <= n; ++i){
				list.add(i);
				backtracking(res, list, i + 1, n, k - 1);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args){
		LC077 x = new LC077();
		int n = 4, k = 2;
		List<List<Integer>> res = x.combine(n, k);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}