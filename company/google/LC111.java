/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

class LC111{
	// DFS
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 6.17%
	public int minDepth(TreeNode root){
		return depth(root);
	}

	private int depth(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);

		// Modification from the LC104: judge if both the left and right part == 0
		return (left == 0 || right == 0) ? 1 + left + right : 1 + Math.min(left, right);
	}
//--------------------------------------------------------------------------------------
	// BFS
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 6.17%
	public int minDepth2(TreeNode root){
		if(root == null){
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 1;

		while(!queue.isEmpty()){
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
				// Modification from the LC104: add to judge if both the left and right child == null
				if(node.left == null && node.right == null){
					return depth;
				}
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
			depth++;
		}
		return depth;
	}


	public static void main(String[] args){
		LC111 x = new LC111();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		//root.right.left = new TreeNode(1);
		//root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(2);
		//root.right.left.left = new TreeNode(5);

		System.out.println(x.minDepth2(root));

	}
}

