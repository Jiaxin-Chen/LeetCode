/*
30. Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

import java.util.*;

class LC030{
	// Time Complexity: O(L * N), L is the wordLen, N is the s.length()
	// Runtime: 40ms, beats 61.31%
	public List<Integer> findSubstring(String s, String[] words){

		List<Integer> res = new LinkedList<>();
		if(words == null || words.length == 0 || s.length() == 0){
			return res;
		}

		Map<String, Integer> map = new HashMap<>(); // < word in the words, the count of the word>
		Map<String, Integer> curMap = new HashMap<>();  // <word for cur s, the count of the word>
		int wordLen = words[0].length();

		for(String word : words){
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		for(int i = 0; i < wordLen; i++){
			int start = i, count = 0;
			for(int j = i; j + wordLen <= s.length(); j += wordLen){
				String str = s.substring(j, j + wordLen);
				if(map.containsKey(str)){
					curMap.put(str, curMap.getOrDefault(str, 0) + 1);

					if(curMap.get(str) <= map.get(str)){
						count++;
					}
					// move start
					while(curMap.get(str) > map.get(str)){
						String tmp = s.substring(start, start + wordLen);
						curMap.put(tmp, curMap.getOrDefault(tmp, 0) - 1);
						start += wordLen;

						if(curMap.get(tmp) < map.get(tmp)){
							count--;
						}
					}
					// we find a concatenation
					if(count == words.length){
						res.add(start);
						String tmp = s.substring(start, start + wordLen);
						curMap.put(tmp, curMap.getOrDefault(tmp, 0) - 1);
						start += wordLen;
						count--;
					}
				}else{
					curMap.clear();
					count = 0;
					start = j + wordLen;
				}
			}
			curMap.clear();
		}
		return res;
	}

	public static void main(String[] args){
		LC030 x = new LC030();
		String s = "barfoofoobarthefoobarman";
		String[] words = new String[]{"bar","foo","the"};
		System.out.println(x.findSubstring(s, words));
	}
}