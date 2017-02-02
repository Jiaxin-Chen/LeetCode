
public class Solution344 {
	/* 344. Reverse String:
	 * Write a function that takes a string as input and returns the string reversed.
	 * 
	 * Input: "hello"
	 * Output: "olleh"
	 */
	
	public String reverseString(String s){
		char[] res = s.toCharArray();
		
		int j = res.length - 1;
		for(int i = 0; i < j; i++, j--){
			char tmp = res[i];
			res[i] = res[j];
			res[j] = tmp;
		}
		
		return new String(res);
	}
	
	public static void main(String[] args){
		String s = "hello";
		Solution344 res = new Solution344();
		System.out.println(res.reverseString(s));
	}
}
