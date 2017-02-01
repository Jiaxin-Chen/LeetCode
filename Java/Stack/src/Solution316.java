//import java.util.*;

public class Solution316 {
	/* 316. Remove Duplicate Letters:
	 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
	 * You must make sure your result is the smallest in lexicographical order among all possible results.
	 * 
	 * Input: "bcabc", Output: "abc"
	 * Input: "cbacdcbc", Output: "acdb"
	 */
	
	public String removeDuplicateLetters(String s){
		int[] count = new int[26];  // contain the number of occurred character (i+'a')
		boolean[] visited = new boolean[26]; // if character ('a' + i) is present in current result
		char[] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();  // using StringBuilder as a stack is faster than normal stack
		int index;
		
		for(char c : ch){
			count[c - 'a']++;
		}
		
		for(char c : ch){
			index = c - 'a';
			count[index]--;  // decrement number of characters remaining in the string to be analyzed
			if(visited[index]){  // if character is already present in stack, just go next
				continue;
			}
			
			/* if current character is smaller than the last character in sb, which occurs later in the string again,
             * it can be removed and added later e.g stack = bc remaining string abc then a can pop b and then c
             */
			while(sb.length() > 0 && c < sb.charAt(sb.length() - 1) && (count[sb.charAt(sb.length() - 1) - 'a'] != 0)){
				visited[sb.charAt(sb.length() - 1) - 'a'] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
			sb.append(c);
			visited[index] = true;
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		Solution316 res = new Solution316();
		String s = "cbacdcbc";
		System.out.println(res.removeDuplicateLetters(s));
	}
}
