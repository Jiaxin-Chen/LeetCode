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

class LC249{
	// Time Complexity: O(NL), N is the strings size, L is the average length of the word
	// Runtime: 8ms, beats 27.81%
	public List<List<String>> groupStrings(String[] strings){
		List<List<String>> res = new LinkedList<>();
		if(strings == null || strings.length == 0){
			return res;
		}

		Map<String, List<String>> map = new HashMap<>(); // <the shift sample key start from 'a', the shifted string list>

		for(String str : strings){
			// get the offset compared with 'a'
			int offset = str.charAt(0) - 'a';

			// shift cur string to start with 'a'
			char[] chars = str.toCharArray();
			for(int i = 0; i < chars.length; i++){
				if(chars[i] - offset < 'a'){
					chars[i] += 26 - offset;
				}else{
					chars[i] -= offset;
				}
			}
			String key = new String(chars);

			// put cur string into this shift sample list
			if(!map.containsKey(key)){
				map.put(key, new LinkedList<String>());
			}
			map.get(key).add(str);
		}

		for(String key : map.keySet()){
			List<String> list = map.get(key);
			Collections.sort(list);
			res.add(new LinkedList<String>(list));
		}
		return res;
	}

	public static void main(String[] args){
		LC249 x = new LC249();
		String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(x.groupStrings(strings));
	}
}