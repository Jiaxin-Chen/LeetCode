/*
245. Shortest Word Distance III

This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
*/

public class LC245{
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 70.02%
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, min = Integer.MAX_VALUE;

        for(int i = 0; i < words.length; i++){
        	if(word1.equals(word2)){
        		if(word1.equals(words[i])){
        			if(idx1 == -1)
        				idx1 = i;
        			else{
        				min = Math.min(min, i - idx1);
        				idx1 = i;
        			}
        		}
        	}else{
        		if(word1.equals(words[i]))
        			idx1 = i;
        		if(word2.equals(words[i]))
        			idx2 = i;
        		if(idx1 != -1 && idx2 != -1)
        			min = Math.min(min, Math.abs(idx1 - idx2));
        	}
        }

        return min;
    }

	public static void main(String[] args){
		LC245 x = new LC245();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes", word2 = "makes";
		System.out.println(x.shortestWordDistance(words, word1, word2));
	}
}