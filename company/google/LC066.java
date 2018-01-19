/*
66. Plus One

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

class LC066{
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 23.91%
	public int[] plusOne(int[] digits){
		if(digits == null || digits.length == 0){
			return new int[0];
		}

		int carry = 1;   // the carry bit to indicate if the current digit need carry bit
		int n = digits.length;
		int[] res;

		for(int i = n - 1; i >= 0; i--){
			if(digits[i] == 9){
				digits[i] = 0;
			}else{
				digits[i] += 1;
				carry = 0;
				break;
			}
		}

		// if carry = 1, it means something like digits = {9, 9, 9} -> {1, 0, 0, 0}
		if(carry == 1){
			res = new int[n + 1];
			res[0] = 1;
		}else{
			res = digits;
		}
		return res;
	}

//--------------------------------------------------------------
	// Optimization: Myself mind, actually we don't need carry bit anymore!
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 23.91%
	public int[] plusOne2(int[] digits){
		if(digits == null || digits.length == 0){
			return new int[0];
		}

		int n = digits.length;

		for(int i = n - 1; i >= 0; i--){
			if(digits[i] == 9){
				digits[i] = 0;
			}else{
				digits[i] += 1;
				return digits;
			}
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		
		return res;
	}

	public static void main(String[] args){
		LC066 x = new LC066();
		int[] digits = new int[]{9, 8, 9};
		int[] res = x.plusOne2(digits);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}
}