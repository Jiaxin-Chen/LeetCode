/*
208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
	public char val;
	public boolean isWord;
	public TrieNode[] child = new TrieNode[26];
}

// Runtime: 178ms, beats 76.95%
public class Trie{

	private TrieNode root;

	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
		root.val = ' ';
    }
    
    // Time Complexity: O(N)
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();
        for(int i = 0; i < ch.length; i++){
        	if(node.child[ch[i] - 'a'] == null){
        		node.child[ch[i] - 'a'] = new TrieNode();
        	}
        	node = node.child[ch[i] - 'a'];
        }
        node.isWord = true;
    }
    
    // Time Complexity: O(N)
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();
        for(int i = 0; i < ch.length; i++){
        	if(node.child[ch[i] - 'a'] == null)
        		return false;
        	node = node.child[ch[i] - 'a'];
        }
        return node.isWord;
    }
    
    // Time Complexity: O(N)
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] ch = prefix.toCharArray();
        for(int i = 0; i < ch.length; i++){
        	if(node.child[ch[i] - 'a'] == null)
        		return false;
        	node = node.child[ch[i] - 'a'];
        }
        return true;
    }
}