/*
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example:
Input: "cbbd"
Output: "bb"
 */

public class LC005{
	// Time Complexity: O(N^2)
	// Runtime: 15ms, beats 96.96%
	public String longestPalindrome(String s){
		int len = s.length();
		if(len == 0)
			return "";
		if(len == 1)
			return s;

		char[] ch = s.toCharArray();
		int i = 0, j = 0, k = 0;
		int subStart = 0, maxLen = 0; 
		while(i < len){
			if(len - i <= maxLen / 2)
				break;
			j = i;
			k = i;
			// Handle Duplicates
			while(k < len - 1 && ch[k] == ch[k+1]){
				k++;
			}
			i = k + 1;
			while(k < len - 1 && j > 0 && ch[k+1] == ch[j-1]){
				k++;
				j--;
			}
			//int newLen = k - j + 1;
			if(maxLen < k - j + 1){
				subStart = j;
				maxLen = k - j + 1;
			}
		}
		return s.substring(subStart, subStart + maxLen);
	}

	public static void main(String[] args){
		String s = "babaddabab";
		LC005 x = new LC005();
		String res = x.longestPalindrome(s);
		System.out.println(res);
	}
}