/*
387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

class LC387 {
	// Time Complexity: O(N), one pass!!!
	// Runtime: 22ms, beats 82.79%
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        
        int[] map = new int[26];
        char[] chs = s.toCharArray();
        
        for(Character ch : chs){
            map[ch - 'a']++;
        }
        
        for(int i = 0; i < chs.length; i++){
            if(map[chs[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}