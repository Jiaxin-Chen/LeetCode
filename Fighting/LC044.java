/*
44. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */

public class LC044{
	// Time Complexity: O(N)
	// Runtime: 54ms, beats 98.86%
	public boolean isMatch(String str, String pattern){
		int sIdx = 0, pIdx = 0, matchIdx = 0, starIdx = -1;
		char[] s = str.toCharArray(), p = pattern.toCharArray();
		while(sIdx < s.length){
			if(pIdx < p.length && (p[pIdx] == '?' || s[sIdx] == p[pIdx])){
				++sIdx;
				++pIdx;
			}
			else if(pIdx < p.length && p[pIdx] == '*'){
				starIdx = pIdx;
				matchIdx = sIdx;
				++pIdx;
			}
			else if(starIdx != -1){
				pIdx = starIdx + 1;
				++matchIdx;
				sIdx = matchIdx;
			}
			else
				return false;
		}

		while(pIdx < p.length && p[pIdx] == '*')
			++pIdx;

		return pIdx == p.length;
	}

	public static void main(String[] args){
		LC044 x = new LC044();
		String str = "aab", pattern = "*a*c";
		System.out.println(x.isMatch(str, pattern));
	}
}
