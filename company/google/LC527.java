/*
527. Word Abbreviation

Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.

Begin with the first character and then the number of characters abbreviated, which followed by the last character.
If there are any conflict, that is more than one words share the same abbreviation, 
a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. 
In other words, a final abbreviation cannot map to more than one original words.

If the abbreviation doesn't make the word shorter, then keep it as original.

Example:
Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
Note:
Both n and the length of each word will not exceed 400.
The length of each word is greater than 1.
The words consist of lowercase English letters only.
The return answers should be in the same order as the original array.
*/

import java.util.*;

class LC527{
	// Time Complexity: O(NlogN)
	// Runtime: 65ms, beats 32.84%
	public List<String> wordsAbbreviation(List<String> dict){
		int len = dict.size();
		String[] res = new String[len];
		int[] prefix = new int[len];
		

		for(int i = 0; i < len; i++){
			res[i] = getAbbr(dict.get(i), 1);
			prefix[i] = 1;
		}

		for(int i = 0; i < len; i++){
			while(true){
				Set<Integer> set = new HashSet<>();
				for(int j = i + 1; j < len; j++){
					if(res[i].equals(res[j])){
						set.add(j);
					}
				}
				if(set.isEmpty()){
					break;
				}
				set.add(i);
				for(int k : set){
					prefix[k] += 1;
					res[k] = getAbbr(dict.get(k), prefix[k]);
				}
			}
			
		}

		return Arrays.asList(res);
	}

	private String getAbbr(String word, int k){
		if(k >= word.length() - 2){
			return word;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(word.substring(0, k));
		sb.append(word.length() - k - 1);
		sb.append(word.charAt(word.length() - 1));
		return sb.toString();
	}

//---------------------------------------------------------------------------
	// Time Complexity: O(n(2L+1))
	// The time complexity will be O(nL) for building trie, O(nL) to resolve conflicts, O(n) to group words. 
	// So the time complexity will be O(n(2L + 1). 
	// n is the number of words, and L is the average length of each words.
	// Runtime: 107ms, beats 9.96%
	private class Trie{
		int count = 0;
		Map<Character, Trie> next = new HashMap<>();
	}


	public List<String> wordsAbbreviation2(List<String> dict){
		Map<String, List<Integer>> abbrMap = new HashMap<>();

		// 1) create result set
		List<String> res = new ArrayList<>(Collections.nCopies(dict.size(), null));

		// 2) Group all words with the same shortest abbreviation. For example:
        // "internal", "interval" => grouped by "i6l"
        // "intension", "intrusion" => grouped by "i7n"
        // "god" => grouped by "god"
        // we can notice that only words with the same length and the same start
        // and end letter could be grouped together
		for(int i = 0; i < dict.size(); i++){
			String word = dict.get(i);
			String abbr = getShortestAbbr(word);
			List<Integer> pos = abbrMap.get(abbr);

			if(pos == null){
				pos = new ArrayList<>();
				abbrMap.put(abbr, pos);
			}
			pos.add(i);
		}

		// 3) Resolve conflicts in each group
		for(Map.Entry<String, List<Integer>> entry : abbrMap.entrySet()){
			String abbr = entry.getKey();
			List<Integer> posIdx = entry.getValue();
			resolve(dict, res, abbr, posIdx);
		}
		return res;
	}

	private String getShortestAbbr(String s){
		if(s.length() <= 3){
			return s;
		}else{
			return s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1);
		}
	}

	/**
     * To resolve conflicts in a group, we could build a trie for all the words
     * in the group. The trie node will contain the count of words that has the
     * same prefix. Then we could use this trie to determine when we could resolve
     * a conflict by identifying that the count of words in that trie node will only
     * have one word has the prefix.
     */
	private void resolve(List<String> dict, List<String> res, String abbr, List<Integer> posIdx){
		if(posIdx.size() == 1){
			res.set(posIdx.get(0), abbr);
		}else{
			Trie trie = buildTrie(dict, posIdx);
			for(int pos : posIdx){
				String word = dict.get(pos);
				Trie cur = trie;

				// while loop to find the trie node which only has the 1 word which has
                // the prefix. That means in that position, only current word has that
                // specific character.
				int i = 0, n = word.length();
				while(i < n && cur.next.get(word.charAt(i)).count > 1){
					cur = cur.next.get(word.charAt(i));
					i++;
				}
				if(i >= n - 3){
					res.set(pos, word);
				}else{
					String pre = word.substring(0, i+1);
					String newAbbr = pre + (n - i - 2) + "" + word.charAt(n-1);
					res.set(pos, newAbbr);
				}
			}
		}
	}

	private Trie buildTrie(List<String> dict, List<Integer> posIdx){
		Trie root = new Trie();
		for(int pos : posIdx){
			String word = dict.get(pos);
			Trie cur = root;
			for(int i = 0; i < word.length(); i++){
				char ch = word.charAt(i);
				if(cur.next.containsKey(ch)){
					cur = cur.next.get(ch);
				}else{
					Trie next = new Trie();
					cur.next.put(ch, next);
					cur = next;
				}
				cur.count++;
			}
		}
		return root;
	}


	public static void main(String[] args){
		LC527 x = new LC527();
		String[] dictionary = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
		List<String> dict = Arrays.asList(dictionary);
		System.out.println(x.wordsAbbreviation2(dict));
	}
}

