/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC110{
	// Time Complexity: O(N^2)
	// Runtime: 2ms
	public boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int depth(TreeNode root){
		if(root == null){
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}

//-----------------------------------------------------------------------------------
    // Optimization: O(N)
	// Runtime: 2ms, beats 26.66%
	public boolean isBalanced2(TreeNode root){
		if(root == null){
			return true;
		}
		depth2(root);
		return  flag;
	}

	private boolean flag = true;

	private int depth2(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);

		// Optimization part: we can judge the left and right's balance inside the traversal
		if(Math.abs(left - right) > 1){
			flag = false;
		}
		
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args){
		LC110 x = new LC110();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		//root.right.right.left = new TreeNode(8);

		System.out.println(x.isBalanced2(root));
	}
}