import java.util.*;

public class Solution242 {
	/* 242. Valid Anagram:
	 * Given two strings s and t, write a function to determine if t is an anagram of s.
	 * Input: s = "anagram", t = "nagaram", Output: true.
	 */
	
	
	// Runtime: 7ms
	public boolean isAnagram1(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		
		int[] count = new int[26];
		for(int i = 0; i < s.length(); i++){
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		
		for(int i = 0; i < 26; i++){
			if(count[i] != 0){
				return false;
			}
		}
		return true;
	}
	
	
	// Runtime: 6ms
	public boolean isAnagram2(String s, String t){
		int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
	}
	
	
	public static void main(String[] args){
		String s = "anagram", t = "nagaram";
		Solution242 res = new Solution242();
		if(res.isAnagram1(s, t)){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}
}
