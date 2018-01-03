/*
408. Valid Word Abbreviation

Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
*/

class LC408{
	// Time Complexity: O(N)
	// Runtime: 21ms, beats 46.78%
	public boolean validWordAbbreviation(String word, String abbr){
		if(word == null || word.length() == 0 || abbr == null || abbr.length() == 0){
			return false;
		}

		char[] words = word.toCharArray(), abbrs = abbr.toCharArray();
		int i = 0, j = 0;

		while(i < words.length && j < abbrs.length){
			// If the same, continue
			if(words[i] == abbrs[j]){
				i++; j++;
				continue;
			}
			// If abbrs isn't number and doesn't match words
			if(abbrs[j] < '0' || abbrs[j] > '9'){
				return false;
			}
			// If leading 0, it's false.
			if(abbrs[j] == '0'){
				return false;
			}
			// get number
			int start = j;
			while(j < abbrs.length && abbrs[j] >= '0' && abbrs[j] <= '9'){
				j++;
			}
			int num = Integer.valueOf(abbr.substring(start, j));
			i += num;
		}
		return i == words.length && j == abbrs.length;
	}

	public static void main(String[] args){
		String word = "a", abbr = "01";
		LC408 x = new LC408();
		System.out.println(x.validWordAbbreviation(word, abbr));
	}
}