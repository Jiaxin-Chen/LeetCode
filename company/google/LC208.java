/*
208. Implement Trie (Prefix Tree)

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

// Runtime: 200ms, beats 24.96%
class Trie {
    class TrieNode{
        boolean isWord;
        TrieNode[] next;
        TrieNode(){
        	isWord = false;
        	next = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    // Time Complexity: O(N)
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            if(cur.next[ch - 'a'] == null){
            	cur.next[ch - 'a'] = new TrieNode();
            }
            cur = cur.next[ch - 'a'];
        }
        cur.isWord = true;
    }
    
    // Time Complexity: O(N)
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
        	if(cur.next[ch - 'a'] == null){
        		return false;
        	}else{
        		cur = cur.next[ch - 'a'];
        	}
        }
        if(cur.isWord){
        	return true;
        }
        return false;
    }
    
    // Time Complexity: O(N)
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
        	if(cur.next[ch - 'a'] == null){
        		return false;
        	}else{
        		cur = cur.next[ch - 'a'];
        	}
        }
        return true;
    }
}