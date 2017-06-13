/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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

public class LC101{
	// Recursive Version:
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 25.12%
	public boolean isSymmetric(TreeNode root){
		if(root == null)
			return true;

		return isSubSymmetric(root.left, root.right);
	}

	private boolean isSubSymmetric(TreeNode node1, TreeNode node2){
		if(node1 == null && node2 == null)
			return true;
		else if(node1 == null || node2 == null || node1.val != node2.val)
			return false;
		return isSubSymmetric(node1.left, node2.right) && isSubSymmetric(node1.right, node2.left);
	}


	// Iterative Version:
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 5.45%
	public boolean isSymmetric2(TreeNode root){
		if(root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.right);
		stack.push(root.left);

		while(!stack.isEmpty()){
			TreeNode node1 = stack.pop();
			TreeNode node2 = stack.pop();

			if(node1 == null && node2 == null)
				continue;
			if(node1 == null || node2 == null)
				return false;
			if(node1.val != node2.val)
				return false;
			stack.push(node1.left);
			stack.push(node2.right);
			stack.push(node1.right);
			stack.push(node2.left);	
		}
		return true;
	}

}