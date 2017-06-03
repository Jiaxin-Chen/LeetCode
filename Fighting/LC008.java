/*
8. String to Integer (atoi)

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. 
If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: 
It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.
*/

public class LC008{
	// Time Complexity: O(N)
	// Runtime: 45ms, beats 52.53%
	public int myAtoi(String str){
		char[] ch = str.toCharArray();
		int idx = 0, digit = 0, sign = 1, num = 0;
		int len = str.length();

		// Handle corner case: ""
		if(len == 0)
			return 0;
	
		// Handle corner case: "     123"
		while(ch[idx] == ' ' && idx < len)
            idx++;

        // Handle corner case: "+2", "-1"	
		if(ch[idx] == '-' || ch[idx] == '+'){
			sign = ch[idx] == '-' ? -1 : 1;
			idx++;
		}

		// Handle the corner case '+-2'
		while(idx < len && ch[idx] >= '0' && ch[idx] <= '9') {
			digit = ch[idx] -'0';
			
			// Check if overflows
			if(Integer.MAX_VALUE / 10 < num || (Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < digit))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			num = num * 10 + digit;
			idx++;
		}
		return sign * num;
	}

	public static void main(String[] args){
		String str = "-987654321";
		LC008 x = new LC008();
		int res = x.myAtoi(str);
		System.out.println(res);
	}
}