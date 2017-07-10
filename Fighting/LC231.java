/*
231. Power of Two

Given an integer, write a function to determine if it is a power of two.
*/

public class LC231{
	// Time Complexity: O(1)
	// Runtime: 2ms, beats 21.82%
	public boolean isPowerOfTwo(int n){
		if(n <= 0)
			return false;
		return (n & (n - 1)) == 0;
	}

	public static void main(String[] args){
		int n = 256;
		LC231 x = new LC231();
		System.out.println(x.isPowerOfTwo(n));
	}
}