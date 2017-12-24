/*
112. Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

class TreeNode{
	int val; 
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC112{
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		DFS(root, root.val, sum);
		return hasPath;
	}

	private boolean hasPath = false;

	private void DFS(TreeNode root, int curSum, int sum){
		System.out.println(root.val);
		if(root.left == null && root.right == null && curSum == sum){
			hasPath = true;
		}
		if(root.left != null){
			DFS(root.left, curSum + root.left.val, sum);
		}
		if(root.right != null){
			DFS(root.right, curSum + root.right.val, sum);
		}
	}

	public static void main(String[] args){
		LC112 X = new LC112();
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		*/
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		int sum = -2;

		System.out.println(X.hasPathSum(root, sum));

	}
}