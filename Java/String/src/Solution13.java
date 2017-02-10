import java.util.*;
 
public class Solution13 {
	/*
	 * 13. Roman to Integer:
	 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
	 */
	
	
	// Runtime: 123ms
	public int romanToInt(String s){
		if(s.length() == 0){
			return 0;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int num = 0, preVal = 0;
		for(int i = s.length() - 1; i >= 0; i--){
			char ch = s.charAt(i);
			int curVal = map.get(ch);
			if(preVal <= curVal){
				num += curVal;
			}else{
				num -= curVal;
			}
			preVal = curVal;
		}
		return num;
	}
	
	public static void main(String[] main){
		String s= "IVLCDM";
		Solution13 res = new Solution13();
		System.out.println(res.romanToInt(s));
	}
}
