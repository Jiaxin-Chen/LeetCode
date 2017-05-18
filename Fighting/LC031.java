/*
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.

Next Permutation Algorithm: 
1) Find the largest index k such that nums[k] < nums[k + 1]. 
If no such index exists, the permutation is sorted in descending order, just reverse it to ascending order and we are done. 
For example, the next permutation of [3, 2, 1] is [1, 2, 3].
2) Find the largest index l greater than k such that nums[k] < nums[l].
3) Swap the value of nums[k] with that of nums[l].
4) Reverse the sequence from nums[k + 1] up to and including the final element nums[nums.size() - 1].


Examples:
	Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 → 1,3,2
	3,2,1 → 1,2,3
	1,1,5 → 1,5,1
*/

public class LC031{

	// Time Complexity: O(N)
	// Runtime: 28ms, beats 10.86%
	public void nextPermutation(int[] nums){
		if(nums == null || nums.length < 2){
			return;
		}

		int k = nums.length - 2;
		while(k >= 0){
			if(nums[k] < nums[k+1]){
				break;
			}
			k--;
		}

		if(k == -1){
			reverse(nums, 0, nums.length - 1);
			return;
		}

		int l = nums.length - 1;
		while(l > k){
			if(nums[l] > nums[k]){
				break;
			}
			l--;
		}

		swap(nums, l, k);
		reverse(nums, k+1, nums.length - 1);
		return;
	}

	private void reverse(int[] nums, int start, int end){
		if(nums == null || nums.length < 2 || start >= end){
			return;
		}
		for(int i = start; i <= (start + end) / 2; i++){
			swap(nums, i, end - (i - start));
		}
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}



	public static void main(String[] args){
		int[] nums = {3, 2, 1};
		LC031 x = new LC031();
		x.nextPermutation(nums);

		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
}

