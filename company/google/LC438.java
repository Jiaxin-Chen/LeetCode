/*
438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

import java.util.*;

class LC438{
	// Time Complexity: O(N)
	// Runtime: 13ms, beats 98.66%
	public List<Integer> findAnagrams(String s, String p){
		List<Integer> res = new LinkedList<>();
		if(s == null || s.length() == 0 || p == null || p.length() == 0){
			return res;
		}

		int[] map = new int[128];
		int start = 0, end = 0, count = p.length();
		char[] ch1 = s.toCharArray(), ch2 = p.toCharArray();

		for(int j = 0; j < p.length(); j++){
			map[ch2[j]]++;
		}

		while(end < s.length()){
			if(map[ch1[end]] > 0){
				count--;
			}
			map[ch1[end]]--;
			end++;

			while(count == 0){
				if(end - start == p.length()){
					res.add(start);
				}
				map[ch1[start]]++;
				if(map[ch1[start]] > 0){
					count++;
				}
				start++;
			}
		}
		return res;
	}

	public static void main(String[] args){
		LC438 x = new LC438();
		String s = "abab";
		String p = "ab";
		System.out.println(x.findAnagrams(s, p));
	}
}