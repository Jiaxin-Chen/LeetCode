/*
357. Count Numbers with Unique Digits

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
*/

class LC357{
	// Time Complexity: O(N), Space Complexity: O(N)
	// Runtime: 0ms, beats 8.07%
	public int countNumbersWithUniqueDigits(int n){
		if(n == 0){
			return 1;
		}
		if(n == 1){
			return 10;
		}

		int[] dp = new int[n + 1];
		dp[1] = 10;  // 只有1位数时的个数：[0 - 9]
		dp[2] = 81;  // 只有2位数时的个数：9([1-9]) * 9([0-9]除去和十位数相同的那个数)
		// dp[3] = 9 * 9 * 8; 只有3位数时的个数：9([1-9]) * 9([0-9]除去和百位数相同的那个数 * 8([0-9]除去和百位、十位数相同的那个数)

		int res = dp[1] + dp[2];
		
		for(int i = 3; i <= n; i++){
			dp[i] = dp[i-1] * (11 - i);
			res += dp[i];
		}
		return res;
	}

	//-------------------------------------------------
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 0ms, beats 8.07%
	public int countNumbersWithUniqueDigits2(int n){
		if(n == 0){
			return 1;
		}
		if(n == 1){
			return 10;
		}

		int[] dp = new int[n + 1];
		int preDigitsNum = 10;  // 只有1位数时的个数：[0 - 9]
		int curDigitsNum = 81;  // 只有2位数时的个数：9([1-9]) * 9([0-9]除去和十位数相同的那个数)
		// dp[3] = 9 * 9 * 8; 只有3位数时的个数：9([1-9]) * 9([0-9]除去和百位数相同的那个数 * 8([0-9]除去和百位、十位数相同的那个数)

		int res = preDigitsNum + curDigitsNum;
		
		for(int i = 3; i <= n; i++){
			curDigitsNum = curDigitsNum * (11 - i);
			res += curDigitsNum;
		}
		return res;
	}

//------------------------------------------------------
	// Time Complexity: O()
	// Runtime: 98ms, beats 2.74%
	public int countNumbersWithUniqueDigits3(int n){
		if(n == 0){
			return 1;
		}
		if(n > 10){
			countNumbersWithUniqueDigits3(10);
		}

		boolean[] used = new boolean[10];
		int count = 1;
		long max = (long) Math.pow(10, n);

		// start from 1, because we don't expect 0 in the leading position
		for(int i = 1; i < 10; i++){
			used[i] = true;
			count += backtracking(used, i, max);
			used[i] = false;
		}
		return count;
	}

	private int backtracking(boolean[] used, long pre, long max){
		if(pre >= max){
			return 0;
		}
		int count = 1;
		for(int i = 0; i < 10; i++){
			if(!used[i]){
				used[i] = true;
				long cur = pre * 10 + i;
				count += backtracking(used, cur, max);
				used[i] = false;
			}
			
		}
		return count;
	}


	public static void main(String[] args){
		LC357 x = new LC357();
		int n = 1;
		System.out.println(x.countNumbersWithUniqueDigits3(n));
	}
}