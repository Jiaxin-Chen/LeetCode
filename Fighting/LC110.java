/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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

public class LC110{
	// Recursive Version:
	// Time Complexity: O(2^N)
	// Runtime: 2ms, beats 26.66%
	public boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		compareHeight(root);
		return flag;
	}

	private boolean flag = true;

	private int compareHeight(TreeNode root){
		if(root == null)
			return 0;
		int left = compareHeight(root.left);
		int right = compareHeight(root.right);

		if(Math.abs(left - right) > 1)
			flag = false;
		return Math.max(left, right) + 1;
	}

}