/*
10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class LC010{
	// Time Complexity: O(N^2)
	// Runtime: 47ms, beats 31.20%
	public boolean isMatch(String s, String p){
		int m = s.length(), n = p.length();
		if(m == 0 || n == 0)
			return false;

		boolean[][] state = new boolean[m + 1][n + 1];
		state[0][0] = true;
		/*for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/

		char[] ch1 = s.toCharArray(), ch2 = p.toCharArray();
		for(int j = 1; j <= n; j++){
			if (ch2[j-1] == '*'){
				if(state[0][j-1] || (j > 1 && state[0][j-2]))
					state[0][j] = true;
			}
		}

		/*for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/

		for (int i = 1; i <= m; i++){
			for (int j = 1; j <= n; j++){
				if(ch1[i-1] == ch2[j-1] || ch2[j-1] == '.'){
					state[i][j] = state[i-1][j-1];
				}
				if(ch2[j-1] == '*'){
					// In this case, a* only counts as empty
					if(ch1[i-1] != ch2[j-2] && ch2[j-2] != '.'){
						state[i][j] = state[i][j-2];
					}else{
						state[i][j] = state[i-1][j]   //in this case, a* counts as multiple a 
									|| state[i][j-1]  // in this case, a* counts as single a
									|| state[i][j-2]; // in this case, a* counts as empty
					}
				}
			}
		}

		/*for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();*/

		return state[m][n];
	}

	public static void main(String[] args){
		LC010 x = new LC010();
		String s = "aaaa", p = "aaa*";
		boolean res = x.isMatch(s, p);
		System.out.println(res);
	}
}