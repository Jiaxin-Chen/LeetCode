/*
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

class LC125{
	// My Fault version:
	// DID NOT consider lots of corner casese... for example s = "   "
	public boolean isPalindrome(String s){
		if(s == null || s.length() == 0){
			return true;
		}

		s = s.toLowerCase();

		int start = 0, end = s.length() - 1;
		char[] ch = s.toCharArray();

		while(start <= end){
			while(ch[start] < 'a' || ch[start] > 'z'){
				start++;
			} 
			while(ch[end] < 'a' || ch[end] > 'z'){
				end--;
			}
			
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	//------------------------------------------------------
	// Using the Character function!!!!!!!
	// Time Complexity: O(N)
	// Runtime: 8ms, beats 83.91%
	public boolean isPalindrome2(String s){
		if(s == null || s.length() == 0){
			return true;
		}

		int start = 0, end = s.length() - 1;
		//char[] ch = s.toCharArray();
		char startChar, endChar;

		while(start <= end){
			startChar = s.charAt(start);
			endChar = s.charAt(end);

			if(!Character.isLetterOrDigit(startChar)){
				start++;
			}
			else if(!Character.isLetterOrDigit(endChar)){
				end--;
			}

			else {
				if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)){
					return false;
				}
				start++;
				end--;
			}
		}
		return true;
	}

	public static void main(String[] args){
		LC125 x = new LC125();
		String s = "   ";
		System.out.println(x.isPalindrome2(s));
	}
}