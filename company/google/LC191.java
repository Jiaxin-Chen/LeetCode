/*
191. Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/

class LC191{

	// Time Complexity: O(N)
	public int hammingWeight(int n) {
        int bitNum = 0; 
        
        for(int i = 0; i < 32; i++){
            bitNum += n & 1;
            n >>>= 1;  // >>> is used for unsigned shift
            		   // >> is used for signed shift
        }
        return bitNum;
    }
}