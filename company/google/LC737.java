/*
737. Sentence Similarity II

Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, 
if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. 
For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.

Similarity is also symmetric. 
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

class LC737{
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || words1.length != words2.length){
        	return false;
        }

        Map<String, Set<String>> map = new HashMap<>();

        // Build the graph
        for(String[] pair : pairs){
        	map.putIfAbsent(pair[0], new HashSet<String>());
        	map.get(pair[0]).add(pair[1]);
        	map.putIfAbsent(pair[1], new HashSet<String>());
        	map.get(pair[1]).add(pair[0]);
        }

        for(int i = 0; i < words1.length; i++){
        	if(words1[i].equals(words2[i])){
        		continue;
        	}
        	if(!map.containsKey(words1[i])){
        		return false;
        	}
        	if(!dfs(map, words1[i], words2[i], new HashSet<String>())){ // search for the graph
        		return false;
        	}
        }
        return true;
    }

    private boolean dfs(Map<String, Set<String>> map, String word1, String word2, Set<String> visited){
    	Set<String> set = map.get(word1);
    	if(set.contains(word2)){
    		return true;
    	}

    	visited.add(word1); // DO NOT miss to check if we have visited this word!!! Otherwise the code may crash
    	for(String pairWord : set){
    		if(!visited.contains(pairWord) && dfs(map, pairWord, word2, visited)){
    			return true;
    		}
    	}
    	return false;
    }

//--------------------------------------------------------------------------------------------
    // Union-find
    // Time Complexity: O(NlogN)
    // Runtime: 59ms, beats 70.63%
    public boolean areSentencesSimilarTwo2(String[] words1, String[] words2, String[][] pairs){
    	if(words1 == null || words2 == null || words1.length != words2.length){
        	return false;
        }
        Map<String, String> map = new HashMap<>();  // <word, root>

        // Intializatoin: set the root is the word self
        for(String[] pair : pairs){
        	map.putIfAbsent(pair[0], pair[0]);
        	map.putIfAbsent(pair[1], pair[1]);
        }

        // Union: we need get the root of each word and union them
        for(String[] pair : pairs){
        	String root1 = getRoot(pair[0], map);
        	String root2 = getRoot(pair[1], map);
        	if(!root1.equals(root2)){
        		map.put(root1, root2);
        	}
        }


        for(int i = 0; i < words1.length; i++){
        	if(words1[i].equals(words2[i])){
        		continue;
        	}
        	// because we must have put all the pairs into the map, if the word doesn't exist, just return false
        	if(!map.containsKey(words1[i]) || !map.containsKey(words2[i])){
        		return false;
        	}

        	String root1 = getRoot(words1[i], map);
        	String root2 = getRoot(words2[i], map);
        	if(!root1.equals(root2)){
        		return false;
        	}
        }
        return true;
    }

    // find the root
    private String getRoot(String word, Map<String, String> map){
    	while(!word.equals(map.get(word))){

    		map.put(word, map.get(word)); // path compression, which can help the word to find the root quickly
    									  // If we add this, the runtime: 55ms

    		word = map.get(word);
    	}
    	return word;
    }

    public static void main(String[] args){
    	LC737 x = new LC737();
    	String[] words1 = new String[]{"great", "acting", "skills"};
		String[] words2 = new String[]{"fine", "drama", "talent"};
		String[][] pairs = new String[][]{{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
		System.out.println(x.areSentencesSimilarTwo2(words1, words2, pairs));
    }
}