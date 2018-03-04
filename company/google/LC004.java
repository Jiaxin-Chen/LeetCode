/*
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

class LC004{
	/*
	对于一个长度为n的已排序数列a，若n为奇数，中位数为a[n / 2 + 1], 若n为偶数，则中位数(a[n / 2] + a[n / 2 + 1]) / 2; 
	如果我们可以在两个数列中求出第K小的元素，便可以解决该问题; 不妨设数列A元素个数为n，数列B元素个数为m，各自升序排序，求第k小元素; 
	取A[k / 2] B[k / 2] 比较; 如果 A[k / 2] > B[k / 2] 那么，所求的元素必然不在B的前k / 2个元素中(证明反证法); 
	反之，必然不在A的前k / 2个元素中，于是我们可以将A或B数列的前k / 2元素删去，求剩下两个数列的; k - k / 2小元素，
	于是得到了数据规模变小的同类问题，递归解决; 如果 k / 2 大于某数列个数，所求元素必然不在另一数列的前k / 2个元素中，同上操作就好。
	*/

	// Binary Search
	// Time Complexity: O(log(min(m+n)))
	// Runtime: 63ms, beats 84.89%
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		// Actually we don't need consider (nums1 == null || nums2 == null) here
		// nums1 = [], nums2 = [1] is valid input
		/*
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
			return 0.0;
		}*/

		int m = nums1.length, n = nums2.length;

		// If the (m + n) is odd, just return the k-th = (m+n)/2+1 number
		if((m + n) % 2 == 1){
			return findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1);
		// if (m + n) is even, return the k-th = (m+n)/2 and (k+1)-th = (m+n)/2+1 that make up a median
		}else{
			return (findKth(nums1, 0, nums2, 0, (m + n) / 2) + findKth(nums1, 0, nums2, 0, (m + n) / 2 + 1)) / 2.0;
		}
	}

	// finds the Kth element in nums1 + nums2
	private int findKth(int[] nums1, int idx1, int[] nums2, int idx2, int k){
		// If nums1 is exhausted, return kth number in nums2
		if(idx1 >= nums1.length){
			return nums2[idx2 + k - 1];
		}
		// If nums2 is exhausted, return kth number in nums1
		if(idx2 >= nums2.length){
			return nums1[idx1 + k - 1];
		}
		// If k == 1, return the first number
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
		if(k == 1){
			return Math.min(nums1[idx1], nums2[idx2]);
		}

		// Get the mid of nums1 and nums2
		int mid1 = (idx1 + k/2 - 1 < nums1.length) ? nums1[idx1 + k/2 - 1] : Integer.MAX_VALUE;
		int mid2 = (idx2 + k/2 - 1 < nums2.length) ? nums2[idx2 + k/2 - 1] : Integer.MAX_VALUE;

		// Throw away half of the array from nums1 or nums2. And cut k in half
		if(mid1 < mid2){
			return findKth(nums1, idx1 + k/2, nums2, idx2, k - k/2);
		}else{
			return findKth(nums1, idx1, nums2, idx2 + k/2, k - k/2);
		}
	}


	public static void main(String[] args){
		LC004 obj = new LC004();
		int[] nums1 = new int[]{1, 2, 3, 5};
		int[] nums2 = new int[]{2, 4, 6, 8};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
	}
}