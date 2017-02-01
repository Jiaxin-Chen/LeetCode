import java.util.*;

public class Solution402 {
	/* 402. Remove K Digits:
	 * Given a non-negative integer num represented as a string, 
	 * remove k digits from the number so that the new number is the smallest possible.
	 * Note: The length of num is less than 10002 and will be ≥ k. The given num does not contain any leading zero.
	 * 
	 * Input: num = "1432219", k = 3, Output: "1219"
	 * Input: num = "10200", k = 1, Output: "200"
	 * Input: num = "10", k = 2, Output: "0"
	 */
	
	public String removeKdigits(String num, int k){
		// Corner case
		if(k == num.length()){
			return "0";
		}
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < num.length(); i++){
			//whenever meet a digit which is less than the previous digit, discard the previous one
			while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
				stack.pop();
				k--;
			}
			stack.push(num.charAt(i));
		}
		
		
		//Attention: Corner case for example "1111" !!!
		while(k-- > 0){
			stack.pop();
		}
		
		 StringBuilder res = new StringBuilder();
		 while(!stack.isEmpty()){
			 res.append(stack.pop());
		 }
		 res.reverse();
		 
		 while(res.length() > 1 && res.charAt(0) == '0'){
			 res.deleteCharAt(0);
		 }
		 
		 return res.toString();
	}
	
	
	public static void main(String[] args){
		
		Solution402 res = new Solution402();
		
		String num = "1432219";
		int k = 3;
		System.out.println(res.removeKdigits(num, k));
		
		num = "10200";
		k = 1;
		System.out.println(res.removeKdigits(num, k));
		
		num = "10";
		k = 2;
		System.out.println(res.removeKdigits(num, k));
		
		num = "1111";
		k = 1;
		System.out.println(res.removeKdigits(num, k));
	}
}
