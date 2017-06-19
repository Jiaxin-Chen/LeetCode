/*
135. Candy

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */

public class LC135{
	// Time Complexity: O(N)
	// Runtime: 4ms, beats 71.15%
	public int candy(int[] ratings){
		int len = ratings.length, res = 0;
		if(len <= 1)
			return len;
		int[] nums = new int[len];
		for(int i = 0; i < len; i++)
			nums[i] = 1;

		for(int i = 1; i < len; i++){
			if(ratings[i-1] < ratings[i])
				nums[i] = nums[i-1] + 1;
		}

		for(int i = len - 1; i > 0; i--){
			if(ratings[i-1] > ratings[i])
				nums[i-1] = Math.max(nums[i-1], nums[i] + 1);
		}

		for(int i = 0; i < len; i++)
			res += nums[i];

		return res;
	}
}