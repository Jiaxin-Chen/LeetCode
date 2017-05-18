/*
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
	nums1 = [1, 3], nums2 = [2], the median is 2.0.

Example 2: 
	nums1 = [1, 2], nums2 = [3, 4], the median is (2 + 3)/2 = 2.5.
*/

public class LC004{

	// Genuis!!!!!
	// Ref: https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/2
	// Time Complexity: O(log(min(m, n)))
	// Runtime: 65ms, beat 83.70%!
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		
		int m = nums1.length, n = nums2.length;

		// Make sure nums2 is the shorter one.
		if(m < n){
			return findMedianSortedArrays(nums2, nums1);
		}

		// If nums2 is empty
		if(n == 0){
			return (double)(nums1[(m-1)/2] + nums1[m/2])/2.0;
		}

		int left = 0, right = n * 2;
		while(left <= right){
			int mid2 = (left + right) / 2;
			int mid1 = m + n - mid2;

			double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];
			double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
			double R1 = (mid1 == m*2) ? Integer.MAX_VALUE : nums1[mid1/2];
			double R2 = (mid2 == n*2) ? Integer.MAX_VALUE : nums2[mid2/2];

			if(L1 > R2){
				left = mid2 + 1;
			}else if(L2 > R1){
				right = mid2 - 1;
			}else{
				return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
			}
		}
		return -1;

	}

	public static void main(String[] args){
		int[] nums1 = {10000};
		int[] nums2 = {10001};
		LC004 x = new LC004();
		double res = x.findMedianSortedArrays(nums1, nums2);
		System.out.println(res);
	}
}