/*
668. Kth Smallest Number in Multiplication Table

Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the multiplication table?

Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th smallest number in this table.

Example 1:
Input: m = 3, n = 3, k = 5
Output: 
Explanation: 
The Multiplication Table:
1	2	3
2	4	6
3	6	9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).
Example 2:
Input: m = 2, n = 3, k = 6
Output: 
Explanation: 
The Multiplication Table:
1	2	3
2	4	6

The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
Note:
The m and n will be in the range [1, 30000].
The k will be in the range [1, m * n]
*/

class LC668 {
	// Binary Search
	// Time Complexity: O(mnlog(mn))
	// Runtime: 24ms, beats 54.61%
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n + 1;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            System.out.println("low = " + low + ", high = " + high + ", mid = " + mid);
            int count = 0, j = n - 1;
            for(int i = 0; i < m; i++){
                while(j >= 0 && (i+1) * (j+1) > mid){
                    j--;
                }
                count += j + 1;
                System.out.println("count = " + count + ", j + 1= " + j + 1);
            }
            if(count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args){
    	LC668 obj = new LC668();
    	int m = 3, n = 3, k = 5;
    	System.out.println(obj.findKthNumber(m, n, k));
    }
}