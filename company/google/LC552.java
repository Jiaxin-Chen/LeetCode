/*
552. Student Attendance Record II

Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

Example 1:
Input: n = 2
Output: 8 
Explanation:
There are 8 records with length 2 will be regarded as rewardable:
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
Only "AA" won't be regarded as rewardable owing to more than one absent times. 
Note: The value of n won't exceed 100,000.
*/

class LC552 {
	// Time Complexity: O(N)
	// Runtime: 72ms, beats 51.87%
	// Reference: https://leetcode.com/problems/student-attendance-record-ii/discuss/101643/Share-my-O(n)-C++-DP-solution-with-thinking-process-and-explanation
	public int checkRecord(int n) {
        if(n == 1){
            return 3;
        }
        if(n == 2){
        	return 8;
        }
        int m = 1000000007;
        
        int[] A = new int[n];
        int[] P = new int[n];
        int[] L = new int[n];
        
        A[0] = 1;
        P[0] = 1;
        L[0] = 1;
        
        A[1] = 2;
        P[1] = 3;
        L[1] = 3;

        A[2] = 4;
        
        for(int i = 2; i < n; i++){
        	// we need mod m for every value to avoid overflow
        	A[i-1] %= m;
        	P[i-1] %= m;
        	L[i-1] %= m;

        	// we need mod m for every add operation to avoid overflow
            P[i] = ((A[i-1] + P[i-1]) % m + L[i-1]) % m;
            
            if(i > 2){
                A[i] = ((A[i-1] + A[i-2]) % m + A[i-3]) % m;
            }
            
            if(i > 1){
                L[i] = ((P[i-1] + A[i-1]) % m + (P[i-2] + A[i-2]) % m) % m; 
            }
            
        }
        return ((A[n-1] % m + P[n-1] % m) % m + L[n-1] % m) % m;
    }


    public int checkRecord2(int n) {
        if(n == 1){
            return 3;
        }
        if(n == 2){
        	return 8;
        }
        int m = 1000000007;
        
        int[] A = new int[n];
        int[] P = new int[n];
        int[] L = new int[n];
        
        A[0] = 1;
        P[0] = 1;
        L[0] = 1;
        
        A[1] = 2;
        P[1] = 3;
        L[1] = 3;

        A[2] = 4;
        
        for(int i = 2; i < n; i++){
            P[i] = A[i-1] + P[i-1] + L[i-1];
            
            if(i > 2){
                A[i] = A[i-1] + A[i-2] + A[i-3];
            }
            
            if(i > 1){
                L[i] = P[i-1] + A[i-1] + P[i-2] + A[i-2]; 
            }
            
        }
        return A[n-1] + P[n-1] + L[n-1];
    }



    public static void main(String[] args){
    	LC552 obj = new LC552();
    	int n = 100;
    	System.out.println(obj.checkRecord(n));
    }
}