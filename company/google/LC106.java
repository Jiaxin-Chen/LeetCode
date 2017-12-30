/*
106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC106{
	// Time Complexity: O(nlogn)
	// Runtime: 16ms, beats 20.28%
	public TreeNode buildTree(int[] inorder, int[] postorder){
		if(postorder == null || inorder == null){
			return null;
		}
		
		return DFS(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode DFS(int[] postorder, int[] inorder, int postEnd, int inStart, int inEnd){
		if(postEnd < 0 || inStart > inEnd){
			return null;
		}

		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIdx = 0;
		for(int i = inStart; i <= inEnd; i++){
			if(inorder[i] == root.val){
				inIdx = i;
			}
		}
		root.left = DFS(postorder, inorder, postEnd - (inEnd - inIdx + 1), inStart, inIdx - 1);
		root.right = DFS(postorder, inorder, postEnd - 1, inIdx + 1, inEnd);
		return root;
	}
}