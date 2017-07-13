/*
244. Shortest Word Distance II

This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. 
How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

import java.util.*;


// Time Complexity: O(N)
// Runtime: 155ms, beats 73.37%
class WordDistance{

	private Map<String, List<Integer>> map;

	public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
        	if(map.containsKey(words[i]))
        		map.get(words[i]).add(i);
        	else{
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(words[i], list);
        	}
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        for(int i = 0; i < list1.size(); i++)
        	System.out.println(list1.get(i));
        for(int i = 0; i < list2.size(); i++)
        	System.out.println(list2.get(i));

        int min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ){
        	int idx1 = list1.get(i), idx2 = list2.get(j);
        	if(idx1 < idx2){
        		min = Math.min(min, idx2 - idx1);
        		i++;
        	}else{
        		min = Math.min(min, idx1 - idx2);
        		j++;
        	}
        }
        return min;
    }
}

public class LC244{
	public static void main(String[] args){
		//LC244 x = new LC244();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes", word2 = "coding";
		WordDistance obj = new WordDistance(words);
		System.out.println(obj.shortest(word1, word2));
	}
}