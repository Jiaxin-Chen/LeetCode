/*
29. Divide Two Integers

Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
 */

public class LC029{
	/* Two cases may cause overflow:
	   1) divisor = 0;
	   2) dividend = INT_MIN and divisor = -1 (because abs(INT_MIN) = INT_MAX + 1).
	*/
	// Time Complexity: O(logN)
	// Runtime: 39ms, beats 74.00%
	public int divide(int dividend, int divisor){
		if(divisor == 0 || (divisor == -1 && dividend == Integer.MIN_VALUE))
			return Integer.MAX_VALUE;

		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		// Utilize long datatype to make sure enough space to store bits after left shifting.
		long dd = Math.abs(dividend);
		long ds = Math.abs(divisor);
		int res = 0;
		while(dd >= ds){
			long tmp = ds, multiple = 1;
			while(dd >= (tmp << 1)){
				tmp <<= 1;
				multiple <<= 1;
				//System.out.println("tmp = " + tmp + ", multiple = " + multiple);
			}
			dd -= tmp;
			res += multiple;
			//System.out.println("dd = " + dd + ", res = " + res);
		}
		return sign == 1 ? res : -res;
	}

	public static void main(String[] args){
		int dividend = -16, divisor = 3;
		LC029 x= new LC029();
		int res = x.divide(dividend, divisor);
		System.out.println(res);
	}
}