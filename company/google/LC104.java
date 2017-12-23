/*
104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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

class LC104{
	// DFS
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 13.16%
	public int maxDepth(TreeNode root){
		return depth(root);
	}

	private int depth(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);

		return 1 + Math.max(left, right);
	}

	// BFS
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 4.58%
	public int maxDepth2(TreeNode root){
		if(root == null){
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int depth = 0;

		while(!queue.isEmpty()){
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
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
		LC104 x = new LC104();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.left.right.right = new TreeNode(2);
		root.right.left.left = new TreeNode(5);

		System.out.println(x.maxDepth2(root));

	}
}

