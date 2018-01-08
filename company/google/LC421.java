/*
421. Maximum XOR of Two Numbers in an Array

Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
Could you do this in O(n) runtime?

Example:
Input: [3, 10, 5, 25, 2, 8]
Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
*/
import java.util.*;

class LC421{
	// Time Complexity: O(32 * N)
	// Time Limit Exceed...(for the largest test)
	class TrieNode{
		TrieNode[] next;
		TrieNode(){
			next = new TrieNode[2];
		}
	}

	public int findMaximumXOR(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}

		// Step 1: build Trie
		TrieNode root = new TrieNode();
		for(int num : nums){
			TrieNode cur = root;
			for(int i = 31; i >= 0; i--){
				int bit = (num >>> i) & 1;  // bit is 0 or 1
				if(cur.next[bit] == null){
					cur.next[bit] = new TrieNode();
				}
				cur = cur.next[bit];
			}
		}

		// Step 2: traverse each num 
		int max = Integer.MIN_VALUE;
		for(int num : nums){
			TrieNode cur = root;
			int curSum = 0;
			for(int i = 31; i >= 0; i--){
				int bit = (num >>> i) & 1; // bit is 0 or 1

				// bit ^ 1 = 1 - bit, because we need find if the opposite bit has a number
				if(cur.next[bit ^ 1] != null){
					curSum += (1 << i);
					cur = cur.next[bit ^ 1];  // go to the opposite position to keep finding
				}else{
					cur = cur.next[bit];
				}
			}
			max = Math.max(max, curSum);
		}
		return max;
	}


//-----------------------------------------------------------------------------------------------
	// Optimization: Bit optimization
	// Time Complexity: O(31 * n)
	// Runtime: 115ms, beats 21.10%
	public int findMaximumXOR2(int[] nums){
		int max = 0, mask = 0;

		// search from left to right, find out for each bit is there two numbers that has different value
		for(int i = 31; i >= 0; i--){
			// Step 1: mask contains the bits considered so far
			mask |= (1 << i);
			Set<Integer> set = new HashSet<>();

			// Step 2: store prefix of all number with right i bits discarded
			for(int num : nums){
				set.add(num & mask);
			}

			// Step 3: find out if there are two prefix with different i-th bit
            // if there is, the new max should be curMax with one 1 bit at i-th position
			int curMax = max | (1 << i);
			for(int prefix : set){
				//  if a^b=c, then we have a^c=b, b^c=a.
				if(set.contains(prefix ^ curMax)){
					max = curMax;
				}
			}
		}
		return max;
	}

	public static void main(String[] args){
		LC421 x = new LC421();
		int[] nums = {3, 10, 5, 25, 2, 8};
		System.out.println(x.findMaximumXOR2(nums));
	}
}

