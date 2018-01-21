/*
276. Paint Fence

There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.
*/

class LC276{
	// Time Complexity: O(N), Space complexity: O(N)
	// Runtime: 0ms, beats 5.03%
	public int numWays(int n, int k){
		if(n == 0 || k == 0){
			return 0;
		}
		if(n == 1){
			return k;
		}

		// Because no more than two adjacent fence have the same color, 
		// we need two dp array to indicate if the dp[i]'s color is diff or the same with dp[i-1]
		int[] diff = new int[n];
		int[] same = new int[n];

		diff[0] = k;
		diff[1] = diff[0] * (k-1);
		same[0] = k;
		same[1] = k;

		for(int i = 2; i < n; i++){
			diff[i] = (diff[i-1] + same[i-1]) * (k-1);
			same[i] = diff[i-1];
		}
		return same[n-1] + diff[n-1];
	}

	//----------------------------------------------------
	// Optimization: Space
	// Time Complexity: O(N), Space complexity: O(1)
	// Runtime: 1ms, beats 0.66%
	public int numWays2(int n, int k){
		if(n == 0 || k == 0){
			return 0;
		}
		if(n == 1){
			return k;
		}

		int diff = k * (k - 1);
		int same = k;
		int curDiff = 0;

		for(int i = 2; i < n; i++){
			curDiff = diff;
			diff = (diff + same) * (k - 1);
			same = curDiff;
		}
		return diff + same;
	}

	public static void main(String[] args){
		LC276 x= new LC276();
		int n = 3, k = 2;
		System.out.println(x.numWays2(n, k));
	}
}