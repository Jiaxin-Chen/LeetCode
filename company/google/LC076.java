/*
76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

import java.util.*;

class LC076{
	public String minWindow(String s, String t){

		Map<Character, Integer> map = new HashMap<>();
		char[] ch = s.toCharArray();

		for(char c : t.toCharArray()){
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;
		int count = t.length();

		// Move end to find a valid window.
		while(end < s.length()){
			// If s[end] in s exists in t, decrease counter
			if(map.getOrDefault(ch[end], 0) > 0){
				count--;
			}
			// Decrease m[s[end]]. If s[end] does not exist in t, m[s[end]] will be negative.
			map.put(ch[end], map.getOrDefault(ch[end], 0) - 1);
			end++;

			// When we found a valid window, move start to find smaller window.
			while(count == 0){
				if(end - start < minLen){
					minLen = end - start;
					minStart = start;
				}
				map.put(ch[start], map.getOrDefault(ch[start], 0) + 1);
				if(map.get(ch[start]) > 0){
					count++;
				}
				start++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	// Time Complexity: O(N)
	// Runtime: 7ms, beats 74.08%
	public String minWindow(String str, String target){
		int[] map = new int[128];
		char[] s = str.toCharArray(), t = target.toCharArray();
		for(char ch : t){
			map[ch]++;
		}

		// counter represents the number of chars of t to be found in s.
		int start = 0, end = 0, counter = t.length;
		int minStart = 0, minLen = Integer.MAX_VALUE;

		// Move end to find a valid window.
		while(end < s.length){
			// If s[end] in s exists in t, decrease counter
			if(map[s[end]] > 0)
				counter--;
			// Decrease m[s[end]]. If s[end] does not exist in t, m[s[end]] will be negative.
			map[s[end]]--;
			end++;

			// When we found a valid window, move start to find smaller window.
			while(counter == 0){
				if(end - start < minLen){
					minLen = end - start;
					minStart = start;
				}
				map[s[start]]++;
				// When char exists in t, increase counter.
				if(map[s[start]] > 0)
					counter++;
				start++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minStart + minLen);
	}



	public static void main(String[] args){
		LC076 X= new LC076();
		String s= "ADOBECODEBANC", t = "ABC";
		System.out.println(X.minWindow(s, t));
	}
}