/*
201. Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647, 
return the bitwise AND of all numbers in this range, inclusive.
For example, given the range [5, 7], you should return 4.
5: 0101
6: 0110
7: 0111

Tips: We need find the exact same bit from the most significant bit.
 */

public class LC201{
	// Time Complexity: O(N)
	// Runtime: 9ms, beats 32.79%
	public int rangeBitwiseAnd(int m, int n){
		while(m < n){
			n &= (n - 1); // 把n中为1的最低位变为0
		}
		return n;
	}

	public static void main(String[] args){
		int m = 5, n = 7;
		LC201 x = new LC201();
		System.out.println(x.rangeBitwiseAnd(m, n));
	}
}