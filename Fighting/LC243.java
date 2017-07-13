/*
243. Shortest Word Distance

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class LC243{
	// Time Complexity: O(N)
	// Runtime: 4ms, beats 18.39%
	public int shortestDistance(String[] words, String word1, String word2){
		int idx1 = -1, idx2 = -1, min = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++){
			if(word1.equals(words[i]))
				idx1 = i;
			if(word2.equals(words[i]))
				idx2 = i;
			if(idx1 != -1 && idx2 != -1)
				min = Math.min(min, Math.abs(idx1 - idx2));
		}
		return min;
	}

	public static void main(String[] args){
		LC243 x = new LC243();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes", word2 = "coding";
		System.out.println(x.shortestDistance(words, word1, word2));
	}
}