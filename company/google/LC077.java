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

class LC077{
	// Time Complexity: O(N)
	// Runtime: 41ms, beats 33%
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<>();
        if(n < 1 || k < 1 || n < k){
        	return res;
        }
        backtracking(res, new LinkedList<Integer>(), n, k, 1);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> list, int n, int k, int pos){
    	if(list.size() == k){
    		res.add(new LinkedList<>(list));
    		return;
    	}

    	for(int i = pos; i <= n; i++){
    		
    		list.add(i);
    		backtracking(res, list, n, k, i + 1);
    		list.remove(list.size() - 1);
    	}
    }

    public static void main(String[] args){
    	LC077 x = new LC077();
    	int n = 4, k = 2;
    	System.out.println(x.combine(n, k));
    }
}