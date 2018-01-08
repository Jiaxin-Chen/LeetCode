/*
212. Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

import java.util.*;

class LC212{
	// bruteforce : backtracking
	// Time Complexity: O(MNK * 4^N)
	// Runtime: 815ms, beats 5.78%
	public List<String> findWords(char[][] board, String[] words){
		List<String> res = new LinkedList<>();

		for(String word : words){
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[0].length; j++){
					// avoid duplicates
					if(dfs(board, word, i, j, 0) && !res.contains(word)){
						res.add(word);
					}
				}
			}
		}
		return res;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int idx){
		if(idx == word.length()){
			return true;
		}
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(idx) != board[i][j]){
			return false;
		}

		// Perform a bitwise OR assignment to mark the current cell as visited.
        // The bitwise OR of any character will not be the letter which is
        // currently being looked for.
		board[i][j] ^= 256;
		boolean isExist = dfs(board, word, i + 1, j, idx + 1) ||
						  dfs(board, word, i - 1, j, idx + 1) ||
						  dfs(board, word, i, j + 1, idx + 1) ||
						  dfs(board, word, i, j - 1, idx + 1);
		// Perform a bitwise OR assignment to revert the visited cells to the
        // letter they held previously.  OR(OR(X)) = X
		board[i][j] ^= 256;

		return isExist;
	}

//-----------------------------------------------------------------------------------------------------
	// Time Complexity: O(RC(V + E))
	// We are doing DFS for each of the elements in the grid.
	// Say the dimension of the input is R and C, the trie has E = edges and V= vertices, The time Complexity would be O( RC(V+E))
	// Runtime: 26ms, beats 81.49%
	public List<String> findWords2(char[][] board, String[] words){
		List<String> res = new LinkedList<String>();
		TrieNode root = buildTrie(words);

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				dfs2(board, res, root, i, j);
			}
		}
		return res;
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
				cur = cur.next[idx];
			}
			cur.word = word;
		}
		return root;
	}

	private void dfs2(char[][] board, List<String> res, TrieNode root, int i, int j){
		char ch = board[i][j];

		if(ch == '#' || root.next[ch - 'a'] == null){
			return;
		}
		root = root.next[ch - 'a'];
		if(root.word != null){
			res.add(root.word);
			root.word = null; // avoid duplicates, we cannot return here, because there may be other words in the root.next
		}

		board[i][j] = '#';

		if(i > 0){
			dfs2(board, res, root, i - 1, j);
		}
		if(i < board.length - 1){
			dfs2(board, res, root, i + 1, j);
		}
		if(j > 0){
			dfs2(board, res, root, i, j - 1);
		}
		if(j < board[0].length - 1){
			dfs2(board, res, root, i, j + 1);
		}
		board[i][j] = ch;
	}

	class TrieNode{
		TrieNode[] next = new TrieNode[26];
		String word;
	}


	public static void main(String[] args){
		LC212 x = new LC212();
		char[][] board = new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
		String[] words = new String[]{"oath","pea","eat","rain"};
		
		System.out.println(x.findWords2(board, words));
	}
}