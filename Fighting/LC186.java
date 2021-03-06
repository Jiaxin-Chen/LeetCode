/*
186. Reverse Words in a String II

Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
 */

public class LC186{
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 36.28%
	public void reverseWords(char[] s){
		if(s.length <= 1)
			return;
		
		// Reverse the whole string
		reverse(s, 0, s.length - 1);

		// Reverse each word
		int start = 0;
		for(int i = 0; i < s.length; i++){
			if(s[i] == ' '){
				reverse(s, start, i - 1);
				start = i + 1;
			}
		}

		// Corner case: Only one word, so we need reverse the whole word back
		reverse(s, start, s.length - 1);
	}

	private void reverse(char[] s, int start, int end){
		while(start < end){
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args){
		String s = "the sky is blue";
		char[] ch = s.toCharArray();
		LC186 x = new LC186();
		x.reverseWords(ch);
		System.out.println(ch);
	}
}