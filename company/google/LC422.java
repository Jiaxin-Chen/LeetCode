/*
422. Valid Word Square

Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

Note:
The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
Example 2:

Input:
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".

Therefore, it is a valid word square.
Example 3:

Input:
[
  "ball",
  "area",
  "read",
  "lady"
]

Output:
false

Explanation:
The third row reads "read" while the third column reads "lead".

Therefore, it is NOT a valid word square.
*/

import java.util.*;

class LC422{
	// Time Complexity: O(N* L), N is the number of words, L is the average length of words
	// Runtime: 18ms, beats 09.87%
	public boolean validWordSquare(List<String> words){
		if(words == null || words.size() == 0){
			return false;
		}

		int n = words.size();
		for(int i = 0; i < n; i++){
			char[] chs = words.get(i).toCharArray();
			for(int j = 0; j < chs.length; j++){
				if(j >=  n || words.get(j).length() <= i || chs[j] != words.get(j).charAt(i)){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args){
		LC422 x = new LC422();
		List<String> words = new ArrayList<>();
		words.add("abcd");
		words.add("bnrt");
		words.add("crm");
		words.add("dt");

		System.out.println(x.validWordSquare(words));
	}
}