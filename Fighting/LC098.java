/*
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}


public class LC098{
	// Recursive Version:
	public boolean isValidBST(TreeNode root){
		return validate(root, null);
	}

	private boolean validate(TreeNode root, TreeNode prev){
		if(root == null)
			return true;
		if(!validate(root.left, prev))
			return false;
		if(prev != null && prev.val >= root.val)
			return false;
		prev = root;
		return validate(root.right, prev);
	}


	// Iterative Version: 
	// Time Complexity: O(N)
	// Runtime: 4ms, beats 11.74%
	public boolean isValidBST(TreeNode root){
		if(root == null)
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;

		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if(prev != null && root.val <= prev.val)
				return false;
			prev = root;
			root = root.right;

		}
		return true;
	}
}