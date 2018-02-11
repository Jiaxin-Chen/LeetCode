/*
50. Pow(x, n)


Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
*/

class LC050{
	// Time Complexity: O(logN)
	// we can keep a running total of repeatedly squaring x - (x, x^2, x^4, x^8, etc) and multiply it by the answer 
	public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        // cannot use myPow(1/x, -n), because if:
        // corner case: x = 1.00000, n = -2147483648
        if(n < 0){
            return (1/x) * myPow(1/x, -(n + 1));
        }
        
        double res = 1;
        while(n > 0){
        	if((n & 0x1) == 1){
            	res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }


	// Time Complexity: O(N)
	// TLE
	public double myPow2(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return (1/x) * myPow(1/x, -(n + 1));
        }
        
        double res = 1;
        while(n > 0){
            res *= x;
            n -=1;
        }
        return res;
    }
}