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

class LC216{
	// Time Complexity: O(2^N)
	// Runtime: 2ms, beats 6.81%
	public List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> res = new LinkedList<>();
		if(k < 1 || n < 1){
			return res;
		}
		backtracking(res, new LinkedList<Integer>(), k, n, 1);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> list, int k, int remain, int pos){
		if(remain < 0){
			return;
		}
		if(list.size() == k && remain == 0){
			res.add(new LinkedList<>(list));
		}
		for(int i = pos; i < 10; i++){
			list.add(i);
			backtracking(res, list, k, remain - i, i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args){
		LC216 x = new LC216();
		int k = 3, n = 7;
		System.out.println(x.combinationSum3(k, n));
	}
}