/*
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
*/

public class LC070{
	/*
	The key intuition to solve the problem is that given a number of stairs n, 
	if we know the number ways to get to the points [k-1] and [k-2] respectively, 
	denoted as k_1 and k_2 , then the total ways to get to the point [k] is k_1 + k_2. 
	Because from the [k-1] point, we can take one single step to reach [k]. 
	And from the [k-2] point, we could take two steps to reach [k]. 
	After each iteration, we need update [k-2] point from [k-1], [k-1] point from [k].
	There is NO overlapping between these two solution sets, because we differ in the final step.
	*/

	// Time Complexity: O(N)
	// Runtime: 0ms, beats 14.01%
	public int climbStairs(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;

		int k_1 = 2, k_2 = 1, k = 0;

		for(int i = 2; i < n; i++){
			k = k_1 + k_2;
			k_2 = k_1;
			k_1 = k;
		}

		return k;
	}

	public static void main(String[] args){
		int n = 10;
		LC070 x = new LC070();
		System.out.println(x.climbStairs(n));
	}
}