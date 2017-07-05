/*
168. Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */

public class LC168{
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 10.31%
	public String convertToTitle(int n){
		StringBuilder res = new StringBuilder();
		
		while(n > 0){
			n--;
			res.insert(0, (char)('A' + n % 26));
			n /= 26;
		}
		return res.toString();
	}

	public static void main(String[] args){
		int n = 399;
		LC168 x = new LC168();
		System.out.println(x.convertToTitle(n));
	}
}