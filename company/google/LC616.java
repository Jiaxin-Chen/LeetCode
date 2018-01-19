/*
616. Add Bold Tag in String

Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. 
If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. 
Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"

Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].
*/

class LC616{
	// Time Complexity: O(LN), L is the length of s, N is the number of dict
	// Runtime: 30ms, beats 50.33%
	public String addBoldTag(String s, String[] dict){
		if(dict == null || dict.length == 0){
			return s;
		}

		boolean[] bold = new boolean[s.length()]; // mark if character at each position is bold or not.
		int start = 0, end = 0;
		for(start = 0; start < s.length(); start++){
			for(String word : dict){
				if(s.startsWith(word, start)){
					end = Math.max(end, start + word.length()); // handle the overlap of two substrings
				}
			}
			bold[start] = end > start; // it means the i-th position should warp by bold
		}

		StringBuilder sb = new StringBuilder();
		start = 0;
		while( start < s.length()){
			if(!bold[start]){
				sb.append(s.charAt(start++));
				//System.out.println("1: start = " + start + ", end = " + end);
			}else{
				end = start;
				while(end < s.length() && bold[end]){
					end++;
				}
				sb.append("<b>");
				sb.append(s.substring(start, end));
				sb.append("</b>");
				//System.out.println("2: start = " + start + ", end = " + end);
				start = end;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args){
		LC616 x = new LC616();
		String s ="aaabbcc";
		String[] dict = new String[]{"aaa", "aab", "bc"};
		System.out.println(x.addBoldTag(s, dict));
	}
}