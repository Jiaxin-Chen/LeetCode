/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,

[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,

[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".

Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/

import java.util.*;

class LC269{
	// Time Complexity: O(N)
	// Runtime: 11ms, beats 20.47%
	public String alienOrder(String[] words){
		Map<Character, Integer> indegree = new HashMap<>(); // indegree for each node
		Map<Character, Set<Character>> map = new HashMap<>();  // <node, the set of its postfix node>
		Queue<Character> queue = new LinkedList<>(); // store the node with indegree = 0

		// Step 1: Initialize the dictionary
		for(String w : words){
			for(char ch : w.toCharArray()){
				indegree.put(ch, 0);
				map.put(ch, new HashSet<>());
			}
		}

		// Step 2: Build the graph
		for(int i = 1; i < words.length; i++){
			char[] pre = words[i-1].toCharArray();
			char[] cur = words[i].toCharArray();

			int len = Math.min(pre.length, cur.length); 
			int j = 0;
			for(j = 0; j < len; j++){
				if(pre[j] != cur[j]){
					Set<Character> set = map.get(pre[j]);
					// add Character cur[j] into pre[j]'s set
					if(!set.contains(cur[j])){
						indegree.put(cur[j], indegree.get(cur[j]) + 1);
						set.add(cur[j]);
						map.put(pre[j], set);
					}
					break;
				}
			}
			if(j == cur.length && j < pre.length){
				return "";
			}
		}

		// Step 3: insert the nodes which has 0 indegree
		/*
		for(Map.Entry<Character, Integer> entry : indegree.entrySet()){
			if(entry.getValue() == 0){
				queue.offer(entry.getKey());
			}
		}*/
		for(Character letter : indegree.keySet()){
			if(indegree.get(letter) == 0){
				queue.offer(letter);
			}
		}

		// Step 4: BFS
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			char node = queue.poll();
			sb.append(node);
			// if the node has the comming nodes
			if(map.containsKey(node)){
				Set<Character> set = map.get(node);
				for(char ch : set){
					int newIndegree = indegree.get(ch) - 1;
					indegree.put(ch, newIndegree);
					if(newIndegree == 0){
						queue.offer(ch);
					}
				}
			}
		}

		// corner case
		if(sb.length() != indegree.size()){
			return "";
		}
		return sb.toString();
	}

	public static void main(String[] args){
		LC269 x = new LC269();
		String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
		System.out.println(x.alienOrder(words));
	}
}