/*
97. Interleaving String

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */

/*
Here is some explanation:
DP table represents if s3 is interleaving at (i+j)th position when s1 is at ith position, 
and s2 is at jth position. 0th position means empty string.

So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving. 
If only s1 is empty, then if previous s2 position is interleaving and current s2 position char 
is equal to s3 current position char, it is considered interleaving. Similar idea applies to when s2 is empty. 
When both s1 and s2 is not empty, then if we arrive i, j from i-1, j, then if i-1,j is already interleaving and 
i and current s3 position equal, it s interleaving. If we arrive i,j from i, j-1, then if i, j-1 is already 
interleaving and j and current s3 position equal. it is interleaving.
*/

public class LC097{
	// Time Complexity: O(MN)
	// Runtime: 5ms, beats 54.22%
	public boolean isInterleave(String s1, String s2, String s3){
		int s1Len = s1.length(), s2Len = s2.length(), s3Len = s3.length();
		if(s1Len + s2Len != s3Len)
			return false;

		boolean[][] dp = new boolean[s1Len + 1][s2Len + 1];
		char[] ch1 = s1.toCharArray(), ch2 = s2.toCharArray(), ch3 = s3.toCharArray();

		for(int i = 0; i < s1Len + 1; i++){
			for(int j = 0; j < s2Len + 1; j++){
				if(i == 0 && j == 0)
					dp[i][j] = true;
				else if(i == 0)
					dp[i][j] = dp[i][j-1] && (ch2[j-1] == ch3[i+j-1]);
				else if(j == 0)
					dp[i][j] = dp[i-1][j] && (ch1[i-1] == ch3[i+j-1]);
				else
					dp[i][j] = (dp[i-1][j] && (ch1[i-1] == ch3[i+j-1])) ||
								(dp[i][j-1] && (ch2[j-1] == ch3[i+j-1]));
				//System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
			}
		}
		return dp[s1Len][s2Len];
	}

	public static void main(String[] args){
		LC097 x = new LC097();
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
		System.out.println(x.isInterleave(s1, s2, s3));
	}
}