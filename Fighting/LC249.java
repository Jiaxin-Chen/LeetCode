/*
249. Group Shifted Strings

Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/

import java.util.*;

public class LC249{
	// Time Complexity: O(N)
	// Runtime: 8ms, beats 32.88%
	public List<List<String>> groupStrings(String[] strings){
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new TreeMap<>();

		for(String str : strings){
			int offset = str.charAt(0) - 'a';
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < str.length(); i++){
				char ch = (char)(str.charAt(i) - offset);
				if(ch < 'a')
					ch += 26;
				sb.append(ch);
			}
			String key = sb.toString();
			if(!map.containsKey(key)){
				List<String> list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}

		for(String key : map.keySet())
			res.add(map.get(key));

		return res;
	}

	public static void main(String[] args){
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		LC249 x = new LC249();

		List<List<String>> res = x.groupStrings(strings);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + " ");
			System.out.println();
		}
	}
}