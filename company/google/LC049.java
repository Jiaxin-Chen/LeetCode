/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/


class LC049 {
	// Time Complexity: O(NlogN)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if(strs == null || strs.length == 0){
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
 
        for(String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s = new String(chs);
            if(!map.containsKey(s)){
                map.put(s, new LinkedList<>());
            }
            map.get(s).add(str);
        }

        return new LinkedList<List<String>>(map.values());
    }
}