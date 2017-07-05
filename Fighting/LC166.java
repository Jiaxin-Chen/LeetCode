/*
166. Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.

For example,
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */

import java.util.*;

public class LC166{
	// Time Complexity: O(n)
	// Runtime: 6ms, beats 17.56%
	public String fractionToDecimal(int numerator, int denominator){
		if(numerator == 0)
			return "0";

		StringBuilder res = new StringBuilder();
		String sign = ((numerator > 0) ^ (denominator > 0)) ? "-" : "";
		res.append(sign);

		long num = Math.abs(numerator);
		long den = Math.abs(denominator);
		res.append(Math.abs(num / den));
		long remainder = num % den;
		if(remainder == 0)
			return res.toString();

		res.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();

		while(!map.containsKey(remainder)){
			map.put(remainder, res.length());
			remainder = remainder * 10;
			res.append(Math.abs(remainder / den));
			remainder = remainder % den;
		}
		int idx = map.get(remainder);
		res.insert(idx, "(");
		res.append(")");
		return res.toString().replace("(0)", "");
	}

	public static void main(String[] args){
		int numerator = 1, denominator = -2147483648;
		LC166 x = new LC166();
		System.out.println(x.fractionToDecimal(numerator, denominator));
	}
}