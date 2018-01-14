/*
161. One Edit Distance

Given two strings S and T, determine if they are both one edit distance apart.
*/

class LC161{

	/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
 	  s: a B c
 	  t: a D c
 * 2) Delete 1 char from s: 
	  s: a D  b c
	  t: a    b c
 * 3) Delete 1 char from t
	  s: a   b c
	  t: a D b c
 */

	// Time Complexity: O(N)
	// Runtime: 2ms, beats 40.52%
	public boolean isOneEditDistance(String s, String t){
		int len1 = s.length(), len2 = t.length();

		// Step 1:  always make sure “s” is shorter than “t”. Then we just need to handle two cases.
		if (len1 > len2){
			return isOneEditDistance(t, s);
		}

		// Step 2: 
		int len = Math.min(len1, len2);
		for(int i = 0; i < len; i++){
			if(s.charAt(i) != t.charAt(i)){
				// s has the same length as t, so the only possibility is replacing one char in s an
				if(len1 == len2){
					return s.substring(i+1).equals(t.substring(i+1));
				// t is longer than s, so the only possibility is deleting one char from
				}else{
					return s.substring(i).equals(t.substring(i+1));
				}
			}
		}

		// Step 3: All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
		return Math.abs(len1 - len2) == 1;
	}

	public static void main(String[] args){
		LC161 x = new LC161();
		String s = "abc", t = "ac";
		System.out.println(x.isOneEditDistance(s, t));
	}
}