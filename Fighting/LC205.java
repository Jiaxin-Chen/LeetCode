/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */

import java.util.*;

public class LC205{
	// Time Complexity: O(N)
	// Runtime: 15ms, beats 67.19%
	public boolean isIsomorphic(String s, String t) {
        if(s.equals("") || s.length() == 0)
        	return true;

        Map<Character, Character> map = new HashMap<Character, Character>();
        char[] ch1 = s.toCharArray(), ch2 = t.toCharArray();
       	for(int i = 0; i < ch1.length; i++){
       		if(map.containsKey(ch1[i])){
       			if(ch2[i] != map.get(ch1[i]))
       				return false;
       		}else{
       			if(map.containsValue(ch2[i]))
       				return false;
       			else
       				map.put(ch1[i], ch2[i]);
       		}
       	}
       	return true;
    }

    // Time Complexity: O(N)
    // Runtime: 3ms, beats 98.71%
    public boolean isIsomorphic2(String s, String t){
    	if(s.equals("") || s.length() == 0)
        	return true;

        int[] a = new int[256];
        int[] b = new int[256];
        char[] ch1 = s.toCharArray(), ch2 = t.toCharArray();

        for(int i = 0; i < ch1.length; i++){
        	if(a[ch1[i]] != b[ch2[i]])
        		return false;
        	a[ch1[i]] = i + 1;
        	b[ch2[i]] = i + 1;
        }
        return true;
    }


    public static void main(String[] args){
    	String s = "ab", t = "aa";
    	LC205 x = new LC205();
    	System.out.println(x.isIsomorphic(s, t));
    }
}