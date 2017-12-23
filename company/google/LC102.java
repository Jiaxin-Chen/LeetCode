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

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}

class LC102{
	// Iterative:
	// Time Complexity: O(N)
	public List<List<Integer> > levelOrder(TreeNode root){
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
			res.add(list);
		}
		return res;
	}

//----------------------------------------------------------
	// Recursive:
	// Time Complexity: O(N)
	public List<List<Integer> > levelOrder2(TreeNode root){
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
			res.add(new LinkedList<Integer>());
		}
		// Step 2: traverse the next level;
		BFS(root.left, res, level + 1);
		BFS(root.right, res, level + 1);

		// Step 3: add root.val to current level
		res.get(level).add(root.val);
		return res;
	}

	public static void main(String[] args){
		LC102 x = new LC102();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer> > res = x.levelOrder2(root);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
	}
}