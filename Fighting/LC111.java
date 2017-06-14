/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

import java.util.*;

public class LC111{
	// Recursive Version:
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 19.57%
	public int minDepth(TreeNode root){
		 if(root == null)
            return 0;
        int left = minDepth(root.left);
        int right =  minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}

	// Iterative Version:
	// Time Complexity: O(MN)
	// Runtime: 1ms, beats 4.35%
	public int minDepth2(TreeNode root){
		if(root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 1;
		while(!queue.isEmpty()){
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null)
					return depth;
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			depth++;
		}
		return depth;
	}
}