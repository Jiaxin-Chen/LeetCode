/*
13. Roman to Integer

Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

import java.util.*;

public class LC013{
	// Time Complexity: O(N)
	// Runtime: 125ms, beats 8.30%
	public int romanToInt(String s){
		if(s.length() == 0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();
		map.put('M', 1000);
		//map.put("CM", 900);
		map.put('D', 500);
		//map.put("CD", 400);
		map.put('C', 100);
		//map.put("XC", 90);
		map.put('L', 50);
		//map.put("XL", 40);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);

		char[] ch = s.toCharArray();
		int len = s.length();
		int num = map.get(ch[len - 1]);
		for(int i = len - 2; i >= 0; i--){
			if(map.get(ch[i+1]) > map.get(ch[i]))
				num -= map.get(ch[i]);
			else
				num += map.get(ch[i]);
		}
		return num;
	}

	// Time Complexity: O(N)
	// Runtime: 90ms, beats 92.46%
	public int romanToInt2(String s) {
        if(s.length() == 0) return 0;
        
       	int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
		char c = s.charAt(i);
		switch (c) {
		case 'I':
			res += (res >= 5 ? -1 : 1);
			break;
		case 'V':
			res += 5;
			break;
		case 'X':
			res += 10 * (res >= 50 ? -1 : 1);
			break;
		case 'L':
			res += 50;
			break;
		case 'C':
			res += 100 * (res >= 500 ? -1 : 1);
			break;
		case 'D':
			res += 500;
			break;
		case 'M':
			res += 1000;
			break;
		}
		}
		return res;
    }

	public static void main(String[] args){
		String s = "MDCLXVI";
		LC013 x = new LC013();
		System.out.println(x.romanToInt(s));
	}
}