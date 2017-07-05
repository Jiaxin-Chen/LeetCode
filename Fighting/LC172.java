/*
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
 */

public class LC172{
	// Time Complexity: O(logN)
	// Runtime: 1ms, beats 41.51%
	public int trailingZeroes(int n){
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}


	// Time Complexity: O(logN)
	// Runtime: 1ms, beats 41.51%
	public int trailingZeroes2(int n){
		int res = 0;
		while(n > 0){
			res += n / 5;
			n /= 5;
		}
		return res;
	}

	public static void main(String[] args){
		int n = 888;
		LC172 x = new LC172();
		System.out.println(x.trailingZeroes2(n));
	}

}