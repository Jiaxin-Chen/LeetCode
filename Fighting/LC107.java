/*
107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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

public class LC107{
	// Recursive Version:
	// Time Complexity: O(N)
	// Runtime: 5ms, beats 5.57%
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)
			return res;
		Helper(res, root, 0);
		return res;
	}

	private void Helper(List<List<Integer>> res, TreeNode root, int level){
		if(root == null)
			return;
		if(res.size() <= level)
			res.add(0, new ArrayList<>());
		Helper(res, root.left, level + 1);
		Helper(res, root.right, level + 1);
		res.get(res.size() - level - 1).add(root.val);
	}


	// Iterative Version:
	// Time Complexity: O(N)
	// Runtime: 2ms, beats 72.70%
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			List<Integer> list = new LinkedList<Integer>();
			int levelNum = queue.size();

			for(int i = 0; i < levelNum; i++){
				TreeNode node = queue.peek();
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
				list.add(queue.poll().val);
			}
			res.add(0, list);
		}
		return res;
	}
}