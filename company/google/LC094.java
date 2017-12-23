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

class LC094{
	// Iterative Version:
	// Time Complexity: O(N), because it traversals all the nodes
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> inorder = new ArrayList<>();
		return Traversal(root, inorder);
	}

	private List<Integer> Traversal(TreeNode node, List<Integer> inorder){
		if(node == null){
			return inorder;
		}
		Traversal(node.left, inorder);
		inorder.add(node.val);
		Traversal(node.right, inorder);
		return inorder;
	}

//-------------------------------------------------------------------------
	// Time Compleixyt: O(N), because it traversals all the nodes
	public List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> inorder = new ArrayList<>();
		if(root == null){
			return inorder;
		}
		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root != null){
			// Step 1: traversal the most left substree first
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			// Step 2: get the most left node
			root = stack.pop();
			// Step 3: add to the inorder list, as the root node of current tree
			inorder.add(root.val);
			// Step 4: let the root equals to the right, then to see if the node.right has subtrees
			root = root.right;
		}
		return inorder;
	}

//-----------------------------------------------------------------------
	// Summarized version:
	public List<Integer> inorderTraversal3(TreeNode root){
		List<Integer> inorder = new ArrayList<>();
		if(root == null){
			return inorder;
		}
		Stack<TreeNode> stack = new Stack<>();

		while(!stack.isEmpty() || root != null){
			// Step 1: traversal the left node first, it will traverse until the most left node
			if(root != null){
				stack.push(root);
				root = root.left;
			}else{
				// Step 2: get the left node
				root = stack.pop();
				// Step 3: add to the inorder list, as the root node of current tree
				inorder.add(root.val);
				// Step 4: let the root equals to the right, then to see if the node.right has subtrees
				root = root.right;
			}
		}
		return inorder;
	}


	public static void main(String[] args){
		LC094 x = new LC094();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);

		List<Integer> res = x.inorderTraversal3(root);
		System.out.println(res);
	}
}