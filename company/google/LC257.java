/*
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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

class LC257{
	public List<String> binaryTreePaths(TreeNode root){
		List<String> res = new LinkedList<>();
		if(root == null){
			return res;
		}
		DFS(res, root, String.valueOf(root.val));
		return res;
	}

	public void DFS(List<String> res, TreeNode root, String path){
		if(root.left == null && root.right == null){
			res.add(path);
			return;
		}
		if(root.left != null){
			DFS(res, root.left, path + "->" + root.left.val);
		}
		if(root.right != null){
			DFS(res, root.right, path + "->" + root.right.val);
		}
	}

	public static void main(String[] args){
		LC257 x = new LC257();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(2);
		root.right.left.left = new TreeNode(5);

		System.out.println(x.binaryTreePaths(root));
	}
}