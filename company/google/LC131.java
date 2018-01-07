/*
131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/

import java.util.*;

class LC131{
	// Time Complexity: O(2^N)
	// Runtime: 11ms, beats 22.51%
	// Time Complexity Proof:
	// T(n)=T(n-1)+T(n-2)+…+T(1)
	// T(n+1)=T(n)+T(n-1)+…+T(1)
	// T(n+1)=2T(n)
	// T(n)=2^n
	public List<List<String>> partition(String s){
		List<List<String>> res = new LinkedList<>();
		backtrack(res, new LinkedList<String>(), s, 0);
		return res;
	}

	private void backtrack(List<List<String>> res, List<String> list, String s, int start){
		if(start == s.length()){
			res.add(new LinkedList<>(list));
			return;
		}
		for(int i = start; i < s.length(); i++){
			//System.out.println(s.substring(start, i + 1));
			if(isPalindrome(s, start, i)){
				list.add(s.substring(start, i + 1));
				backtrack(res, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	// Time Complexity: O(N)
	private boolean isPalindrome(String s, int start, int end){
		while(start < end){
			if(s.charAt(start++) != s.charAt(end--)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		LC131 x = new LC131();
		String s = "aab";
		System.out.println(x.partition(s));
	}
}