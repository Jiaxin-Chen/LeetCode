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
From [Wikipedia](Originally based on the English alphabet, ASCII encodes 128 specified characters into seven-bit integers) .
*/

/*
1. Use two pointers: start and end to represent a window.
2. Move end to find a valid window.
3. When a valid window is found, move start to find a smaller window.
*/

import java.util.*;

public class LC076{

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
		String str = "ADOBECODEBANC", target = "ABC";
		LC076 x = new LC076();
		String res = x.minWindow(str, target);
		System.out.println(res);
	}




}