/*
242. Valid Anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class LC242{
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 95.34%
	public boolean isAnagram(String s, String t){
		int len1 = s.length(), len2 = t.length();
		if( len1 != len2)
			return false;

		int[] anagram = new int[26];
		char[] ch1 = s.toCharArray(), ch2 = t.toCharArray();
		for(int i = 0; i < len1; i++){
			anagram[ch1[i] - 'a']++;
			anagram[ch2[i] - 'a']--;
		}

		for(int i = 0; i < 26; i++){
			if(anagram[i] != 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args){
		LC242 x = new LC242();
		String s = "cinema", t = "iceman";
		System.out.println(x.isAnagram(s, t));
	}
}