/*
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

class LC031 {
	// Time Complexity: O(N), Space Complexity: O(1)
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		// step1: search the first nums[k] < nums[k+1] backward
		int k = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
		}

		// if current rank is the largest, reverse it to smallest, return
		if (k == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		// step2: search the first nums[k] < nums[l] backward
		int firstLargeIdx = nums.length - 1;
		while (firstLargeIdx > k && nums[firstLargeIdx] <= nums[k]) {
			firstLargeIdx--;
		}

		// step3: swap nums[k] with nums[l]
		int tmp = nums[k];
		nums[k] = nums[firstLargeIdx];
		nums[firstLargeIdx] = tmp;

		// step4: reverse between k+1 and nums.length-1;
		reverse(nums, k + 1, nums.length - 1);
	}

	private void reverse(int[] nums, int left, int right) {
		for (int i = left, j = right; i < j; i++, j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	public static void main(String[] args) {
		LC031 x = new LC031();
		int[] nums = new int[]{1, 2, 3, 5, 4};
		x.nextPermutation(nums);

		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}