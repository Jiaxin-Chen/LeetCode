/*
326. Power of Three

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/

public class LC326{
	// Time Complexity: O(1)
	// Runtime: 27ms, beats 9.92%
	public boolean isPowerOfThree(int n){
		return (n > 0) && (1162261467 % n == 0);
	}

	public static void main(String[] args){
		int n = 81;
		LC326 x = new LC326();
		System.out.println(x.isPowerOfThree(n));
	}
}