/*
761. Special Binary String

Special binary strings are binary strings with the following two properties:

The number of 0's is equal to the number of 1's.
Every prefix of the binary string has at least as many 1's as 0's.
Given a special string S, a move consists of choosing two consecutive, non-empty, special substrings of S, and swapping them. (Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)

At the end of any number of moves, what is the lexicographically largest resulting string possible?

Example 1:
Input: S = "11011000"
Output: "11100100"
Explanation:
The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
Note:

S has length at most 50.
S is guaranteed to be a special binary string as defined above.
*/

import java.util.*;

class LC761{
	// Because the number of 0's is equal to the number of 1's in M
	// If there is a prefix P of Mwhich has one less 1's than 0's, 1P will make up a special string. 1P will be found as special string before 1M0 in my solution.
	// It means that every prefix of M has at least as many 1's as 0's.
	public String makeLargestSpecial(String s) {
		
    	int count = 0, i = 0;
    	List<String> res = new LinkedList<>();
    	char[] chs = s.toCharArray();

    	for(int j = 0; j < chs.length; j++){
    		if(chs[j] == '1'){
    			count++;
    		}else{
    			count--;
    		}
    		if(count == 0){
    			res.add('1' + makeLargestSpecial(s.substring(i + 1, j)) + '0');
    			i = j + 1;
    		}
    	}
    	System.out.println(res);
    	Collections.sort(res, Collections.reverseOrder());
    	return String.join("", res);
    }

    public static void main(String[] args){
    	LC761 x = new LC761();
    	String s = "11011000";
    	System.out.println(x.makeLargestSpecial(s));
    }
}