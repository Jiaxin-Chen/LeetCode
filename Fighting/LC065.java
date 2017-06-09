/*
65. Valid Number

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
 */

public class LC065{
/*
We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

So basically the number should match this regular expression:

[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
*/
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 88.31%
	public boolean isNumber(String s){
		boolean hasPoint = false;
		boolean hasE = false;
		boolean hasNum = false;
		boolean hasNumAfterE = true;

		// trim() will trim the white space in the begining and the end of the string.
		char[] ch = s.trim().toCharArray();
		//System.out.print(String.valueOf(ch));

		for(int i = 0; i < ch.length; i++){
			if(ch[i] >= '0' && ch[i] <= '9'){
				hasNum = true;
				hasNumAfterE = true;
			}
			else if(ch[i] == '.'){
				if(hasPoint || hasE)
					return false;
				hasPoint = true;
			}
			else if(ch[i] == 'e'){
				if(hasE || !hasNum)
					return false;
				hasE = true;
				hasNumAfterE = false;
			}
			else if(ch[i] == '+' || ch[i] == '-'){
				if(i != 0 && ch[i-1] != 'e')
					return false;
			}
			else
				return false;
		}
		return hasNumAfterE && hasNum;
	}

	public static void main(String[] args){
		String s = " 0.1      ";
		LC065 x = new LC065();
		System.out.println(x.isNumber(s));
	}
}