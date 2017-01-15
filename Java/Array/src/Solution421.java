import java.util.HashSet;

public class Solution421 {
	/* 421. Maximum XOR of Two Numbers in an Array 
	 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 2^31.
	 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
	 * 
	 * Input: [3, 10, 5, 25, 2, 8]
	 * Output: 28 (5 ^ 25 = 28, 0000 0101 ^ 0001 1001 = 0001 1100 )
	 * Complexity: Time O(N)
	 */
	public static int findMaximumXOR(int[] nums){
				
		if (nums == null || nums.length <= 1){
			return 0;
		}
		
		int maxXOR = 0, mask = 0;
		for (int i = 31; i >= 0; i--){
			mask |= 1 << i;
			HashSet<Integer> set = new HashSet<Integer>();
			
			/* For example:
			 * Given [14, 11, 7, 2], binary:[1110, 1011, 0111, 0010], max = 0
			 * i = 3, mask = 1000, set = {1000, 0000}, tmp = 1000, tmp ^ 0000 in set, max = 1000
			 * i = 2, mask = 1100, set = {1100, 1000, 0100, 0010}, tmp = 1100, tmp ^ 1000 in set, max = 1100
			 * i = 1, mask = 1110, set = {1110, 1010, 0110, 0010}, tmp = 1110, no tmp ^ prefix in set, max = 1100
			 * i = 0, mask = 1111, set = {1110, 1011, 0111, 0010}, tmp = 1101, no tmp ^ prefix in set, max = 1100
			 */
			for (int num : nums){
				set.add(num & mask);
			}
			
			/* To iteratively determine what would be each bit of the final result from left to right.
			 * if a ^ prefix =candidate then a ^ candidate  = prefix, prefix ^ candidate = a (we use this one)
             * prefix is already in the set, check if "a" exist in the set
             */
			int candidate = maxXOR | (1 << i); //we hope it has the next maxXOR max|(1<<i), which is bigger than current maxXOR
			for (int prefix : set){
				if(set.contains(candidate ^ prefix)){
					maxXOR = candidate;
					break;
				}
			}	
		}
		
		return maxXOR;
	}
	
	
	// Time Limit Exceeded in LeetCode, Time O(N^2)
	public static int findMaximumXOR2(int[] nums){
	
		int result = nums[0] ^ nums[1];
		for (int i = 0; i < nums.length; i++){
			for (int j = 1; j < nums.length; j++){
				if (i != j){
					int temp = nums[i] ^ nums[j];
					if (temp > result){
						result = temp;
					}
				}
			}
			
		}
		return result;
		
	}
}
