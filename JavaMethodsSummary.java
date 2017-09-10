
import java.util.*;

public class JavaMethodsSummary{
	public void StringMethods(){
		String s = "  0123 123  0";
		String str = s.trim();			 // "0123 123  0", trim only the leading white space of the string
		String str2 = str.substring(0, 4); // "0123", [begigIdx, endIdx)
		String str3 = str.substring(3);    // "3 123 0", [beginIdx, str3.length()-1)
		
		char ch = str.charAt(0);  	    // '0'
		int len = str.length();         // 10
		int idx1 = str.indexOf('2');         // 2, search the idx from the begining
		int idx2 = str.indexOf('2', 5);      // 6, search the idx from idx=5
		int idx3 = str.indexOf("23");		 // 2
		int idx4 = str.indexOf("23", 5);     // 6, search the idx from idx=5
		int idx5 = str.lastIndexOf('2');     // 6
		int idx6 = str.lastIndexOf('2', 3);  // 2, search the idx backward from idx = 3

		boolean isEqual = str.equals("b");   //false
		boolean isStartsWith = str.startsWith("0123"); // true
		boolean isStartsWith2 = str.startsWith("0123", 2); // false, search the prefix from the idx = 2

		char[] chs = str.toCharArray(); // "0123 123  0"

		Integer a = Integer.valueOf(str2); // 123, Returns an Integer instance representing the specified int value.
		int b = Integer.parseInt(str2);    // 123. Attention: it's not 0123!!!
		String str4 = String.valueOf(a);

		//System.out.println(str4);
	}

	public void StringBuilderMethods() {
		StringBuilder sb = new StringBuilder();
		sb.append("bcdefg");  // bcdefg
		sb.insert(0, "a"); // abcdefg
		sb.deleteCharAt(sb.length() - 1); //abcdef
		sb.delete(3, 5);   // abcf, [beginIdx, endIdx)
		sb.reverse();      // fcba
		sb.toString();
		//System.out.println(sb);
	}

	public int[] ArrayMethods() {
		int[] a = new int[10]; 
		char[] b = {'a', 'b'};
		int[][] c = new int[10][10];
		int[] d = {3, 5, 1, 6, 8, 2, 4, 7, 9};
		int m = a.length, n = c[0].length;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		Arrays.sort(d);  //Time Complexity: O(NlogN)

		for(int i = 0; i < d.length; i++) {
			//System.out.println(d[i]);
		}
		return new int[]{1, 2, 3, 4, 5}; // Attention: int[] is fine, not int[len] !!!
	}

	public void ListMethods() {

	}

	public static void main(String[] args){
		JavaMethodsSummary x = new JavaMethodsSummary();
		x.StringMethods();
		x.StringBuilderMethods();
		x.ArrayMethods();
	}
}