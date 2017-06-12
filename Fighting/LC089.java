/*
89. Gray Code

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/

/*
Basic idea:
G(i) = i^ (i/2).
*/

import java.util.*;

public class LC089{
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 45.14%
	public List<Integer> grayCode(int n){
		List<Integer> res = new ArrayList<Integer>();
		int len = 1 << n;
		for(int i = 0; i < len; i++){
			res.add(i ^ (i >> 1));
		}
		return res;
	}

	public static void main(String[] args){
		LC089 x = new LC089();
		int n = 3;
		List<Integer> res = x.grayCode(n);
		for(int i = 0; i < res.size(); i++)
			System.out.print(res.get(i) + " ");
	}
}