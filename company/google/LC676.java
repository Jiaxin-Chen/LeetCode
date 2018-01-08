/*
676. Implement Magic Dictionary

Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
*/
import java.util.*;

class MagicDictionary{
	// Trie
	// Time Complexity: O()
	// Runtime: 104ms, beats 92.21%
	class TrieNode{
		TrieNode[] next;
		boolean isWord;
		TrieNode(){
			next = new TrieNode[26];
			isWord = false;
		}
	}

	private TrieNode root;

	public MagicDictionary(){
		root = new TrieNode();
	}

	// Time Complexity: O(N * L), N is the number of the words, L is the average length of the word
	public void buildDict(String[] dict){
		for(String word : dict){
			TrieNode cur = root;
			for(char ch : word.toCharArray()){
				if(cur.next[ch - 'a'] == null){
					cur.next[ch - 'a'] = new TrieNode();
				}
				cur = cur.next[ch - 'a'];
			}
			cur.isWord = true;
		}
	}

	// Time Complexity: O(L * 26 * L) // L is the length of the word
	public boolean search(String word){
		if(word == null || word.length() == 0){
			return false;
		}
		char[] arr = word.toCharArray();
		for(int i = 0; i < arr.length; i++){
			// change every char in the word every time, once find one, return true
			for(char ch = 'a'; ch <= 'z'; ch++){
				if(arr[i] == ch){
					continue;
				}
				char org = arr[i];
				arr[i] = ch;
				String newWord = new String(arr);
				if(isExist(newWord)){
					return true;
				}
				arr[i] = org;
			}
		}
		return false;
	}

	private boolean isExist(String word){
		TrieNode cur = root;
		for(char ch : word.toCharArray()){
			if(cur.next[ch - 'a'] == null){
				return false;
			}
			cur = cur.next[ch - 'a'];
		}
		return cur.isWord;
	}

//--------------------------------------------------------------------------------------------
	// Hash Table
	// Runtime: 110ms, beats 71.70%
	private Map<String, List<int[]>> map;

	public MagicDictionary(){
		map = new HashMap<>();
	}

	// Time Complexity: O(N * L), N is the number of the words, L is the average length of the word
	public void buildDict(String[] dict){
		for(String word : dict){
			for(int i = 0; i < word.length(); i++){
				String key = word.substring(0, i) + word.substring(i + 1);
				int[] pair = new int[]{i, word.charAt(i)};

				List<int[]> val = map.getOrDefault(key, new LinkedList<int[]>());
				val.add(pair);
				map.put(key, val);
			}
		}
	}

	// Time Complexity: O(L * N), L is the average length of the word, N is the size of the val list
	public boolean search(String word){
		for(int i = 0; i < word.length(); i++){
			String key = word.substring(0, i) + word.substring(i + 1);

			if(map.containsKey(key)){
				List<int[]> val = map.get(key);
				for(int[] pair : val){
					if(pair[0] == i && pair[1] != word.charAt(i)){
						return true;
					}
				}
			}
		}


		return false;
	}








}