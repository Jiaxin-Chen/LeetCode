/*
159. Longest Substring with At Most Two Distinct Characters

Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/

class LC159{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 6ms, beats 95.88%
	public int lengthOfLongestSubstringTwoDistinct(String s){
		if(s == null || s.length() < 1){
			return 0;
		}

		char[] ch = s.toCharArray();
		int[] map = new int[128];

		int start = 0, end = 0, minStart = 0, maxLen = 0;
		int count = 0;

		while(end < s.length()){
			if(map[ch[end]] == 0){
				count++;
			}
			map[ch[end]]++;
			end++;

			// When we the valid window out of the k distince range, move start to find the longest window.
			while(count > 2){
				// avoid duplicates
				if(map[ch[start]] == 1){
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
		String s = "eceba";
		LC159 x = new LC159();

		System.out.println(x.lengthOfLongestSubstringKDistinct(s));
	}
}