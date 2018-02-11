/*
692. Top K Frequent Words


Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/
import java.util.*;

class LC692{
	// Time Complexity: O(n log k), space complexity: O(n)
	// Runtime: 110ms, beats 3.20%
	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new LinkedList<>();
        if(words == null || words.length == 0){
        	return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
        	map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = 
        	new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        queue.addAll(map.entrySet());

        while(res.size() < k) {
        	Map.Entry entry = queue.poll();
        	res.add((String) entry.getKey());
        }
        return res;
    }

    public static void main(String[] args){
    	LC692 obj = new LC692();
    	String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
    	int k = 2;
    	System.out.println(obj.topKFrequent(words, k));
    }
}