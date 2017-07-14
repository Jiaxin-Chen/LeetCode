/*
246. Strobogrammatic Number

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
*/

import java.util.*;

public class LC246{
	// Time Complexity: O(N)
	// Runtime: 7.58%
	public boolean isStrobogrammatic(String num){
		if(num.length() == 0)
			return false;

		Map<Character, Character> map = new HashMap<>();
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		map.put('1', '1');
		map.put('0', '0');

		char[] ch = num.toCharArray();
		for(int i = 0, j = ch.length - 1; i < ch.length; i++, j--){
			if(!map.containsKey(ch[i]) || !map.containsKey(ch[j]))
				return false;
			if(ch[i] != map.get(ch[j]))
				return false;
		}
		return true;
	}

	public static void main(String[] args){
		LC246 x = new LC246();
		String num = "8182";
		System.out.println(x.isStrobogrammatic(num));
	}
}

