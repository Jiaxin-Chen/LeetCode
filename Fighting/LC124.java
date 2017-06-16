/*
124. Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */

class TreeNode{
	int val;
	TreeNode left; 
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

public class LC124{
	// Time Complexity: O(2^N)
	// Runtime: 2ms, beats 48.58%

	int maxRes = 0;
	public int maxPathSum(TreeNode root){
		maxRes = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxRes;
	}

	private int maxPathDown(TreeNode root){
		if(root == null)
			return 0;
		int left = Math.max(0, maxPathDown(root.left));
		int right = Math.max(0, maxPathDown(root.right));
		maxRes = Math.max(maxRes, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}