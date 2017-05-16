import java.util.*;

public class Solution144 {
	/*
	 * 144. Binary Tree Preorder Traversal:
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 */
	
	// Recursive version: Time
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> preorder = new LinkedList<Integer>();
		
		if(root == null){
			return null;
		}
			
		preorder.add(root.val); // Attention: This should be root.val, not root!!!
		preorder.addAll(preorderTraversal(root.left));
		preorder.addAll(preorderTraversal(root.right));
		
		return preorder;
	}
	
	
	// Iterative version: Time O(N), faster!!
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> preorder = new LinkedList<Integer>();
		
		if(root == null){
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			preorder.add(cur.val);
			
			// Attention here!! Because it's stack! We need push cur.right first!!!
			if(cur.right != null){
				stack.push(cur.right);
			}
			if(cur.left != null){
				stack.push(cur.left);
			}
		}
		return preorder;
	}
	
	
	
}
