/*
93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

import java.util.*;

public class LC093{
	// Time Complexity: O(N^3)
	// Runtime: 5ms, beats 42.29%
	public List<String> restoreIpAddresses(String s){
		List<String> res = new ArrayList<String>();
		int len = s.length();

		for(int i = 1; i < 4 && i < len-2; ++i){
			for(int j = i+1; j < i+4 && j < len-1; ++j){
				for(int k = j+1; k < j+4 && k < len; ++k){
					String s1 = s.substring(0, i), s2 = s.substring(i, j);
					String s3 = s.substring(j, k), s4 = s.substring(k, len);
					if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
				}
			}
		}
		return res;
	}

	private boolean isValid(String s){
		// We need check s.length() first to avoid Runtime Error: java.lang.NumberFormatException
		if(s.length() > 3 || s.length() == 0 || s.charAt(0) == '0' && s.length() > 1 || Integer.parseInt(s) > 255)
			return false;
		return true;
	}

	public static void main(String[] args){
		LC093 x = new LC093();
		String s = "9245587303";
		List<String> res = x.restoreIpAddresses(s);
		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
}