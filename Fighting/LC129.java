/*
129. Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */

class TreeNode{
	int val;
	TreeNode left; 
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

public class LC129{
	// Recursive version: 
	// Time Complexity: (2^N)
	// Runtime: 0ms, beats 64.01%
	public int sumNumbers(TreeNode root){
		return traversal(root, 0);
	}

	private int traversal(TreeNode root, int sum){
		if(root == null)
			return 0;

		if(root.left == null && root.right == null)
			return sum * 10 + root.val;

		return traversal(root.left, sum * 10 + root.val) + traversal(root.right, sum * 10 + root.val);
	}
}