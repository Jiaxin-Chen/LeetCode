/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
*/

class LC014{
	// Time Compleixty: O(NL), N is the number of strs, L is the lenght of str[0]
	// Runtime: 18ms, beats 11.58%
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}

		String res = "";
		for(int i = 0; i <= strs[0].length(); i++){
			String s = strs[0].substring(0, i);
			//System.out.println("s = " + s);
			for(String str : strs){
				if(i > str.length() || !str.startsWith(s)){
					return res;
				}
			}
			res = s;
			//System.out.println("res = " + res);
		}
		return res;
	}

//---------------------------------------------------
	public String longestCommonPrefix2(String[] strs){
		if(strs == null || strs.length == 0){
			return "";
		}
		String res = strs[0];
		int i = 1;
		while(i < strs.length){
        	while(strs[i].indexOf(res) != 0)
            	res = res.substring(0, res.length()-1);
        	i++;
    	}
    	return res;
	}

	public static void main(String[] args){
		String[] strs = {"a", "aab", "aac"};
		LC014 x= new LC014();
		System.out.println(x.longestCommonPrefix(strs));
	}
}