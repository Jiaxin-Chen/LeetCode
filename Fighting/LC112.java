/*
112. Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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

public class LC112{
	// Iterative Version:
	// Time Complexity: O(MN)
	// Runtime: 2ms, beats 7.59%
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null)
			return false;
		// Corner case: [1], sum = 1
	/*	if(root.left == null && root.right == null && root.val == sum)
			return true;
			*/

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while(!queue.isEmpty()){
			int width = queue.size();
			for(int i = 0; i < width; i++){
				TreeNode node = queue.poll();
				// Corner case: [1, 2, null, 3, null, 4, null, 5], sum = 6
				if(node.left == null && node.right == null && node.val == sum)
					return true;
				if(node.left != null){
					node.left.val += node.val;
					queue.offer(node.left);
				}
				if(node.right != null){
					node.right.val += node.val;
					queue.offer(node.right);
				}
			}
		}
		return false;
	}

	//Recursive Version:
	//Time Complexity: O(2^N)
	//Runtime: 1ms, beats 14.64%
	public boolean hasPathSum2(TreeNode root, int sum){
		if(root == null)
			return false;
		if(root.left == null && root.right == null && sum - root.val == 0)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}