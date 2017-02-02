import java.util.*;

public class Solution345 {
	/* 345. Reverse Vowels of a String:
	 * Write a function that takes a string as input and reverse only the vowels of a string.
	 * 
	 * Input: "leetcode"
	 * Output: "leotcede"
	 */
	
	//Runtime 17ms
	public String reverseVowels1(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		
		String vowels = "aeiouAEIOU";
		char[] res = s.toCharArray();
		int j = res.length - 1;
		
		for(int i = 0; i < j; i++, j--){
			/* Attention! The argument of contains method is CharSequence, not char!!!
			 * So the res[i] + "" is necessary!
			 */
			while(i < j && !vowels.contains(res[i] + "")){
				i++;
			}
			while(i < j && !vowels.contains(res[j] +"")){
				j--;
			}
			
			char tmp = res[i];
			res[i] = res[j];
			res[j] = tmp;
			
		}
		return new String(res);
	}
	
	
	// Runtime: 16ms
	public String reverseVowels2(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		
		char[] res = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		
		for(int i = 0, j = res.length - 1; i < j; ){
			if(!set.contains(res[i])){
				i++;
				continue;
			}
			if(!set.contains(res[j])){
				j--;
				continue;
			}
			
			char tmp = res[i];
			res[i] = res[j];
			res[j] = tmp;
			i++;
			j--;
		}
		
		return new String(res);
	}
	
	
	
	//Runtime 6ms
	// I think the contains method waste too much time.....
	public String reverseVowels3(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		
		char[] res = s.toCharArray();
		
		for(int i = 0, j = res.length - 1; i < j; i++, j--){
			while(i < j && !isVowel(res[i])){
				i++;
			}
			while(i < j && !isVowel(res[j])){
				j--;
			}
			
			char tmp = res[i];
			res[i] = res[j];
			res[j] = tmp;
			
		}
		return new String(res);
		
	}
	
	private boolean isVowel(char ch){
		ch = Character.toLowerCase(ch);
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
	
	
	
	
	public static void main(String[] args){
		String s= "leetcode";
		Solution345 res = new Solution345();
		System.out.println(res.reverseVowels3(s));
	}
}
