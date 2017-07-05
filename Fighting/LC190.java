/*
190. Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
*/

public class LC190{
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 42.49%
	public int reverseBits(int n){
		int res = n & 1;
		for(int i = 0; i < 31; i++){
			res <<= 1;
			n >>>= 1;
			res += n & 1;	
		}
		return res;
	}

	public static void main(String[] args){
		LC190 x = new LC190();
		int n = 43261596;
		int res = x.reverseBits(n);
		System.out.println(res);
	}
}