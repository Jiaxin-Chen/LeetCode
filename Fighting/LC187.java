/*
187. Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

import java.util.*;

public class LC187{
	// Time Complexity: O(N)
	// Runtime: 51ms, beats 69.58%
	public List<String> findRepeatedDNASequences(String s){
		List<String> res = new ArrayList<String>();
		if(s.length() <= 10)
			return res;

		Map<String, Integer> map = new HashMap<String, Integer>();
		int end = 10;
		for(int start = 0; end <= s.length(); start++, end++){
			String cur = s.substring(start, end); // substring doesn't include the endIdx.
			if(!map.containsKey(cur)){
				map.put(cur, 1);
			}else{
				if(map.get(cur) == 1){
					res.add(cur);
					map.put(cur, 2);
				}
			}
		}
		return res;

	}

	public static void main(String[] args){
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		LC187 x = new LC187();
		List<String> res = x.findRepeatedDNASequences(s);
		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
}
