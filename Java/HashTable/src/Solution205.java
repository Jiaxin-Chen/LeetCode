import java.util.*;

public class Solution205 {
	/*
	 * 205. Isomorphic Strings:
	 * Given two strings s and t, determine if they are isomorphic.
	 * Two strings are isomorphic if the characters in s can be replaced to get t.
	 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
	 * No two characters may map to the same character but a character may map to itself.
	 * 
	 * Input: "egg", "add", Output: true
	 * Input: "foo", "bar", Output: false
	 * Input: "paper", "title", Output: true
	 */
	
	
	//Original version: Runtime 24ms
	public boolean isIsomorphic(String s, String t){
		if(s == null || s.length() <= 1){
			return true;
		}
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0; i < s.length(); i++){
			char a = s.charAt(i);
			char b = t.charAt(i);
			
			if(!map.containsKey(a)){
				// containsValue() method has O(N) time
				if(!map.containsValue(b))
					map.put(a, b);
				else
					return false;
			}else{
				if(map.get(a).equals(b))
					continue;
				else
					return false;
			}
		}
		return true;
	}
	
	// Faster version: Runtime 9ms
	public boolean isIsomorphic2(String s, String t){
		if(s == null || s.length() <= 1){
			return true;
		}
		
		int[] tmp1 = new int[256], tmp2 = new int[256];
		int len = s.length();
		for(int i = 0; i < len; i++){
			if(tmp1[s.charAt(i)] != tmp2[t.charAt(i)]){
				return false;
			}
			
			tmp1[s.charAt(i)] = i + 1;
			tmp2[t.charAt(i)] = i + 1;
		}
		return true;
	}
	
	public static void main(String[] args){
		String s = "paper", t = "title";
		Solution205 res = new Solution205();
		System.out.println(res.isIsomorphic(s, t));
	}
}
