/*
411. Minimum Unique Word Abbreviation

A string such as "word" contains the following abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.

Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

Note:
In the case of multiple answers as shown in the second example below, you may return any one of them.
Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
Examples:
"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
*/
import java.util.*;


// Time Complexity: O(...)
// Runtime: 115ms, beats 37.45%
class LC411{

class TrieNode{
	TrieNode[] next;
	boolean isWord;
	TrieNode(){
		next = new TrieNode[26];
		isWord = false;
	}
}

	public String minAbbreviation(String target, String[] dictionary){

		TrieNode root = buildTrie(dictionary);
		for(int i = 0; i < target.length(); i++){
			List<String> abbrs = new LinkedList<>();
			// search the valid abbrWord from the size smallest 1 to the largest target.length()
			getAbbr(abbrs, target, 0, "", 0, i+1);
			System.out.println(abbrs);
			for(String abbr : abbrs){
				if(isValidAbbr(abbr, root, 0, 0) == false){
					return abbr;
				}
			}
		}
		return "";
	}

	// search a string to determine if that’s the one in the trie (wild card mode)
	private boolean isValidAbbr(String abbrWord, TrieNode root, int i, int loop){
		if(root == null){
			return false;
		}
		// wild card mode to traverse all the root.next nodes until use up the abbrCount in the abbrWord
		// because we don't know the exact character inside the abbrWord, we utilize the wild card mode
		if(loop != 0){
			for(int idx = 0; idx < 26; idx++){
				if(isValidAbbr(abbrWord, root.next[idx], i, loop - 1)){
					return true;
				}
			}
			return false;
		}
		if(i == abbrWord.length()){
			if(root.isWord){
				return true;
			}
			return false;
		}
		if(Character.isDigit(abbrWord.charAt(i))){
			int abbrCount = 0;
			while(i < abbrWord.length() && Character.isDigit(abbrWord.charAt(i))){
				abbrCount = abbrCount * 10 + abbrWord.charAt(i) - '0';
				i++;
			}
			return isValidAbbr(abbrWord, root, i, abbrCount);
		}else{
			return isValidAbbr(abbrWord, root.next[abbrWord.charAt(i) - 'a'], i + 1, 0);
		}
	}

	// abbrCount is the count number of current abbrWord
	// abbSize is the size for the whole abbrWord
	private void getAbbr(List<String> abbrs, String target, int pos, String tmp, int abbrCount, int abbrSize){
		if(pos == target.length()){
			if(abbrSize == 0 && abbrCount == 0){
				abbrs.add(tmp);
			}
			if(abbrSize == 1 && abbrCount != 0){
				abbrs.add(tmp + abbrCount);
			}
			return;
		}
		if(abbrSize <= 0){
			return;
		}
		char cur = target.charAt(pos);
		getAbbr(abbrs, target, pos + 1, abbrCount == 0 ? tmp + cur : tmp + abbrCount + cur, 0, abbrCount == 0 ? abbrSize - 1 : abbrSize - 2);
		getAbbr(abbrs, target, pos + 1, tmp, abbrCount + 1, abbrSize);
	}

	private TrieNode buildTrie(String[] dictionary){
		TrieNode root = new TrieNode();
		for(String word : dictionary){
			TrieNode cur = root;
			for(char ch : word.toCharArray()){
				int idx = ch - 'a';
				if(cur.next[idx] == null){
					cur.next[idx] = new TrieNode();
				}
				cur = cur.next[idx];
			}
			cur.isWord = true;
		}
		return root;
	}




	public static void main(String[] args){
		LC411 x = new LC411();
		String target = "apple";
		String[] dictionary = new String[]{"plain", "amber", "blade"};
		System.out.println(x.minAbbreviation(target, dictionary));
	}

}