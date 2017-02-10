import java.util.*;

public class Solution12 {
	/*
	 * 12. Integer to Roman:
	 * Given an integer, convert it to a roman numeral.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
	
	public String intToRoman(int num){
		 if(num < 1 || num > 3999){
			 return "";
		 }
		 
		 StringBuilder res = new StringBuilder();
		 String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		 int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		 
		 for(int i = 0; num > 0; i++){
			 while(num >= values[i]){
				 num -= values[i];
				 res.append(roman[i]);
			 }
		 }
		 
		 return res.toString();
	}
	
	public static void main(String[] args){
		int num = 2000;
		Solution12 res = new Solution12();
		System.out.println(res.intToRoman(num));
	}
}
