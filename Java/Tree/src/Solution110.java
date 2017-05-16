
public class Solution110 {
	/*
	 * 110. Balanced Binary Tree:
	 * Given a binary tree, determine if it is height-balanced.
	 * For this problem, a height-balanced binary tree is defined as a binary tree in 
	 * which the depth of the two subtrees of every node never differ by more than 1.
	 */
	
	private boolean res = true;
	public boolean isBalanced(TreeNode root){
		Height(root);
		return res;
	}
	
	private int Height(TreeNode root){
		if(root == null){
			return 0;
		}
		
		int left = Height(root.left);
		int right = Height(root.right);
		
		if(Math.abs(left - right) > 1){
			res = false;
		}
		
		return Math.max(left, right) + 1;
	}
}
