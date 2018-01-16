/*
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class LC003{
	// Time Complexity: O(N)
	// Runtime: 44ms, beats 91.06%
	public int lengthOfLongestSubstring(String s){
		if(s == null || s.length() == 0){
			return 0;
		}

		char[] ch = s.toCharArray();
		int[] map = new int[128];
		int start = 0, end = 0, count = 0, maxLen = 0;

		while(end < s.length()){
			// If map[ch[end]] > 0, it means ch[end] is duplicated now.
			if(map[ch[end]] > 0){
				count++;
			}
			map[ch[end]]++;
			end++;

			// deal with the duplicated cases
			while(count > 0){
				if(map[ch[start]] > 1){
					count--;
				}
				map[ch[start]]--;
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}
		return maxLen;
	}

	public static void main(String[] args){
		LC003 x = new LC003();
		String s = "abcabccbb";
		System.out.println(x.lengthOfLongestSubstring(s));
	}
}