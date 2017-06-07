/*
38. Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
 10.   13211311123113112211

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
From the examples you can see, the (i+1)th sequence is the "count and say" of the ith sequence!

Note: The sequence of integers will be represented as a string.
 */

public class LC038{
	// Time Complexity: O(N^2)
	// Runtime: 6ms, beats 56.37%
	public String countAndSay(int n){
		StringBuilder cur = new StringBuilder("1");
		StringBuilder prev;
		int count;
		char say;

		for(int i = 1; i < n; i++){
			prev = cur;
			cur = new StringBuilder();
			count = 1;
			say = prev.charAt(0);

			for(int j = 1; j < prev.length(); j++){
				if(prev.charAt(j) == say){
					count++;
				}else{
					cur.append(count).append(say);
					say = prev.charAt(j);
					count = 1;
				}
			}
			cur.append(count).append(say);
		}
		return cur.toString();
	}

	public static void main(String[] args){
		LC038 x = new LC038();
		int n = 10;
		String res = x.countAndSay(n);
		System.out.println(res);
	}
}