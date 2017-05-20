/*
66. Plus One

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.
*/

public class LC066{
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 46.87%
	public int[] plusOne(int[] digits){
		if(digits.length == 0){
			return digits;
		}

		for(int i = digits.length - 1; i >= 0; i--){
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;
	}

	public static void main(String[] args){
		int[] digits = {1, 5, 9, 9, 9, 9};
		LC066 x = new LC066();
		int[] res = x.plusOne(digits);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i] + " ");
		}
	}
}