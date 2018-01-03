/*
288. Unique Word Abbreviation

An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
*/

import java.util.*;

class LC288{
	// Runtime: 198ms, beats 96.05%
	private Map<String, String> map;

	// Time Complexity: O(N)
	public LC288(String[] dictionary){
		map = new HashMap<String, String>();
		if(dictionary == null || dictionary.length == 0){
			return;
		}

		// If there is more than one string belong to the same key
        // then the key will be invalid, we set the value to ""
		for(String word : dictionary){
			String abbr = getAbbr(word);
			if(map.containsKey(abbr)){
				if(!map.get(abbr).equals(word))
					map.put(abbr, "");
			}else{
				map.put(abbr, word);
			}
		}
	}

	// Time Complexity: O(N)
	public boolean isUnique(String word){
		String abbr = getAbbr(word);
		return !map.containsKey(abbr) || map.get(abbr).equals(word);
	}

	private String getAbbr(String word){
		if(word.length() < 3){
			return word;
		}
		StringBuilder sb = new StringBuilder();
		int len = word.length();
		sb.append(word.charAt(0) + String.valueOf(len - 2) + word.charAt(len - 1));
		return sb.toString();
	}


	public static void main(String[] args){
		String[] dictionary = new String[]{"deer", "door", "cake", "card" };
		LC288 x= new LC288(dictionary);

		String word = "cane";
		System.out.println(x.isUnique("dear"));
		System.out.println(x.isUnique("cart"));
		System.out.println(x.isUnique("cane"));
		System.out.println(x.isUnique("make"));
	}
}