/*
222. Count Complete Tree Nodes

Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right; 
	TreeNode(int x){
		val = x;
	}
}

public class LC222{
	// Time Complexity: O(N)
	// Runtime: 72ms, beats 78.55%
	public int countNodes(TreeNode root){
		int count = 0;
		int height = getHeight(root);

		while(root != null){
			if(getHeight(root.right) == height - 1){
				count += 1 << height;
				root = root.right;
			}else{
				count += 1 << height - 1;
				root = root.left;
			}
			height--;
		}
		return count;
	}

	private int getHeight(TreeNode root){
		return root == null ? -1 : 1 + getHeight(root.left);
	}
}