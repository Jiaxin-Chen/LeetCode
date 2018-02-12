/*
69. Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be trunc
*/

class LC069 {
	public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        
        int left = 1, right = Integer.MAX_VALUE;
        
        // Near the very end, closest step, before while loop, left = mid = right.
		// In while, If mid < sqrt(x), left = mid + 1 executed, right pointer is not moving, and right is the answer.
		// If while, If mid > sqrt(x), right = mid - 1 executed, right pointer shifts left 1, closest to sqrt(x), right is also the answer.
        while(left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (mid == x / mid){
                return mid;
            }else if(mid < x / mid){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return right;
    }
}