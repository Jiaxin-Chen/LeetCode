/*
191. Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */

public class LC191{
	// One pass!!!!!!!!!!!!!!!
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 14.75%
	public int hammingWeight(int n){
		if(n == 0)
			return 0;

		int res = 0; 
		for(int i = 0; i < 32; i++){
			res += n & 1;
			n >>>= 1;
		}
		return res;
	}

	public static void main(String[] args){
		int n = 11;
		LC191 x = new LC191();
		System.out.println(x.hammingWeight(n));
	}
}