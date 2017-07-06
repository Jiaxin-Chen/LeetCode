/*
179. Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */

import java.util.*;

public class LC179{
	// Time Complexity: O(NlogN)
	// Runtime: 114ms, beats 87.34%
	public String largestNumber(int[] nums){
		if(nums == null || nums.length == 0)
			return "";

		String[] s = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
			s[i] = String.valueOf(nums[i]);

		Comparator<String> comp = new Comparator<String>(){
			@Override
			public int compare(String str1, String str2){
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		};

		// Time Complexity: O(NlogN)
		Arrays.sort(s, comp);

		// Corner case: A bunch of 0 in nums
		if(s[0].charAt(0) == '0')
			return "0";

		StringBuilder res = new StringBuilder();
		for(String sub : s)
			res.append(sub);

		return res.toString();
	}


	public static void main(String[] args){
		int[] nums = {3, 30, 34, 5, 9};
		LC179 x = new LC179();
		System.out.println(x.largestNumber(nums));
	}
}