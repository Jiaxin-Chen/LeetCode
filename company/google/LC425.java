/*
425. Word Squares

Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
*/

import java.util.*;


// Runtime: 30ms, beats 96.30%
class LC425{
	class TrieNode{
		TrieNode[] next;
		List<String> prefix;  // store the corresponding words List for cur prefix
		TrieNode(){
			next = new TrieNode[26];
			prefix = new LinkedList<>();
		}
	}

	private TrieNode buildTrie(String[] words){
		TrieNode root = new TrieNode();
		for(String word : words){
			TrieNode cur = root;
			for(char ch : word.toCharArray()){
				int idx = ch - 'a';
				if(cur.next[idx] == null){
					cur.next[idx] = new TrieNode();
				}
				cur.next[idx].prefix.add(word);
				cur = cur.next[idx];
			}
		}
		return root;
	}

	public List<List<String>> wordSquares(String[] words){
		List<List<String>> res = new LinkedList<>();
		if(words == null || words.length == 0){
			return res;
		}
		int len = words[0].length(); // not words.length !!!
		TrieNode root = buildTrie(words);
		List<String> curSquare = new LinkedList<>();

		for(String word : words){
			curSquare.add(word);
			backtracking(root, res, curSquare, len);
			curSquare.remove(curSquare.size() - 1);
		}
		return res;
	}

	private void backtracking(TrieNode root, List<List<String>> res, List<String> curSquare, int len){
		if(curSquare.size() == len){
			res.add(new LinkedList<>(curSquare));
			return;
		}
		int idx = curSquare.size();
		System.out.println("idx = " + idx);
		StringBuilder prefixAtIdxRow = new StringBuilder();
		for(String curWord : curSquare){
			prefixAtIdxRow.append(curWord.charAt(idx));
		}
		System.out.println(prefixAtIdxRow);
		List<String> wordsAtIdxRow = getWordsByPrefix(root, prefixAtIdxRow.toString());
		System.out.println(wordsAtIdxRow);
		for(String word : wordsAtIdxRow){
			curSquare.add(word);
			backtracking(root, res, curSquare, len);
			curSquare.remove(curSquare.size() - 1);
		}
	}

	private List<String> getWordsByPrefix(TrieNode root, String prefixAtIdxRow){
		TrieNode cur = root;
		for(char ch : prefixAtIdxRow.toCharArray()){
			int idx = ch - 'a';
			if(cur.next[idx] == null){
				return new LinkedList<String>();
			}
			cur = cur.next[idx];
		}
		return cur.prefix;
	}

//----------------------------------------------------------------------------

	public List<List<String>> wordSquares3(String[] words){
		List<List<String>> res = new LinkedList<>();
		if(words == null || words.length == 0){
			return res;
		}
		Map<String, List<String>> map = new HashMap<>(); // <prefix, the word list correpsonding to the prefix>
		List<String> curSquare = new LinkedList<>();
		int wordLen = words[0].length();

		initPrefix(words, map);
		dfs(map, res, curSquare, 0, wordLen);
		return res;
	}

	private void initPrefix(String[] words, Map<String, List<String>> map){
		for(String word : words){
			map.putIfAbsent("", new LinkedList<String>());
			map.get("").add(word);

			StringBuilder prefix = new StringBuilder();
			for(char ch : word.toCharArray()){
				prefix.append(ch);
				map.putIfAbsent(prefix.toString(), new LinkedList<>());
				map.get(prefix.toString()).add(word);
			}
		}
	}

	private void dfs(Map<String, List<String>> map, List<List<String>> res, List<String> curSquare, int idx, int wordLen){
		if(curSquare.size() == wordLen){
			res.add(new LinkedList<String>(curSquare));
			return;
		}
		StringBuilder prefixAtIdxRow = new StringBuilder();
		for(String word : curSquare){
			prefixAtIdxRow.append(word.charAt(idx));
		}
		List<String> wordsAtIdxRow = map.get(prefixAtIdxRow.toString());
		System.out.println(wordsAtIdxRow);
		for(String newWord : wordsAtIdxRow){
			if(!isValidWord(map, curSquare, newWord, idx, wordLen)){
				continue;
			}
			curSquare.add(newWord);
			dfs(map, res, curSquare, idx + 1, wordLen);
			curSquare.remove(curSquare.size() - 1);
		}
	}

	// check if the words list of current prefix is valid for the square
	private boolean isValidWord(Map<String, List<String>> map, List<String> curSquare, String newWord, int idx, int wordLen){
		for(int i = idx + 1; i < wordLen; i++){
			StringBuilder prefix = new StringBuilder();
			for(String word : curSquare){
				prefix.append(word.charAt(i));
			}
			prefix.append(newWord.charAt(i));
			if(!map.containsKey(prefix.toString())){
				return false;
			}
		}
		return true;
	}


//-------------------------------------------------------
	/*class TrieNode{
		TrieNode[] next;
		String word;
		TrieNode(){
			next = new TrieNode[26];
			word = "";
		}
	}

	public List<List<String>> wordSquares2(String[] words){
		List<List<String>> res = new LinkedList<>();
		if(words == null || words.length == 0){
			return res;
		}

		// Step 1:
		TrieNode root = buildTrie2(words);

		// Step 2: declare trienode for each row
		int n = words[0].length();
		TrieNode[] nodes = new TrieNode[n];
		for(int i = 0; i < n; i++){
			nodes[i] = root;
		}

		backtracking2(nodes, res, 0, 0, n);
		return res;
	}

	public void backtracking2(TrieNode[] nodes, List<List<String>> res, int row, int col, int n){
		// if we go to the last char, add the ans into the res
		if(row == col && row == n){
			List<String> list = new LinkedList<>();
			for(int i = 0; i < n; i++){
				list.add(nodes[i].word);
			}
			res.add(new LinkedList<>(list));
			return;
		}

		// go from left to right and go down to next row
		if(col < n){
			// traverse the 26 letters to find all the possible char
			for(int i = 0; i < 26; i++){
				if(nodes[row].next[i] != null && nodes[col].next[i] != null){
					TrieNode preRow = nodes[row];
					TrieNode preCol = nodes[col];
					nodes[row] = nodes[row].next[i];

					// prevent from moving the same pointer twice, we have the condition row != col.
					if(row != col){
						nodes[col] = nodes[col].next[i];
					}

					//move to the “right” by giving col+1 for the next DFS step.
					backtracking2(nodes, res, row, col + 1, n);

					// backtracking
					nodes[row] = preRow;
					if(row != col){
						nodes[col] = preCol;
					}
				}
			}
		// reach to the end of the column, and go to the next row
		}else{
			backtracking(nodes, res, row + 1, row + 1, n);
		}
	}

	private TrieNode buildTrie(String[] words){
		TrieNode root = new TrieNode();
		for(String word : words){
			TrieNode cur = root;
			for(char ch : word.toCharArray()){
				if(cur.next[ch - 'a'] == null){
					cur.next[ch - 'a'] = new TrieNode();
				}
				cur = cur.next[ch - 'a'];
			}
			cur.word = word;
		}
		return root;
	}*/

	public static void main(String[] args){
		String[] words = new String[]{"area","lead","wall","lady","ball"};
		LC425 x = new LC425();
		System.out.println(x.wordSquares3(words));
	}
}