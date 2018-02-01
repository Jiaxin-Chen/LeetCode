/*
451. Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

import java.util.*;

class LC451{
	// Time Complexity: O(nlogn)
	// Runtime: 34ms, beats 80.09%
	public String frequencySort(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] chs = s.toCharArray();
		for(Character ch : chs){
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
			new Comparator<Map.Entry<Character, Integer>>(){
			@Override
			public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b){
				return b.getValue() - a.getValue();
			}
		});

		queue.addAll(map.entrySet());

		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			Map.Entry entry = queue.poll();
			int count = (int) entry.getValue();
			char ch = (char) entry.getKey();
			for(int i = 0; i < count; i++){
				sb.append(ch);
			}
			
		}
		return sb.toString();
	}

//------------------------------------------------------------------------------------
	// Code optimization
	// Time Complexity: O(nlogn)
	// Runtime: 126ms, beats 3.53% 
	public String frequencySort2(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		Map<Character, StringBuilder> map = new HashMap<>();
		char[] chs = s.toCharArray();

		for(Character ch : chs){
			map.put(ch, map.getOrDefault(ch, new StringBuilder()).append(ch));
		}

		PriorityQueue<StringBuilder> queue = new PriorityQueue<>(s.length(), (a, b) -> (b.length() - a.length()));

		queue.addAll(map.values());

		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()){
			sb.append(queue.poll());
		}
		return sb.toString();
	}

//---------------------------------------------------------------------------------
	// Optimization: bucket sort
	// Time Complexity: O(N)
	// Runtime: 31ms, beats 84.52%
	public String frequencySort3(String s){
		
		if(s == null || s.length() == 0){
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] chs = s.toCharArray();
		for(Character ch : chs){
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		//List<Character> [] bucket = new List[s.length() + 1];
		 List<Character> [] bucket = new List[s.length() + 1];
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			int freq = entry.getValue();
			if(bucket[freq] == null){
				bucket[freq] = new LinkedList<>();
			}
			bucket[freq].add(entry.getKey());
		}

		StringBuilder sb = new StringBuilder();
		for(int i = bucket.length - 1; i >= 0; i--){
			if(bucket[i] != null){
				for(char ch : bucket[i]){
					int freq = map.get(ch);
					for(int j = 0; j < freq; j++){
						sb.append(ch);
					}
				}
			}
		}
		return sb.toString();
		

	}

	public static void main(String[] args){
		LC451 obj = new LC451();
		String s = "Aabb";
		System.out.println(obj.frequencySort3(s));
	}
}