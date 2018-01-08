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
		String word;
		TrieNode(){
			next = new TrieNode[26];
			word = "";
		}
	}

	public List<List<String>> wordSquares(String[] words){
		List<List<String>> res = new LinkedList<>();
		if(words == null || words.length == 0){
			return res;
		}

		// Step 1:
		TrieNode root = buildTrie(words);

		// Step 2: declare trienode for each row
		int n = words[0].length();
		TrieNode[] nodes = new TrieNode[n];
		for(int i = 0; i < n; i++){
			nodes[i] = root;
		}

		backtracking(nodes, res, 0, 0, n);
		return res;
	}

	public void backtracking(TrieNode[] nodes, List<List<String>> res, int row, int col, int n){
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
					backtracking(nodes, res, row, col + 1, n);

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
	}

	public static void main(String[] args){
		String[] words = new String[]{"area","lead","wall","lady","ball"};
		LC425 x = new LC425();
		System.out.println(x.wordSquares(words));
	}
}