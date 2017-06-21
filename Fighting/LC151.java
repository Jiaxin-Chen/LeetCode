/*
151. Reverse Words in a String

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

For C programmers: Try to solve it in-place in O(1) space.
 */

public class LC151{
	// Time Complexity: O(N)
	// Runtime: 10ms, beats 49.07%
	public String reverseWords(String s){
		if(s.length() == 0)
			return s;

		String[] words = s.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i = words.length - 1; i > 0; i--)
			sb.append(words[i] + " ");
		sb.append(words[0]);
		return sb.toString();
	}

	public static void main(String[] args){
		String s = " the sky is blue";
		LC151 x = new LC151();
		System.out.println(x.reverseWords(s));
	}
}