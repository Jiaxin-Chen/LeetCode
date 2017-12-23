/*
144. Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
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

class LC144{
	// Recursive version:
	// Time Complexity: O(N)
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> preorder = new LinkedList<>();
		return Traversal(root, preorder);
	}

	private List<Integer> Traversal(TreeNode root, List<Integer> preorder){
		if(root == null){
			return preorder;
		}
		preorder.add(root.val);
		Traversal(root.left, preorder);
		Traversal(root.right, preorder);
		return preorder;
	}

//---------------------------------------------------------------------------
	// Iterative version:
	// Time Compelxity: O(N)
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> preorder = new LinkedList<>();
		if(root == null){
			return preorder;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}

		return preorder;
	}

//---------------------------------------------------------------------------
	// Summarized version:
	// Time Compelxity: O(N)
	public List<Integer> preorderTraversal3(TreeNode root){
		List<Integer> preorder = new LinkedList<>();
		if(root == null){
			return preorder;
		}
		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root != null){
			if(root != null){
				preorder.add(root.val);
				stack.push(root);
				root = root.left;
			}else{
				root = stack.pop();
				root = root.right;
			}
		}

		return preorder;
	}

	public static void main(String[] args){
		LC144 X = new LC144();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		List<Integer> res = X.preorderTraversal3(root);
		System.out.println(res);
	}
}