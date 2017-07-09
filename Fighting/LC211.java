/*
211. Add and Search Word - Data structure design

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string 
containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

class TrieNode{
	public TrieNode[] child = new TrieNode[26];
	public String item;
}

public class WordDictionary{

	private TrieNode root;

	/** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        root.item = "";
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();
        for(int i = 0; i < ch.length; i++){
        	if(node.child[ch[i] - 'a'] == null)
        		node.child[ch[i] - 'a'] = new TrieNode();
        	node = node.child[ch[i] - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word.toCharArray(), 0);
    }


    private boolean match(TrieNode node, char[] ch, int k){
    	if(k == ch.length)
    		return !node.item.equals("");

    	if(ch[k] == '.'){
    		for(int i = 0; i < node.child.length; i++){
    			if(node.child[i] != null){
    				if(match(node.child[i], ch, k + 1))
    					return true;
    			}
    		}
    	}else{
    		return node.child[ch[k] - 'a'] != null && 
    				match(node.child[ch[k] - 'a'], ch, k + 1);
    	}
    	return false;
    }
}