/*
687. Longest Univalue Path

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC687{

	public int longestUnivaluePath(TreeNode root){
		if(root == null){
			return 0;
		}
		DFS(root);
		return res;
	}

	private int res = 0;

	// int DFS(node) returns the Longest-Univalue-Path-Start-At that node, 
	// and update the result of Longest-Univalue-Path-Across that node through side effect.
	private int DFS(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftLen = DFS(root.left);  // leftLen is the length of single direction Longest-Univalue-Path start from left-child
		int rightLen = DFS(root.right);// rightLen is the length of single direction Longest-Univalue-Path start from right-child

		int leftPath = 0;  // leftPath is the length of single direction Longest-Univalue-Path start from parent go left
		int rightPath = 0; // rightPath is the length of single direction Longest-Univalue-Path start from parent go right

		if(root.left != null && root.val == root.left.val){
			leftPath = leftLen + 1;
		}
		if(root.right != null && root.val == root.right.val){
			rightPath = rightLen + 1;
		}
		res = Math.max(res, leftPath + rightPath);
		return Math.max(leftPath, rightPath);
	}

	public static void main(String[] args){
		LC687 x = new LC687();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right = new TreeNode(5);

		System.out.println(x.longestUnivaluePath(root));
	}
}