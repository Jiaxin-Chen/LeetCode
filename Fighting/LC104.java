/*
104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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

public class LC104{
	// Iterative Version:
	// Time Complexity: O(MN)
	// Runtime: 3ms, beats 4.24%
	public int maxDepth(TreeNode root){
		if(root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 0;
		while(!queue.isEmpty()){
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			depth++;
		}
		return depth;
	}

	//Recursive Version:
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 16.74%
	public int maxDepth2(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}