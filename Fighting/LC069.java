/*
69. Sqrt(x)

Implement int sqrt(int x).
Compute and return the square root of x.
*/


public class LC069{
	// Binary Search Version
	// Time Complexity: O(logN)
	// Runtime: 3ms, beats 20.38%
	public int mySqrt(int x){
		if(x == 0)
			return 0;

		//int left = 1, right = Integer.MAX_VALUE;
		int left = 1, right = x / 2, res = 0;
		while(left <= right){
			int mid = left + (right - left) / 2;
			int quotient = x / mid;  // Utilize "/" to avoid overflow
			if(mid == quotient)
				return mid;
			else if(mid < quotient){
				res = mid;      // Record the floor of the sqrt
				left = mid + 1;
			}
			else
				right = mid - 1;
			System.out.println("mid = " + mid + ", left = " + left + ", right = " + right);
		}
		return res;
	}

	// Newton Method Version:
	// Time Complexity; O(logN)
	// Runtime: 3ms, beats 20.38%
	public int mySqrt2(int x){
		long res = x;
		while(res * res > x)
			res = (res + x / res) / 2;
		return (int)res;
	}

	public static void main(String[] args){
		int x = 6;
		LC069 xxx = new LC069();
		int res = xxx.mySqrt2(x);
		System.out.println(res);
	}
}