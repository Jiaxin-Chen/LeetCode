/*
250. Count Univalue Subtrees

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

// Time Complexity: O(N)
// Runtime: 1ms, beats 12.31%
public class LC250{
	private int count;

	public int countUnivalSubtrees(TreeNode root){
		postOrder(root);

		return count;
	}

	private boolean postOrder(TreeNode node){
		if(node == null)
			return true;

		boolean left = postOrder(node.left);
		boolean right = postOrder(node.right);
		if(left && right){
			if(node.left != null && node.val != node.left.val)
				return false;
			if(node.right != null && node.val != node.right.val)
				return false;
			count++;
			return true;
		}
		return false;
	}
}