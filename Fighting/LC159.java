/*
159. Longest Substring with At Most Two Distinct Characters

Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
For example, Given s = “eceba”,
T is "ece" which its length is 3.
 */

import java.util.*;

public class LC159{
	// Time Complexity: O(N)
	// Runtime: 29ms, beats 47.54%
	public int lengthOfLongestSubstringTwoDistinct(String s){
		if(s.length() < 1)
			return 0;

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0, right = 0, maxLen = 0;

		char[] ch = s.toCharArray();
		while(right < s.length()){
			if(map.size() <= 2){
				// The same key will be covered 
				map.put(ch[right], right);
				right++;
			}
			if(map.size() > 2){
				int leftMost = ch.length;
				for(int i : map.values())
					leftMost = Math.min(leftMost, i);

				map.remove(ch[leftMost]);
				left = leftMost + 1;
			}
			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;
	}


	public static void main(String[] args){
		String s = "eceba";
		LC159 x = new LC159();
		int maxLen = x.lengthOfLongestSubstringTwoDistinct(s);
		System.out.println(maxLen);
	}
}