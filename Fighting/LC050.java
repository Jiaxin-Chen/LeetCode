/*
50. Pow(x, n)

Implement pow(x, n).
 */

public class LC050{
	// Recursive version:
	// Time Complexity: O(NlogN)
	// Runtime: 25ms, beats 20.68
	public double myPow(double x, int n){
		if(n == 0)
			return 1;
		// Corner case: x = 2.0, n = -2147483648
		if(n < 0)
			return 1/x * myPow(1/x, -(n+1));
		if(n == 1)
			return x;
		if(n == 2)
			return x * x;
		if(n % 2 == 0)
			return myPow(myPow(x, n / 2), 2);
		else
			return x * myPow(myPow(x, n / 2), 2);
	}

	// Time Complexity: O(N)
	// Runtime: 22ms, beats 45.31%
	public double myPow2(double x, int n){
		if(n == 0)
			return 1;
		if(n < 0){
			return 1/x * myPow(1/x, -(n+1));
		}

		double res = 1;
		//int tmp = 1;
		while(n > 0){
			if(n % 2 == 1)
				res *= x;
			x *= x;
			n >>= 1;
		}
		return res;
	}

	public static void main(String[] args){
		LC050 xxx = new LC050();
		double x = 2.000;
		int n = -2147483648;
		double res = xxx.myPow2(x, n);
		System.out.println(res);
	}
}