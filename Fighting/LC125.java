/*
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
 */

public class LC125{
	// Time Complexity: O(N)
	// Runtime: 8ms, beats 73.53%
	public boolean isPalindrome(String s){
		if(s.equals(""))
			return true;

		char[] ch = s.toLowerCase().toCharArray();
		int start = 0, end = ch.length - 1;

		while(start <= end){
			if(ch[start] < '0' || (ch[start] > '9' && ch[start] < 'a') || ch[start] > 'z'){
				start++;
				continue;
			}
			if(ch[end] < '0' || (ch[end] > '9' && ch[end] < 'a') || ch[end] > 'z'){
				end--;
				continue;
			}
			if(ch[start] != ch[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args){
		String s = "ab";
		LC125 x = new LC125();
		System.out.println(x.isPalindrome(s));
	}
}