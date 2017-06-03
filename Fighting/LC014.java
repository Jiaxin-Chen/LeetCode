/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
*/

public class LC014{
	// Time Complexity: O(N^2)
	// Runtime: 9ms, beats 93.72%
	public String longestCommonPrefix(String[] strs){
		if (strs.length == 0)
			return "";

		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++){
			while(!strs[i].startsWith(prefix)){
				prefix = prefix.substring(0, prefix.length() - 1);
			}
			// Make code faster, but actually it doesn't speed up...
			if(prefix.equals(""))
				return "";
		}

		return prefix;
	}

	public static void main(String[] args){
		LC014 x = new LC014();
		String[] strs = {"abcd", "d", "acc"};
		System.out.println(x.longestCommonPrefix(strs));
	}
}