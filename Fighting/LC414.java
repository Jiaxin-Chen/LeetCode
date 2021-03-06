/*
414. Third Maximum Number

Given a non-empty array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]
Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: [2, 2, 3, 1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

public class LC414{
	// Time Complexity: O(N), Space Complexity: O(1)
	// Runtime: 51.97%, beats 51.97%
	public int thirdMax(int[] nums){
		if(nums.length == 1)
			return nums[0];

		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;

		for(Integer num : nums){
			if(num.equals(max1) || num.equals(max2) || num.equals(max3))
				continue;

			if(max1 == null || num > max1){
				max3 = max2;
				max2 = max1;
				max1 = num;
			}
			else if(max2 == null || num > max2){
				max3 = max2;
				max2 = num;
			}
			else if(max3 == null || num > max3){
				max3 = num;
			}
		}

		return max3 == null ? max1 : max3;
	}

	public static void main(String[] args){
		int[] nums = {2, 2, 3, 1, 1, 4, 2, 4, 5};
		LC414 x = new LC414();
		int res = x.thirdMax(nums);
		System.out.println(res);
	}



}