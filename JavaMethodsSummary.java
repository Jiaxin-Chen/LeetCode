
import java.util.*;

public class JavaSkillsForInterview{
	public void StringMethods(){
		String s = "  0123 456  7";
		String str1 = s.substring(0, 3); // "012", doesn't include the endIdx
		String str2 = s.substring(3);    // "3456", from beginIdx to the end of the string
		String str3 = s.trim();			 // "0123 456  7", trim only the leading white space of the string
		char ch = s.charAt(0);  		 // '0'
		int len = s.length();			 // 7
		
		
		boolean flag = s.equals("b");
		System.out.println(str3);
		
	}

	public static void main(String[] args){
		JavaSkillsForInterview x = new JavaSkillsForInterview();
		x.StringMethods();
	}
}