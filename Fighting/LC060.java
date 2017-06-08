/*
60. Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

import java.util.*;

public class LC060{
	// Time Complexity: O(N)
	// Runtime: 25ms, beats 10.85%
	public String getPermutation(int n, int k){
		int pos = 0;
		List<Integer> nums = new ArrayList<>();
		int[] factorial = new int[n+1];
		StringBuilder sb = new StringBuilder();

		int sum = 1;
		factorial[0] = 1;
		for(int i = 1; i <= n; i++){
			sum *= i;
			factorial[i] = sum;
		}
		for(int i = 1; i <= n; i++)
			nums.add(i);

		k--;

		for(int i = 1; i <=n; i++){
			int idx = k / factorial[n-i];
			sb.append(String.valueOf(nums.get(idx)));
			nums.remove(idx);
			k -= idx * factorial[n-i];
		}
		return sb.toString();
	}

	public static void main(String[] args){
		int n = 4, k = 14;
		LC060 x = new LC060();
		String res = x.getPermutation(n, k);
		System.out.println(res);
	}



}