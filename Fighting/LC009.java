/*
9. Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)
If you are thinking of converting the integer to string, note the restriction of using extra space.
You could also try reversing an integer. 
However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
How would you handle such case?
*/

public class LC009{
	// Time Complexity: O(N)
	// Runtime: 280ms, beats 13.26%
	public boolean isPalindrome(int x){
		if(x < 0 || (x != 0 && x % 10 == 0))
			return false;

		int res = 0;
		while(x > res){
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return (x == res || x == res / 10);
	}

	public static void main(String[] args){
		int x = 12364321;
		LC009 xxx = new LC009();
		System.out.println(xxx.isPalindrome(x));
	}
}
