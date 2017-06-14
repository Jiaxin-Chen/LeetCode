/*
103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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


public class LC103{
	// Iterative Version:
	// Time Complexity: O(MN)
	// Runtime: 3ms, beats 11.21%
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> res = new LinkedList<>();
		if(root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 0;
		while(!queue.isEmpty()){
			List<Integer> list = new LinkedList<Integer>();
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.peek();
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);

				if(depth % 2 == 0)
					list.add(queue.poll().val);
				else 
					list.add(0, queue.poll().val);
			}
			depth++;
			res.add(list);
		}
		return res;
	}


	// Recursive Version:
	// Time Complexity: O(2^N)
	// Runtime: 1ms, beats 90.94%
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)
			return res;
		Helper(res, root, 0);
		return res;
	}

	private void Helper(List<List<Integer>> res, TreeNode root, int depth){
		if(root == null)
			return;
		if(res.size() <= depth)
			res.add(new ArrayList<Integer>());
		Helper(res, root.left, depth + 1);
		Helper(res, root.right, depth + 1);
		if(depth % 2 == 0)
			res.get(depth).add(root.val);
		else
			res.get(depth).add(0, root.val);
	}
}