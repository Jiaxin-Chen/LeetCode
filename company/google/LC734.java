/*
734. Sentence Similarity

Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, "great acting skills" and "fine drama talent" are similar, 
if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. 
For example, if "great" and "fine" are similar, and "fine" and "good" are similar, 
"great" and "good" are not necessarily similar.

However, similarity is symmetric. 
For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. 
For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. 
So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/

import java.util.*;

class LC734{
	// Time Complexity: O(N)
	// Runtime: 10ms,beats 14.59%
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs){
		if(words1 == null || words2 == null || words1.length != words2.length){
			return false;
		}
		Map<String, Set<String>> map = new HashMap<>();

		for(String[] pair : pairs){
			map.putIfAbsent(pair[0], new HashSet<String>());
			map.get(pair[0]).add(pair[1]);
			//map.get(pair[0]).add(pair[0]);
			map.putIfAbsent(pair[1], new HashSet<String>());
			//map.get(pair[1]).add(pair[1]);
			map.get(pair[1]).add(pair[0]);
		}

		for(int i = 0; i < words1.length; i++){
			if(words1[i].equals(words2[i])){ // we don't have to map.put the same word if we add this condition
                continue;
            }
            if(!map.containsKey(words1[i])){  // we need check if the map contains words1[i] first, otherwise we may obtain empty set, which cause the code crash in line 61
                return false;
            }

			Set<String> pairWords = map.get(words1[i]);
			if(!pairWords.contains(words2[i])){ // may crash if the pairWords == null, so we need check if the map contains words1[i] first,
				return false;
			}
			
		}
		return true;
	}

	public static void main(String[] args){
		LC734 x = new LC734();
		String[] words1 = new String[]{"great", "acting", "skills"};
		String[] words2 = new String[]{"fine", "drama", "talent"};
		String[][] pairs = new String[][]{{"great", "fine"}, {"acting","drama"}, {"skills","talent"}};
		System.out.println(x.areSentencesSimilar(words1, words2, pairs));
	}
}