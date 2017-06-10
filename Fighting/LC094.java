/*
94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
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

public class LC094{
	// Iterative Version:
	// Time Complexity: O(NlogN)
	// Runtime: 1ms, beats 39.73%
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> inorder = new ArrayList<>();
		return traversal(inorder, root);
	}

	private List<Integer> traversal(List<Integer> inorder, TreeNode root){
		if(root == null)
			return inorder;
		traversal(inorder, root.left);
		inorder.add(root.val);
		traversal(inorder, root.right);
		return inorder;
	}

	// Iterative Version:
	// Time Complexity: O(NlogN)
	// Runtime: 2ms, beats 4.38%
	public List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> inorder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				inorder.add(root.val);
				stack.push(root.right);
			}
		}
		return inorder;
	}


}