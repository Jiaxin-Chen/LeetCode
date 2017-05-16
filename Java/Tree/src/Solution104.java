import java.util.*;

public class Solution104 {
	/*
	 * 104. Maximum Depth of Binary Tree：
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 */
	
	
	// Recursive Version: 2ms
	public int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	// BFS Version: 3ms
	public int maxDepth2(TreeNode root){
		if(root == null){
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = 0;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			// Level Traversal
			while(size-- > 0){
				TreeNode cur = queue.poll();
				if(cur.left != null){
					queue.offer(cur.left);
				}
				if(cur.right != null){
					queue.offer(cur.right);
				}
			}
			count++; // count++ for every level
		}
		return count;
	}
}
