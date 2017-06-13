/*
102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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

public class LC102{
	// Iterative Version:
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 15.21%
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res = new LinkedList<>();
		if(root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < levelNum; i++){
				TreeNode node = queue.peek();
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
				list.add(queue.poll().val);
			}
			res.add(list);
		}
		return res;
	}

	// Recursive Version:
	// Time Complexity: O(N)
	// Runtime: 3ms, beats 15.21%
	public List<List<Integer>> levelOrder2(TreeNode root){
		List<List<Integer>> res = new LinkedList<>();
		if(root == null)
			return res;
		Helper(res, root, 0);
		return res;
	}

	private void Helper(List<List<Integer>> res, TreeNode root, int level){
		if(root == null)
			return;
		if(res.size() <= level)
			res.add(new LinkedList<>());
		Helper(res, root.left, level + 1);
		Helper(res, root.right, level + 1);
		res.get(level).add(root.val);
	}

}