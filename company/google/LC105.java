/*
105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

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

class LC105{
	// Time Complexity: O(nlogn)
	// Runtime: 16ms, beats 62.01%
	public TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null){
			return null;
		}
		
		return DFS(preorder, inorder, 0, 0, inorder.length - 1);
	}

	private TreeNode DFS(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
		if(preStart > preorder.length - 1 || inStart > inEnd){
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int inIdx = 0;
		for(int i = inStart; i <= inEnd; i++){
			if(inorder[i] == root.val){
				inIdx = i;
			}
		}
		root.left = DFS(preorder, inorder, preStart + 1, inStart, inIdx - 1);
		root.right = DFS(preorder, inorder, preStart + inIdx - inStart + 1, inIdx + 1, inEnd);
		return root;
	}
}