/*
526. Beautiful Arrangement

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array 
that is constructed by these N numbers successfully if one of the following is true 
for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:
Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:
Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

Note:
N is a positive integer and will not exceed 15.
*/

class LC526{
	// Time Complexity: O(NlogN)
	// Runtime: 96ms, beats 47.14%
	public int countArrangement(int N){
		if(N == 0){
			return 0;
		}
		backtracking(N, 1, new boolean[N + 1]);
		return count;
	}

	private int count = 0;

	private void backtracking(int N, int pos, boolean[] used){
		if(pos > N){
			count++;
			return;
		}

		for(int i = 1; i <= N; i++){
			if(!used[i] && (i % pos == 0 || pos % i == 0)){
				used[i] = true;
				backtracking(N, pos + 1, used);
				used[i] = false;
			}
		}
	}

//-------------------------------------------------------------------
	// Time Complexity: O(NlogN)
	// Runtime: 48ms, beats 82.59%
	public int countArrangement2(int N){
		if(N == 0){
			return 0;
		}
		int[] nums = new int[N + 1]; // use nums[0] to record the count result
		for(int i = 0; i <= N; i++){
			nums[i] = i;
		}
		backtracking2(nums, N, 1);
		return nums[0];
	}

	private void backtracking2(int[] nums, int N, int pos){
		if(pos > N){
			nums[0]++;
			return;
		}
		for(int i = pos; i <= N; i++){
			
			swap(nums, pos, i);
			if(nums[pos] % pos == 0 || pos % nums[pos] == 0){
				backtracking2(nums, N, pos + 1);
			}
			swap(nums, i, pos);
		}
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args){
		int N = 10;
		LC526 x = new LC526();
		System.out.println(x.countArrangement2(N));
	}
}