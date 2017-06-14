/*
108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

public class LC108{
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 14.76%
	public TreeNode sortedArrayToBST(int[] nums){
		if(nums == null || nums.length ==0)
			return null;
		return Helper(nums, 0, nums.length - 1);
	}

	private TreeNode Helper(int[] nums, int start, int end){
		if(start > end)
			return null;
		int mid = end - (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);

		root.left = Helper(nums, start, mid - 1);
		root.right = Helper(nums, mid + 1, end);
		return root;
	}
}