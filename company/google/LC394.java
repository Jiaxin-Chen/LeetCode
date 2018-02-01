/*
394. Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
import java.util.*;
class LC394 {

	// Time Complexity: O(N)
	// Runtime: 4ms, beats 31.81%
	public String decodeString(String s){
		if(s == null || s.length() == 0){
            return "";
        }

        Stack<Integer> counts = new Stack<>();
        Stack<String> strs = new Stack<>();
        String res = "";
        int idx = 0;

        while(idx < s.length()){
        	if(Character.isDigit(s.charAt(idx))){
        		int count = 0; 
        		while(Character.isDigit(s.charAt(idx))){
        			count = count * 10 + s.charAt(idx) - '0';
        			idx++;
        		}
        		counts.push(count);
        	}
        	else if(s.charAt(idx) == '['){
        		strs.push(res);
        		res = "";
        		idx++;
        	}
        	else if(s.charAt(idx) == ']'){
        		StringBuilder sb = new StringBuilder();
        		sb.append(strs.pop());
        		int curCount = counts.pop();
        		for(int i = 0; i < curCount; i++){
        			sb.append(res);
        		}
        		res = sb.toString();
        		idx++;
        	}
        	else{
        		res += s.charAt(idx++);
        	}
        }
        return res;
	}


	// My fault version: just a mess...
    public String decodeString2(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        int end = 0;
        Stack<Integer> counts = new Stack<>();
        Stack<String> strs = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String res = "";
        
        while(end < s.length()){
            int count = 0;
            while(Character.isDigit(s.charAt(end))){
                count = count * 10 + s.charAt(end++) - '0';
            }
            if(end < s.length() && count != 0 && s.charAt(end) == '['){
            	System.out.println(count);
                counts.push(count);
                end++;
                continue;
            }
            int start = end;
            while(Character.isLetter(s.charAt(end))){
                end++;
            }
            if(start != end){
            	System.out.println(s.substring(start, end));
            	//res = s.substring(start, end);
                strs.push(s.substring(start, end));
                continue;
            }
            if(s.charAt(end++) == ']'){
                int curCount = counts.pop();
                String curStr = strs.pop();
                System.out.println("curCount = " + curCount + ", curStr = " + curStr);
                for(int i = 0; i < curCount; i++){
                    sb.append(curStr);
                }
                strs.push(sb.toString());
                sb.setLength(0);
            }
        }

        return strs.pop();
    }

    public static void main(String[] args){
    	LC394 x = new LC394();
    	String s = "3[a2[c]]";
    	System.out.println(x.decodeString(s));
    }
}