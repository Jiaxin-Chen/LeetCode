/*
127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Example:
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

public class LC127{

	// Time Limited Exceed... 
	public int ladderLength(String beginWord, String endWord, List<String> wordList){
		List<String> reached = new ArrayList<String>();
		reached.add(beginWord);

		int len = 1;
		while(!reached.contains(endWord)){
			List<String> toAdd = new ArrayList<String>();
			for(String each : reached){
				for(int i = 0; i < each.length(); i++){
					char[] chars = each.toCharArray();
					for(char ch = 'a'; ch <= 'z'; ch++){
						chars[i] = ch;
						String word = new String(chars);
						if(wordList.contains(word)){
							toAdd.add(word);
							wordList.remove(word);
						}
					}
				}
			}
			
			if(toAdd.size() == 0)
				return 0;
			len++;
			reached = toAdd;
		}
		return len;
	}

	// Time Complexity: ...?
	// Runtime: 38ms, beats 92.42%
	public int ladderLength2(String beginWord, String endWord, List<String> wordList){
		Set<String> dict = new HashSet<>(wordList), visit = new HashSet<>();
		Set<String> start = new HashSet<>(), end = new HashSet<>();
		start.add(beginWord);
		if(dict.contains(endWord)){
			end.add(endWord);
		}

		for(int len = 2; !start.isEmpty(); len++){
			 Set<String> nq = new HashSet<>();
			 for(String word : start){
			 	for(int i = 0; i < word.length(); i++){
			 		char[] chars = word.toCharArray();
			 		for(char ch = 'a'; ch <= 'z'; ch++){
			 			if(ch == word.charAt(i))
			 				continue;
			 			chars[i] = ch;
			 			String tmp = String.valueOf(chars);
			 			if(end.contains(tmp))
			 				return len;
			 			if(dict.contains(tmp) && visit.add(tmp))
			 				nq.add(tmp);
			 		}
			 	}
			}
			start = (nq.size() < end.size()) ? nq : end;
			end = (start == nq) ? end : nq;
		}
		return 0;
	}

	// Runtime: 33ms, beats 97.51%
	public int ladderLength3(String beginWord, String endWord, List<String> wordAsList) {
        if(!wordAsList.contains(endWord)) 
        	return 0;
        
        Set<String> wordList = new HashSet<String>(wordAsList);
        Set<String> start = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        int length = 1;
        start.add(beginWord); end.add(endWord);
        wordList.remove(beginWord); wordList.remove(endWord);
        
        while(!start.isEmpty()){
            Set<String> next = new HashSet<String>();
            for(String word: start){
                char[] wordArray = word.toCharArray();
                for(int i=0; i<word.length(); i++){
                    char old = wordArray[i];
                    for(char ch='a'; ch<='z'; ch++){
                        wordArray[i] = ch;
                        String str = String.valueOf(wordArray);
                        if(end.contains(str))
                            return length+1;
                        if(wordList.contains(str)){
                            next.add(str);
                            wordList.remove(str);
                        }
                    }
                    // Restore the original word for next ch iteration test
                    wordArray[i] = old;
                }
            }
            // What the hell of this.....
            start = next.size() < end.size() ? next: end;
            end = start.size() < end.size() ? end : next;
            length++;
        }
        return 0;
    }

	public static void main(String[] args){
		List<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		//wordList.add("cog");

	
		String beginWord = "hit";
		String endWord = "cog";

		LC127 x = new LC127();
		int length = x.ladderLength3(beginWord, endWord, wordList);
		System.out.println(length);
	}
}