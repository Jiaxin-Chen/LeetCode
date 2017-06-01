/*
581. Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
*/

public class LC581{
	// Time Complexity: O(N)
	// Runtime: 23ms, beats 94.50%
	public int findUnsortedSubarray(int[] nums){
		int left = -1, right = -2, n = nums.length;
		int max = nums[0], min = nums[n - 1];

		for(int i = 1; i < n; i++){
			if(nums[i] >= max){
				max = nums[i];
			}else{
				right = i;
			}

			if(nums[n-1-i] <= min){
				min = nums[n-1-i];
			}else{
				left = n - 1 - i;
			}
		}
		return right - left + 1;
	}

	public static void main(String[] args){
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		LC581 x = new LC581();
		int res = x.findUnsortedSubarray(nums);
		System.out.println(res);
	}
}

