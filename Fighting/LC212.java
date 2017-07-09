/*
212. Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.

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

class TrieNode{
	TrieNode[] child = new TrieNode[26];
	String item;
}

public class LC212{
	public List<String> findWords(char[][] board, String[] words){
		List<String> res = new LinkedList<>();
		TrieNode root = buildTrie(words);
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				DFS(board, res, root, i, j);
			}
		}
		return res;
	}

	public void DFS(char[][] board, List<String> res, TrieNode node, int i, int j){
		char c = board[i][j];
		if(c == '#' || node.child[c - 'a'] == null)
			return;
		node = node.child[c - 'a'];

		// Find one word
		if(node.item != null){
			res.add(node.item);
			// Avoid duplicates
			node.item = null;
		}

		board[i][j] = '#';
		if(i > 0)
			DFS(board, res, node, i - 1, j);
		if(j > 0)
			DFS(board, res, node, i, j - 1);
		if(i < board.length - 1)
			DFS(board, res, node, i + 1, j);
		if(j < board[0].length - 1)
			DFS(board, res, node, i, j + 1);
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words){
		TrieNode root = new TrieNode();
		for(String word : words){
			TrieNode node = root;
			char[] ch = word.toCharArray();
			for(int i = 0; i < ch.length; i++){
				if(node.child[ch[i] - 'a'] == null)
					node.child[ch[i] - 'a'] = new TrieNode();
				node = node.child[ch[i] - 'a'];
			}
			node.item = word;
		}
		return root;
	}
}





















