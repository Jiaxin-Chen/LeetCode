/*
216. Combination Sum III

Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:
Input: k = 3, n = 7
Output:
[[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]
 */

import java.util.*;

public class LC216{
	// Time Complexity： O(N)
	// Runtime: 2ms, beats 14.61%
	public List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> res = new ArrayList<>();
		backtracking(res, new ArrayList<Integer>(), k, 1, n);
		return res;
	}

	private void backtracking(List<List<Integer>> res, ArrayList<Integer> list, int k, int start, int n){
		// Must hava n == 0 as the condition, otherwise it will output all the permutation
		if(list.size() == k && n == 0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = start; i <=9; i++){
			list.add(i);
			backtracking(res, list, k, i + 1, n - i);
			list.remove(list.size() - 1);
		}
	}

	// Time Complexity： O(N)
	// Runtime: 1ms, beats 56.10%
	public List<List<Integer>> combinationSum3_v2(int k, int n){
		List<List<Integer>> res = new ArrayList<>();
		backtracking(res, new ArrayList<Integer>(), k, 1, n);
		return res;
	}

	private void backtracking(List<List<Integer>> res, ArrayList<Integer> list, int k, int start, int n){
		// Add condition to make code faster
		if(list.size() > k)
			return;

		// Must hava n == 0 as the condition, otherwise it will output all the permutation
		if(list.size() == k && n == 0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = start; i <= 9 && i <= n; i++){
			list.add(i);
			backtracking(res, list, k, i + 1, n - i);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args){
		int k = 3, n = 9;
		LC216 x = new LC216();
		List<List<Integer>> res = x.combinationSum3(k, n);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < k; j++)
				System.out.print(res.get(i).get(j) + " ");
			System.out.println();
		}
	}
}