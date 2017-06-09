/*
58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 */

public class LC058{
	// Time Complexity: O(N)
	// Runtime: 12ms, beats 5.82%
	public int lengthOfLastWord(String s){
		if(s.length() == 0 || s == null)
			return 0;

		String[] words = s.split(" ");
		int res = 0; 
		if(words.length != 0)
		 	res = words[words.length - 1].length();
		return res;
	}

	// Time Complexity: O(N)
	// Runtime: 7ms, beats 32.40%
	public int lengthOfLastWord2(String s){
		if(s.length() == 0 || s == null)
			return 0;
		char[] ch = s.toCharArray();
		int tail = s.length() - 1, res = 0;
		while(tail >= 0 && ch[tail] == ' ')
			tail--;
		while(tail >= 0 && ch[tail] != ' '){
			res++;
			tail--;
		}
		return res;
	}

	public static void main(String[] args){
		LC058 x = new LC058();
		String s = "Hello Word";
		System.out.println(x.lengthOfLastWord2(s));
	}
}