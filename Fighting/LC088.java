/*
88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class LC088{
	public void merge(int[] nums1, int m, int[] nums2, int n){
		
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while(i >= 0 && j >= 0){
			if(nums1[i] > nums2[j]){
				nums1[k--] = nums1[i--];
			}else{
				nums1[k--] = nums2[j--];
			}
		}

		while(j >= 0){
			nums1[k--] = nums2[j--];
		}

	}

	public int[] merge2(int[] nums1, int m, int[] nums2, int n){
		
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		int[] res = new int[m+n];

		while(i >= 0 && j >= 0){
			if(nums1[i] > nums2[j]){
				res[k--] = nums1[i--];
			}else{
				res[k--] = nums2[j--];
			}
		}

		while(i >= 0){
			res[k--] = nums1[i--];
		}

		while(j >= 0){
			res[k--] = nums2[j--];
		}
		return res;
	}

	public static void main(String[] args){
		int[] nums1 = {1, 3, 5, 9};
		int[] nums2 = {2, 4, 5, 6, 10};
		LC088 x = new LC088();
		int[] res = x.merge2(nums1, nums1.length, nums2, nums2.length);

		for(int i = 0; i < res.length; i++){
			System.out.print(res[i] + " ");
		}
	}
}