/*
106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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

public class LC106{
	// Recursive Version
	// Time Complexity：O(2^N)
	// Runtime: 5ms, beats 76.67%
	public TreeNode buildTree(int[] inorder, int[] postorder){
		if(inorder.length == 0)
			return null;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i], i);
		}

		return buildHelper(0, inorder.length - 1, 0, postorder.length - 1, postorder, map);
	}

	private TreeNode buildHelper(int inStart, int inEnd, int postStart, int postEnd, int[] postorder, Map<Integer, Integer> map){
		if(postStart > postEnd || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(postorder[postEnd]);
		int rootIdx = map.get(root.val);

		root.left = buildHelper(inStart, rootIdx - 1, postStart, postEnd - (inEnd - rootIdx) - 1, postorder, map);
		root.right = buildHelper(rootIdx + 1, inEnd, postStart + (rootIdx - inStart), postEnd - 1, postorder, map);

		return root;
	}


	public static void main(String[] args){
		int[] inorder = {4, 2, 5, 1, 8, 6, 3, 7};
		int[] postorder = {4, 5, 2, 8, 6, 7, 3, 1};

		LC106 x = new LC106();
		TreeNode root = x.buildTree(inorder, postorder);
		List<Integer> postorderOutput = LC145.postorderTraversal(root);
		for(int i = 0; i < postorderOutput.size(); i++){
			System.out.print(postorderOutput.get(i) + " ");
		}
	}
}