/*
49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

import java.util.*;

public class LC049{
	// Time Complexity: O(NlogN)
	// Runtime: 26ms, beats 92.09%
	public List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> res = new ArrayList<>();
		if(strs.length == 0)
			return res;
		Map<String, List<String>> map = new HashMap<>();

		for(String str : strs){
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = String.valueOf(ch);
			if(!map.containsKey(s))
				map.put(s, new ArrayList<String>());
			map.get(s).add(str);
		}
		res = new ArrayList<>(map.values());
		return res;
	}

	public static void main(String[] args){
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		LC049 x = new LC049();
		List<List<String>> res = x.groupAnagrams(strs);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + " ");
			System.out.println();
		}
	}
}