/*
336. Palindrome Pairs

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

import java.util.*;

class LC336{
	public List<List<Integer>> palindromePairs(String[] words){
		List<List<Integer>> res = new LinkedList<>();
		if(words == null || words.length < 2){
			return res;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i++){
			map.put(words[i], i);
		}

		for(int i = 0; i < words.length; i++){

			// notice it should be "j <= words[i].length()"
			for(int j = 0; j <= words[i].length(); j++){ 
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);

				if(isPalindrome(str1)){
					String str2rvs = (new StringBuilder(str2)).reverse().toString();
					if(map.getOrDefault(str2rvs, i) != i){
						res.add(Arrays.asList(map.get(str2rvs), i));
					}
				}

				// check "str.length() != 0" to avoid duplicates
				// There may be duplicates in the output (consider test case [“abcd”, “dcba”]). Therefore I put a str2.length()!=0 to avoid duplicates.
				if(isPalindrome(str2) && str2.length() != 0){
					String str1rvs = (new StringBuilder(str1)).reverse().toString();
					if(map.getOrDefault(str1rvs, i) != i){
						// attention here: we should put the inverse index into the res list
						// For example: word = [abcxx], str1 = [abc], str1rvs = [cba], we should let the idx of word comes first
						res.add(Arrays.asList(i, map.get(str1rvs)));
					}
				}
			}
		}
		return res;
	}

	private boolean isPalindrome(String word){
		int start = 0, end = word.length() - 1;

		while(start < end){
			if(word.charAt(start++) != word.charAt(end--)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		LC336 x = new LC336();
		//String[] words = new String[]{"abcd", "dcba", "lls", "s", "sssll"};
		String[] words = new String[]{"a", ""};
		System.out.println(x.palindromePairs(words));
	}
}