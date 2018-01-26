/*
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class LC007{
	// Time Complexity: o(N)
	// Runtime: 59ms, beats 5.64%
	public int reverse(int x) {
        int sign = (x >= 0) ? 1 : -1;
        x = (x >= 0) ? x : -x;
        
        long res =  0; // we need use long type to avoid overflow!
   
        while(x > 0){
            res = res * 10 + x % 10;          
            x /= 10;
            
            // if the reversed integer overflows
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) (sign * res);
    }

//-------------------------------------------------------------------
    // Optimization: 
    // Time Complexity: o(N)
	// Runtime: 46ms, beats 34.75%
	public int reverse2(int x) {
       
        long res =  0; // we need use long type to avoid overflow!
   
   		// just use x != 0 to as the condition, which include both positive integer and negative integer
        while(x != 0){
            res = res * 10 + x % 10;          
            x /= 10;
            
            // if the reversed integer overflows
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int) res;
    }
}