/*
226. Invert Binary Tree

Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
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

public class LC226{
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 27.67%
	public TreeNode invertTree(TreeNode root){
		if(root == null)
			return root;

		TreeNode left = root.left, right = root.right;
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}


	// BFS
	// Time Complexity: O(N)
	// Runtime: 0ms, beats 27.67%
	public TreeNode invertTree2(TreeNode root){
		if(root == null)
			return root;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
				TreeNode tmp = node.left;
				node.left = node.right; 
				node.right = tmp;

				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
		}
		return root;
	}
}