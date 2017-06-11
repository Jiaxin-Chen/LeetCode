/*
230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Note: 
You may assume k is always valid, 1 ? k ? BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
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

public class LC230{
	// Iterative Version:
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 9.58%
	public int kthSmallest(TreeNode root, int k){
		if(root == null)
			return 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || root != null){
			while(root != null){
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if(--k == 0)
				break;
			root = root.right;
		}
		return root.val;
	}
}