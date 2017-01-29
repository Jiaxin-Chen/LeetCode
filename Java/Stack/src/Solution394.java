import java.util.*;

public class Solution394 {
	/* 394. Decode String:
	 * Given an encoded string, return it's decoded string.
	 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
	 * Note that k is guaranteed to be a positive integer. You may assume that the input string is always valid; No extra white spaces, 
	 * square brackets are well-formed, etc.
	 */
	
	public String decodeString(String s){
		Stack<Integer> count = new Stack<Integer>();
		Stack<StringBuilder> str = new Stack<StringBuilder>();
		StringBuilder cur = new StringBuilder();
		int k = 0;
		
		for(char ch : s.toCharArray()){
			if(Character.isDigit(ch)){
				k = k * 10 + ch - '0';
			}else if (ch == '['){
				count.push(k);
				str.push(cur);
				k = 0;
				cur = new StringBuilder();
			}else if (ch == ']'){
				StringBuilder tmp = cur;
				cur = str.pop();
				for(k = count.pop(); k > 0; k--){
					cur.append(tmp);
				}
			}else{
				cur.append(ch);
			}
		}
		return cur.toString();
		
	}
}
