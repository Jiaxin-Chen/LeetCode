import java.util.*;

public class Solution106 {
	/*
	 * 106. Construct Binary Tree from Inorder and Postorder Traversal:
	 * Given inorder and postorder traversal of a tree, construct the binary tree.
	 */
	
	public TreeNode buildTree(int[] inorder, int[] postorder){
		if(inorder == null || inorder.length == 0){
			return null;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i], i);
		}
		
		return buildHelper(0, inorder.length - 1, 0, postorder.length - 1, postorder, map);
	}
	
	private TreeNode buildHelper(int inStart, int inEnd, int postStart, int postEnd, int[] postorder, Map<Integer, Integer> map){
		if(postStart > postEnd || inStart > inEnd){
			return null;
		}
		
		TreeNode root = new TreeNode(postorder[postEnd]);
		int rootIdx = map.get(root.val);
		root.left = buildHelper(inStart, rootIdx - 1, postStart, postEnd - inEnd + rootIdx - 1, postorder, map);
		root.right = buildHelper(rootIdx + 1, inEnd, postStart - rootIdx + inStart - 1, postEnd - 1, postorder, map);
		
		return root;
		
	}
}
