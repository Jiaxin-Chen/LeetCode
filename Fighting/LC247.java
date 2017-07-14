/*
247. Strobogrammatic Number II

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
*/

import java.util.*;

public class LC247{
	// Time Complexity: O(N)
	// Runtime: 22ms, beats 65.24%
	public List<String> findStrobogrammatic(int n){
		return Helper(n, n);
	}

	private List<String> Helper(int n, int m){
		if(n == 0)
			return new ArrayList<String>(Arrays.asList(""));
		if(n == 1)
			return new ArrayList<String>(Arrays.asList("0", "1", "8"));
		List<String> list = Helper(n - 2, m);
		List<String> res = new ArrayList<>();

		for(int i = 0; i < list.size(); i++){
			String s = list.get(i);
			if(n != m)
				res.add("0" + s + "0");
			res.add("1" + s + "1");
			res.add("6" + s + "9");
			res.add("9" + s + "6");
			res.add("8" + s + "8");
		}
		return res;
	}

	public static void main(String[] args){
		LC247 x = new LC247();
		int n = 3;

		List<String> res = x.findStrobogrammatic(n);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}