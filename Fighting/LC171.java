/*
171. Excel Sheet Column Number

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */

public class LC171{
	// Time Complexity: O(n)
	// Runtime: 2ms, beats 49.86%
	public int titleToNumber(String s){
		int res = 0;
		for(int i = 0; i < s.length(); i++){
			res = res * 26 + s.charAt(i) - 'A' + 1;
		}
		return res;
	}

	public static void main(String[] args){
		String s = "AA";
		LC171 x = new LC171();
		System.out.println(x.titleToNumber(s));
	}
}