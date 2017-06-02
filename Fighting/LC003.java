/*
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 

Note:
The answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.*;

public class LC003{
	// Time Complexity: O(N)
	// Runtime: 83ms, beats 13.10%
	public int lengthOfLongestSubstring(String s){
		int len = s.length();
		if(len == 0)
			return 0;

		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, max = 0;
		while(i < len){
			if(set.contains(s.charAt(i))){
				set.remove(s.charAt(j++));
			}else{
				set.add(s.charAt(i++));
				max = Math.max(max, set.size());
			}
		}
		return max;
	}

	public int lengthOfLongestSubstring2(String s){
		int len = s.length();
		if(len == 0)
			return 0;

		Set<Character> set = new HashSet<>();
		char[] ch = s.toCharArray();
		int i = 0, j = 0, max = 0;
		while(i < len){
			if(set.contains(ch[i])){
				set.remove(ch[j++]);
			}else{
				set.add(ch[i++]);
				max = Math.max(max, set.size());
			}
		}
		return max;
	}



	public static void main(String[] args){
		LC003 x = new LC003();
		String s = "abcabcbb";
		int res = x.lengthOfLongestSubstring2(s);
		System.out.println(res);
	}
}