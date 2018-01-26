/*
653. Two Sum IV - Input is a BST

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
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

class LC653{

	// My fault version:
	public boolean findTarget(TreeNode root, int k){
		if(root == null){
			return false;
		}

		Set<Integer> set = new HashSet<>();
		return dfs(set, root, k);
	}

	private boolean dfs(Set<Integer> set, TreeNode root, int k){
		if(root == null){
			return false;
		}

		dfs(set, root.left, k);

		set.add(root.val);
		if(set.contains(k - root.val) && root.val != k - root.val){
			return true;
		}
		
		dfs(set, root.right, k);

		// Attention here:
		// we cannot use inorder traverse 
		// because it will return false if the target is found in the dfs(root.right) traverse
		// think of the case: preorder [2, 1, 3], target = 4, we will find the 1 + 3 = 4 in the dfs(root.right) traverse
		// but then it will still return false for the dfs(root) traverse
		// therefore, we need utilize postorder to consider the dfs(root.left) and dfs(root.right)
		return false;
	}


	//---------------------------------------------------------------
	// Correct version:
	private boolean dfs(Set<Integer> set, TreeNode root, int k){
		if(root == null){
			return false;
		}

		set.add(root.val);
		if(set.contains(k - root.val) && root.val != k - root.val){
			return true;
		}
		return dfs(set, root.left, k) && dfs(set, root.right, k);
	}


	public static void main(String[] args){
		LC653 x = new LC653();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		int k = 28;

		System.out.println(x.findTarget(root, k));
	}
}