import java.util.*;

public class Solution105 {
	/*
	 * 105. Construct Binary Tree from Preorder and Inorder Traversal:
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 */
	
	
	// Recursive Version: Slower
	public TreeNode buildTree(int[] preorder, int[] inorder){
		return buildHelper(0, 0, inorder.length - 1, preorder, inorder);
	}
	
	private TreeNode buildHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
		if(preStart > preorder.length - 1 || inStart > inEnd){
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootInIdx = 0;
		
		for(int i = inStart; i <= inEnd; i++){
			if(inorder[i] == root.val){
				rootInIdx = i;
			}
		}
		
		root.left = buildHelper(preStart + 1, inStart, rootInIdx - 1, preorder, inorder);
		root.right = buildHelper(preStart + rootInIdx - inStart + 1, rootInIdx + 1, inEnd, preorder, inorder);
		return root;
	}
	
	// Recursive Version: Faster by using HashMap
	public TreeNode buildTree2(int[] preorder, int[] inorder){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i], i);
		}
		
		return buildHelper(0, 0, inorder.length - 1, preorder, map);
	}
	
	private TreeNode buildHelper(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> map){
		if(preStart > preorder.length - 1 || inStart > inEnd){
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootInIdx = map.get(root.val);
		
		root.left = buildHelper(preStart + 1, inStart, rootInIdx - 1, preorder, map);
		root.right = buildHelper(preStart + rootInIdx - inStart + 1, rootInIdx + 1, inEnd, preorder, map);
		
		return root;
	}
	
	
	public TreeNode buildTree3(int[] preorder, int[] inorder){
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
	
}
