/*
127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
*/

import java.util.*;

class LC127{
	// Time Complexity: O(N * L * 26), N is the wordList size, L is average length of word
	// Runtime: TLE...
	public int ladderLength(String beginWord, String endWord, List<String> wordList){
		if(wordList == null || wordList.size() == 0){
			return 0;
		}

		if(beginWord.equals(endWord)){
			return 1;
		}

		Set<String> set = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		int res = 1;

		queue.offer(beginWord);
		set.add(beginWord);

		while(!queue.isEmpty()){
			res++;
			int size = queue.size();
			for(int i = 0; i < size; i++){
				String cur = queue.poll();
				List<String> nextWords = getNextWords(cur, wordList);
				for(String word : nextWords){
					if(word.equals(endWord)){
						return res;
					}
					if(set.contains(word)){
						continue;
					}
					queue.offer(word);
					set.add(word);
				}
			}
		}
		return 0;
	}

	// get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
	private List<String> getNextWords(String word, List<String> wordList){
		List<String> nextWords = new LinkedList<>();

		for(int i = 0; i < word.length(); i++){
			for(char c = 'a'; c <= 'z'; c++){
				String newWord = replace(word, i, c);
				if(wordList.contains(newWord)){
					nextWords.add(newWord);
				}
			}
		}
		return nextWords;
	}

	// replace character of a string at given index to a given character
    // return a new string
	private String replace(String word, int idx, char c){
		char[] chars = word.toCharArray();
		chars[idx] = c;
		return new String(chars);
	}

//-------------------------------------------------------------------------------
	// Optimization: 
	// Time Complexity: O(N * L * 26), N is the wordList size, L is average length of word
	// Runtime: 
	public int ladderLength2(String beginWord, String endWord, List<String> wordList){
		if(wordList == null || wordList.size() == 0){
			return 0;
		}

		if(beginWord.equals(endWord)){
			return 1;
		}

		// we need use wordSet in order to remove the visited word in the wordList, which can reduce the duplicated access
		Set<String> wordSet = new HashSet<>(wordList);
		Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
		
		int res = 1;

		beginSet.add(beginWord);
		endSet.add(endWord);
		// Attention: because we have the beginSet and endSet, we need remove the beginWord and endWord from the wordSet
		wordSet.remove(beginWord);
		wordSet.remove(endWord);

		while(!beginSet.isEmpty() && !endSet.isEmpty()){
			res++;

			// In order to speed up the code further, we can swap the beginSet and endSet to make less traverse
			if(beginSet.size() > endSet.size()){
				Set<String> tmp = beginSet;
				beginSet = endSet;
				endSet = tmp;
			}

			Set<String> nextBeginSet = new HashSet<>();
			System.out.println("beginSet" + beginSet + ", endSet = " + endSet);
			for(String cur : beginSet){				
				char[] chars = cur.toCharArray();

				for(int i = 0; i < chars.length; i++){
					char old = chars[i];

					for(char c = 'a'; c <= 'z'; c++){
						chars[i] = c;
						String newWord = new String(chars);
						if(endSet.contains(newWord)){
							return res;
						}
						if(wordSet.contains(newWord)){
							nextBeginSet.add(newWord);
							wordSet.remove(newWord);
						}	
					}
					chars[i] = old;
				}
			}
			beginSet = nextBeginSet;
		}
		return 0;
	}


	public static void main(String[] args){
		LC127 x = new LC127();
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
		String beginWord = "hit";
		String endWord = "cog";
		System.out.println(x.ladderLength2(beginWord, endWord, wordList));
	}
}