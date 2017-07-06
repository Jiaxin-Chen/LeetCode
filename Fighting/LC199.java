/*
199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */

import java.util.*;

public class LC199{
	// BFS Version:
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 31.18%
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
				if(i == 0)
					res.add(node.val);
				if(node.right != null)
					queue.offer(node.right);
				if(node.left != null)
					queue.offer(node.left);
			}
		}
		return res;
	}


	// DFS Version:
	// Time Complexity: O(N)
	// Runtime: 1ms, beats 74.39%
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		Helper(root, res, 0);
		return res;
	}

	private void Helper(TreeNode root, List<Integer> res, int depth){
		if(root == null)
			return;

		if(depth == res.size())
			res.add(root.val);

		Helper(root.right, res, depth + 1);
		Helper(root.left, res, depth + 1);
	}
}