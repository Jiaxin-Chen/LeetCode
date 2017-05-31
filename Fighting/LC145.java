/*
145. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.*;
/*
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
*/
public class LC145{

	// Recursive version
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 58.50%
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> postorder = new ArrayList<Integer>();
		return traversal(postorder, root);
	}

	private static List<Integer> traversal(List<Integer> postorder, TreeNode root){
		if(root == null)
			return postorder;

		traversal(postorder, root.left);
		traversal(postorder, root.right);
		postorder.add(root.val);

		return postorder;
	}

	// Iterative Version:
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 7.71%
	public List<Integer> postorderTraversal2(TreeNode root){
		/* Better to use LinkedList than ArrayList here!!! 
		   Because it takes O(1) for LinkedList to insert while O(N) for ArrayList to insert!!!
		 */
		List<Integer> postorder = new LinkedList<Integer>(); 

		if(root == null)
			return postorder;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			postorder.add(0, cur.val);
			if(cur.left != null)
				stack.push(cur.left);
			if(cur.right != null)
				stack.push(cur.right);
		}

		return postorder;
	}
}