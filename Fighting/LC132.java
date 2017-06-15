/*
132. Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

import java.util.*;

public class LC132{
	// TLE......
	public int minCut(String s){
		List<Integer> res = new LinkedList<>();
		if(s.equals(""))
			return 0;
		backtracking(res, new LinkedList<String>(), s, 0);
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < res.size(); i++){
			if(res.get(i) < min)
				min = res.get(i);
		}
		return min - 1;
	}

	private void backtracking(List<Integer> res, List<String> list, String s, int start){
		if(start == s.length())
			res.add(list.size());
		else{
			for(int end = start; end < s.length(); end++){
				if(isPalindrome(s, start, end)){
					list.add(s.substring(start, end + 1));
					backtracking(res, list, s, end + 1);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end){
		while(start <= end){
			if(s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}


	// Time Complexity: O(N)
	// Runtime: 19ms, beats 88.87%
	public int minCut2(String s){
		char[] ch = s.toCharArray();
		int n = ch.length;
		int[] cut = new int[n];
		boolean[][] palindrome = new boolean[n][n];

		for(int i = 0; i < n; i++){
			int min = i;
			for(int j = 0; j <= i; j++){
				if(ch[j] == ch[i] && (j + 1 > i - 1 || palindrome[j+1][i-1])){
					palindrome[j][i] = true;
					min = (j == 0) ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[n-1];
	}

	public static void main(String[] args){
		String s = "aab";
		LC132 x = new LC132();
		System.out.println(x.minCut2(s));
	}
}