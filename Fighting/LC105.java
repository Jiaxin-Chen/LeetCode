/*
105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

public class LC105{

	// Iterative Version
	// Time Complexity: O(N^2)
	// Runtime: 7ms, beats 76.98%
	public TreeNode buildTree(int[] preorder, int[] inorder){
		int preIndex = 0, inIndex = 0;
		TreeNode root = new TreeNode(preorder[preIndex++]);
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);
		while(true){
			while(stack.peek().val != inorder[inIndex]){
				TreeNode cur = new TreeNode(preorder[preIndex++]);
				stack.peek().left = cur;
				stack.push(cur);
			}

			TreeNode node = null;
			while(!stack.isEmpty() && stack.peek().val == inorder[inIndex]){
				node = stack.peek();
				stack.pop();
				inIndex++;
			}

			if(preIndex == preorder.length)
				break;

			TreeNode tmp = new TreeNode(preorder[preIndex++]);
			node.right = tmp;
			stack.push(tmp);
		}
		return root;
	}

	// Recursive Version
	// Time Complexity: 
	// Runtime: 20ms, beats 36.54%
	public TreeNode buildTree2(int[] preorder, int[] inorder){
		return buildHelper2(0, 0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode buildHelper2(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
		if(preStart > preorder.length - 1 || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIdx = 0;

		for(int i = inStart; i <= inEnd; i++){
			if(inorder[i] == root.val)
				rootIdx = i;
		}

		root.left = buildHelper2(preStart + 1, inStart, rootIdx - 1, preorder, inorder);
		root.right = buildHelper2(preStart + rootIdx - inStart + 1, rootIdx + 1, inEnd, preorder, inorder);

		return root;
	}


	// Recursive Version
	// Time Complexity:
	// Runtime: 6ms, beats 78.36%
	public TreeNode buildTree3(int[] preorder, int[] inorder){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i], i);
		}

		return buildHelper3(0, 0, inorder.length - 1, preorder, map);
	}

	private TreeNode buildHelper3(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> map){
		if(preStart > preorder.length - 1 || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIdx = map.get(root.val);

		root.left = buildHelper3(preStart + 1, inStart, rootIdx - 1, preorder, map);
		root.right = buildHelper3(preStart + rootIdx - inStart + 1, rootIdx + 1, inEnd, preorder, map);

		return root;
	}










}