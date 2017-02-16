import java.util.*;

public class Solution202 {
	/*
	 * 202. Happy Number:
	 * Write an algorithm to determine if a number is "happy".
	 * A happy number is a number defined by the following process: 
	 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
	 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly 
	 * in a cycle which does not include 1. (Indicates we need use HashSet)
	 * Those numbers for which this process ends in 1 are happy numbers.
	 * 
	 * Input: 19
	 *  	1^2 + 9^2 = 82
	 *  	8^2 + 2^2 = 68
	 *  	6^2 + 8^2 = 100
	 * 		1^2 + 0^2 + 0^2 = 1
	 */
	
	public boolean isHappy(int n){
		
		Set<Integer> set = new HashSet<Integer>();
		int squareSum, remain;
		
		while(set.add(n)){
			squareSum = 0;
			while(n != 0){
				remain = n % 10;
				squareSum += Math.pow(remain, 2);
				n /= 10;
			}
			if(squareSum == 1){
				return true;
			}else{
				n = squareSum;
			}
		}
		return false;
	}
	
	public boolean isHappy2(int n){
		Set<Integer> set = new HashSet<Integer>();
		for(int next; set.add(n) && n != 1; n = next){
			for(next = 0; n > 0; n /= 10){
				next += Math.pow(n % 10, 2);
			}
		}
		return n == 1;
	}
	
	
	public static void main(String[] args){
		int n = 19;
		Solution202 res = new Solution202();
		System.out.println(res.isHappy2(n));
	}
}
