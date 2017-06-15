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

public class LC131{
	public List<List<String>> partition(String s){
		List<List<String>> res = new LinkedList<>();
		if(s.equals(""))
			return res;
		backtracking(res, new LinkedList<String>(), s, 0);
		return res;
	}

	private void backtracking(List<List<String>> res, List<String> list, String s, int start){
		if(start == s.length())
			res.add(new LinkedList<String>(list));
		else{
			for(int end = start; end < s.length(); end++){
				if(isPalindrome(s, start, end)){
					list.add(s.substring(start, end));
					backtracking(res, list, s, end + 1);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end){
		while(start <= end){
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}


	public static void main(String[] args){
		LC131 x = new LC131();
		String s = "aab";
		List<List<String>> res = x.partition(s);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}
}