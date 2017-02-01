import java.util.*;


public class Solution94 {
	/* 94. Binary Tree Inorder Traversal:
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 */
	
	public static List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}
		return list;
	}
	
	
	public static void main(String[] args){
		TreeNode p = new TreeNode(0);
		int[] preOrder = {20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
		TreeNode root = p.buildTree(preOrder, preOrder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("Inorder Traversal of Constructed Tree : ");
		p.displayTreeNode(root);
	}
}
