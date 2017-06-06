/*
28. Implement strStr()

Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

public class LC028{
	// Time Complexity: O(MN)
	// Runtime: 10ms, beats 56.65%
	public int strStr(String haystack, String needle){
		if((haystack.equals("") && needle.equals("")) || needle.equals(""))
			return 0;

		char[] hs = haystack.toCharArray(), nd = needle.toCharArray();
		for(int i = 0; i < hs.length; i++){
			for(int j = 0; ; j++){
				if(j == nd.length)
					return i;
				if(i + j == hs.length)
					return -1;
				if(nd[j] != hs[i+j])
					break;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		String haystack = "asgodiswitnessed", needle = "witness";
		LC028 x = new LC028();
		int index = x.strStr(haystack, needle);
		System.out.println(index);
	}
}