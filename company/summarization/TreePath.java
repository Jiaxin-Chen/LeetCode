/*
1) Given a binary tree, return all root-to-leaf paths.
2) Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
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

class TreePath{
	public List<String> treePathSummarization(TreeNode root, int sum){
		List<String> res = new LinkedList<>();
		if(root == null){
			return res;
		}
		// Step 1: get the root.val and utilize DFS to traverse the tree
		DFS(res, root, root.val, sum, String.valueOf(root.val));
		System.out.println(hasPath);
		return res;
	}

	private boolean hasPath = false;

	private void DFS(List<String> res, TreeNode root, int curSum, int sum, String path){
		// Step 2: if it's the leaf of the tree
		if(root.left == null && root.right == null){
			// we can check the current sum 
			if(curSum == sum)
				hasPath = true;
			res.add(path);
		}
		// Step 3: Go to the left subtree, add the root.left.val
		if(root.left != null){
			DFS(res, root.left, curSum + root.left.val, sum, path + "->" + String.valueOf(root.left.val));
		}
		// Step 4: Go the right subtree, add the root.right.val
		if(root.right != null){
			DFS(res, root.right, curSum + root.right.val, sum, path + "->" + String.valueOf(root.right.val));
		}
	}

	public static void main(String[] args){
		TreePath X = new TreePath();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);

		int sum = 22;

		List<String> res = X.treePathSummarization(root, sum);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}

	}
}