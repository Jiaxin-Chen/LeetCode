/*
107. Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

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

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC107{
	// Iterative:
	// Time Complexity: O(N)
	public List<List<Integer> > levelOrderBottom(TreeNode root){
		List<List<Integer> > res = new LinkedList<>();
		if(root == null){
			return res;
		}

		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			// Step 1: declare the current level list and get the width
			List<Integer> list = new LinkedList<>();
			int width = queue.size();

			// Step 2: traverse each node in current level, and push the next level's node
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
				list.add(node.val);

				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
			// Modification from LC102: Level Order Traversal I
			// Step 3: add the list to the first position of res
			res.add(0, list);
		}
		return res;
	}

//----------------------------------------------------------
	// Recursive:
	// Time Complexity: O(N)
	public List<List<Integer> > levelOrderBottom2(TreeNode root){
		List<List<Integer> > res = new LinkedList<>();
		return BFS(root, res, 0);
	}

	private List<List<Integer> > BFS(TreeNode root, List<List<Integer> > res, int level){
		if(root == null){
			return res;
		}
		// Step 1: if current res.size() <= level, means it's the first time enter into this level,
		// we should intialize a new list for this level
		if(res.size() <= level){
			// Modification from LC102: Level Order Traversal I
			// add the list to the first position of res
			res.add(0, new LinkedList<Integer>());
		}
		// Step 2: traverse the next level;
		BFS(root.left, res, level + 1);
		BFS(root.right, res, level + 1);

		// Step 3: add root.val to current level
		// Modification from LC102: Level Order Traversal I
		res.get(res.size() - level -1).add(root.val);
		return res;
	}

	public static void main(String[] args){
		LC107 x = new LC107();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer> > res = x.levelOrderBottom2(root);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}