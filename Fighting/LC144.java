/*
144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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

public class LC144{

	// Recursive Version
	// Time Complexity: O()
	// Runtime: 1ms, beats 36.04%
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> preorder = new ArrayList<Integer>();
		return traversal(preorder, root);
	}

	private List<Integer> traversal(List<Integer> preorder, TreeNode root){
		if(root == null)
			return preorder;

		preorder.add(root.val);
		traversal(preorder, root.left);
		traversal(preorder, root.right);
		return preorder;
	}


	// Iterative Version
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 36.04%
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> preorder = new ArrayList<Integer>();

		if(root == null)
			return preorder;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			preorder.add(cur.val);
			if(cur.right != null){
				stack.push(cur.right);
			}
			if(cur.left != null){
				stack.push(cur.left);
			}
		}

		return preorder;
	}


	// We cannot use Queue!!! Because we need output preorder!!!
	public List<Integer> preorderTraversal3(TreeNode root){
		List<Integer> preorder = new ArrayList<Integer>();

		if(root == null)
			return preorder;

		// Cannot use ArrayList for Queue
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			preorder.add(cur.val);
			if(cur.left != null){
				queue.offer(cur.left);
			}
			if(cur.right != null){
				queue.offer(cur.right);
			}
		}

		return preorder;
	}
}