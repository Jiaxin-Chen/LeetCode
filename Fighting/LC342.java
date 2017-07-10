/*
342. Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.
*/

public class LC342{
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 22.73%
	public boolean isPowerOfFour(int num){
		if(num <= 0)
			return false;

		while(num > 1){
			if(num % 4 != 0)
				return false;
			num >>>= 2;
		}

		return num == 1;
	}


	public static void main(String[] args){
		int n = 5;
		LC342 x = new LC342();
		System.out.println(x.isPowerOfFour(n));
	}
}