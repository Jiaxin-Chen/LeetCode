/*
202. Happy Number

Write an algorithm to determine if a number is "happy".
A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), or it loops endlessly 
in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */

import java.util.*;

public class LC202{
	// Time Complexity: O(N^2)
	// Runtime: 5ms, beats 28.01%
	public boolean isHappy(int n){
		if(n == 0)
			return false;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		while(!map.containsKey(n)){
			map.put(n, 1);
			int sum = 0;
			while(n > 0){
				int cur = n % 10;
				sum += cur * cur;
				n /= 10;
			}
			if(sum == 1)
				return true;
	
			n = sum;
			//System.out.println(sum);
		}
		return false;
	}


	public static void main(String[] args){
		LC202 x = new LC202();
		int n = 19;
		System.out.println(x.isHappy(n));
	}
}