/*
91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class LC091{
	// Time Complexity: O(N)
	// Runtime: 7ms, beats 9.93%
	public int numDecodings(String s){
		if(s.length() == 0 || s == null)
			return 0;

		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		int oneDigit = 0, twoDigits = 0;
		for(int i = 2; i <= n; i++){
			oneDigit = Integer.valueOf(s.substring(i - 1, i));
			twoDigits = Integer.valueOf(s.substring(i - 2, i));
			if(oneDigit >= 1 && oneDigit <= 9)
				dp[i] += dp[i-1];
			if(twoDigits >= 10 && twoDigits <= 26)
				dp[i] += dp[i-2];
		}
		return dp[n];
	}

	public static void main(String[] args){
		LC091 x = new LC091();
		String s = "1222567";
		int res = x.numDecodings(s);
		System.out.println(res);
	}
}