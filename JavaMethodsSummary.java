
import java.util.*;

public class JavaMethodsSummary{
	public void StringMethods(){
		String s = "  0123 123  0";
		String str = s.trim();			 // "0123 123  0", trim only the leading white space of the string
		String str2 = str.substring(0, 4); // "0123", [begigIdx, endIdx)
		String str3 = str.substring(3);    // "3 123 0", [beginIdx, str3.length()-1)
		
		char ch = str.charAt(0);  	    // '0'
		int len = str.length();         // 10
		int idx1 = str.indexOf('2');         // 2
		int idx2 = str.indexOf('2', 5);      // 6
		int idx3 = str.indexOf("23");		 // 2
		int idx4 = str.indexOf("23", 5);     // 6
		int idx5 = str.lastIndexOf('2');     // 6
		int idx6 = str.lastIndexOf('2', 3);  // 2

		boolean flag = str.equals("b");

		System.out.println(idx4);
		
	}

	public static void main(String[] args){
		JavaMethodsSummary x = new JavaMethodsSummary();
		x.StringMethods();
	}
}